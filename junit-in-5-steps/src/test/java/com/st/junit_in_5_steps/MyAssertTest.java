package com.st.junit_in_5_steps;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos= Arrays.asList("AWS","AZURE","DEVOPS");

    @Test
    void test(){
        boolean test=todos.contains("AWS");
        boolean test2=todos.contains("GCP");
        assertEquals(true,test);
        assertFalse(test2);
        assertArrayEquals(new int[]{1,2},new int[]{2,1});
        assertEquals(3,todos.size(),"Error Message");
        assertTrue(test);
    }
}
