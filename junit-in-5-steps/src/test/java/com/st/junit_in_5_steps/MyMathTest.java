package com.st.junit_in_5_steps;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyMathTest {

    @Test
    void calculateSumTest(){
        int[] numbers={1,2,3};
        MyMath myMath=new MyMath();
        int result=myMath.calculateSum(numbers);
        int expectedResult=6;
        assertEquals(expectedResult,result);
    }
}
