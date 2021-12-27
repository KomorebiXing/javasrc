package test.lang;

import org.junit.Test;

/**
 * @Author: 世墨
 * @Date: 2021/12/7 15:12
 * @DESCRIPTION
 */
public class TestLong {

    @Test
    public void TestToString(){
        //toString 两个重载的方法
        String s = Long.toString(1000000000);
        //此方法底层 如果是10进制还是调用的 toString方法，如果不是，则实现另外的逻辑
        String s1 = Long.toString(10,10);
        //两个方法的底层最终都会去调用String的构造方法 ---->  new String（）
    }

    @Test
    public void TesttoUnsignedString(){
        //重载方法  无符号转化为String
        String s = Long.toUnsignedString(-12312); //默认就是10进制 调用的是下面的方法
        String s2 = Long.toUnsignedString(-8,2); //如果是大于0，那么直接调用toString方法 否则根据传入的redix来单独走各自的逻辑
    }

    @Test
    public void TestGetLong(){
        Long aLong = Long.getLong("java.version");
        String property = System.getProperty("os.name");
        Long aLong1 = Long.valueOf("12");
    }
}
