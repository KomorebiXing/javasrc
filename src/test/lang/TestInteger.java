package test.lang;

import org.junit.Test;

/**
 * @Author: 世墨
 * @Date: 2021/12/2 22:12
 * @DESCRIPTION
 */
public class TestInteger {

    @Test
    public void Test01(){
        // Integer 只有两个有参构造 重载 一个 int 一个String  没有无参构造
        Integer integer = new Integer("1");
        String s = integer.toString();
        System.out.println(s);

    }
    @Test
    public void Test02(){
        Integer integer = new Integer("123456");
        int i = Integer.parseUnsignedInt("123456",12);
        System.out.println("解析无符号的整数：" + i);
    }
}
