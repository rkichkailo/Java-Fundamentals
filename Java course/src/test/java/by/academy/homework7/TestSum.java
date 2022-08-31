package by.academy.homework7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)

public class TestSum extends Assert {

    final private int valueA;
    final private int valueB;
    final private int expected;

    public TestSum(int valueA, int valueB, int valueC) {
        this.valueA = valueA;
        this.valueB = valueB;
        this.expected = valueC;
    }
    @Parameterized.Parameters (name="{index}: sum{0} and {1} = {2}")
    public static Iterable<Integer[]>dataForTest(){
        return Arrays.asList(
                new Integer[][]{
                        {11,2,13,},
                        {123,134,257,},
                        {2,6,8,}}
        );
    }
    @Test
    public void paramTest(){
        assertEquals(expected, Calc.sum(valueA,valueB));
    }
}
