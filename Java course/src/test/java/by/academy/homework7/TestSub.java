package by.academy.homework7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)

public class TestSub extends Assert {

    final private int valueA;
    final private int valueB;
    final private int expected;

    public TestSub(int valueA, int valueB, int valueC) {
        this.valueA = valueA;
        this.valueB = valueB;
        this.expected = valueC;
    }
    @Parameterized.Parameters (name="{index}: subtraction {0} and {1} = {2}")
    public static Iterable<Integer[]>dataForTest(){
        return Arrays.asList(
                new Integer[][]{
                        {5,2,3,},
                        {1,1,0,},
                        {60,6,54,}}
        );
    }
    @Test
    public void paramTest(){
        assertEquals(expected, Calc.sub(valueA,valueB));
    }
}
