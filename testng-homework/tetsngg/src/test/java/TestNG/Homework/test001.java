package TestNG.Homework;

import TestNG.Homework.RetryCountIfFailed;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test001 {

    @Test
    @RetryCountIfFailed(10)
    public void test1()
    {
        Assert.assertEquals(false, true);
    }

    @Test
    public void test2()
    {
        Assert.assertEquals(false, true);
    }
}