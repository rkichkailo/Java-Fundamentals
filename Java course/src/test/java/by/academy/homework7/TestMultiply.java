package by.academy.homework7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;


@RunWith(value = Parameterized.class)

public class TestMultiply extends Assert{

    final private int valueA;
    final private int valueB;
    final private int expected;

    public TestMultiply(int valueA, int valueB, int valueC) {
        this.valueA = valueA;
        this.valueB = valueB;
        this.expected = valueC;
    }
    @Parameterized.Parameters (name="{index}: multiply {0} and {1} = {2}")
    public static Iterable<Integer[]>dataForTest(){
        return Arrays.asList(
                new Integer[][]{
                        {2,2,4,},
                        {3,6,18,},
                        {5,7,35,}}
        );
    }
    @Test
    public void paramTest(){
        assertEquals(expected, Calc.multiply(valueA,valueB));
    }
}
