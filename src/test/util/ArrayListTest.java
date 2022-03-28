package test.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 世墨
 * @Date: 2022/3/27 19:53
 * @DESCRIPTION
 */
public class ArrayListTest {
    @Test
    void test_arrayList(){
        List<Object> objects = new ArrayList<>();
        //返回的是旧的元素
        Object set = objects.set(1, new Object());
    }
}
