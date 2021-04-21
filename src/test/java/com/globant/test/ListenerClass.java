package com.globant.test;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class ListenerClass implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("Test starting");
        //System.out.println("on test start -> " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("The test passed");
        //System.out.println("on test sucess -> " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("The test failed");
//        System.out.println("on test failure -> " + iTestResult.getName());
    }

    /*default void onTestSkipped(ITestResult result) {
    }

    default void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    default void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }*/

}
