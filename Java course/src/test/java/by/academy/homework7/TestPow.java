package by.academy.homework7;

import org.junit.Assert;
import org.junit.Test;

public class TestPow {

    @Test
    public void testPow(){
        Assert.assertEquals(25, Math.pow(5, 2), 1);
    }
}
