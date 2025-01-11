package com.st.junit_in_5_steps;

public class MyMath {

    public int calculateSum(int[] input){
        int sum=0;
        for (int number:input
             ) {
            sum+=number;

        }
        return sum;
    }
}
