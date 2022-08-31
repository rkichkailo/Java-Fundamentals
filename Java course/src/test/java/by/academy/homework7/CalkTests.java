package by.academy.homework7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TestRunner.class)
public class CalkTests {

    @Test
    public void testSum(){
        Assert.assertEquals(4, Calc.sum(2, 2));
    }
    @Test
    public void testDivide(){
        Assert.assertEquals(1.0, Calc.divide(2, 2), 1.0);
    }
    @Test
    public void testMultiply(){
        Assert.assertEquals(4, Calc.multiply(2, 2), 1.0);
    }
    @Test
    public void testSub(){
        Assert.assertEquals(0.0, Calc.sub(2, 2), 1.0);
    }
}
