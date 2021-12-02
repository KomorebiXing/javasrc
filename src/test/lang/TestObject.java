package test.lang;

import org.junit.Test;

/**
 * @Author: 世墨
 * @Date: 2021/11/30 11:13
 * @DESCRIPTION
 */
public class TestObject {

//    public static void main(String[] args) {
//        Object o = new Object();
//        o.getClass();
//    }

/*********************************************克隆********************************************/
    /**
     * 浅克隆
     * 只要数据都是基本数据类型或者String类型，可以克隆一次
     */
    @Test
    public void TestClone01() {
        Person person = new Person("jack", 22);
        Person person2 = null;
        try {
            person2 = (Person) person.clone();
//            person2.setName("Rose");
//            person2.setAge(19);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(person);
        System.out.println(person2);
        System.out.println(person.getAge() == person2.getAge()); //基本数据类型 地址都是一样的
        System.out.println(person.getName().equals(person2.getName())); // 两个都是true

    }
    /**
     * 深克隆
     * 非基本数据类型需要进行深克隆
     */
    @Test
    public void TestClone02() {

        Acount acount1 = new Acount(new Person02("Jack",21),100);
        Acount acount2 = null;
        try {
            acount2 = (Acount)acount1.clone();
//            acount2.setPerson(new Person02("Rose",20));
//            acount2.setBalance(200);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(acount1);
        System.out.println(acount2);
        System.out.println(acount1.getPerson() == acount2.getPerson());// false
        System.out.println(acount1.getPerson().equals(acount2.getPerson())); //false

    }
/*********************************************克隆********************************************/

}

/*********************************************克隆********************************************/
/**
 * 克隆
 * 1.想要进行克隆都必须实现 Cloneable 接口
 * 2.浅克隆只对类中的基本数数据类型和String 类型有效
 * 3.深克隆是针对类中的引用类型进行深clone的
 *
 *
 * 如何实现克隆分为三步：
 * 1.对象的类实现Cloneable接口；
 * 2.覆盖Object类的clone()方法 （覆盖clone()方法，访问修饰符设为public，默认是protected）；
 * 3.在clone()方法中调用super.clone()；
 *
 *
 * 浅克隆和深克隆的区别：
 * 浅克隆是指拷贝对象时仅仅拷贝对象本身（包括对象中的基本变量），而不拷贝对象包含的引用指向的对象。
 * 深克隆不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象
 */
class Person implements Cloneable {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 浅克隆
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

 class Acount implements Cloneable{
    private Person02 person02;
    private double balance;
    public Acount(Person02 person02, double balance) {
        super();
        this.person02 = person02;
        this.balance = balance;
    }
    public Acount() {
    }
    @Override
    public String toString() {
        return "Acount [person=" + person02 + ", balance=" + balance + "]";
    }
    public Person02 getPerson() {
        return person02;
    }
    public void setPerson(Person02 person02) {
        this.person02 = person02;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    //克隆，进行深克隆
    @Override
    public Object clone() throws CloneNotSupportedException {
        Acount acount = (Acount) super.clone();
        if(person02 != null){//防范空指针异常
            acount.person02 = (Person02) acount.person02.clone();
        }
        return acount;
    }
}

 class Person02 implements Cloneable{
    private String name;
    private int age;
    public Person02() {
    }
    public Person02(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

/*********************************************克隆********************************************/


