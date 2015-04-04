/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.testng.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by rac on 22.09.14.
 */
public class TestListener extends TestListenerAdapter {

    private static final Logger log = LogManager.getLogger(TestListener.class);

    public void onStart(ITestContext iTestContext) {
        log.entry(iTestContext);
    }

    @Override
    public void beforeConfiguration(ITestResult iTestResult) {
        log.entry(iTestResult);
    }

    @Override
    public void onConfigurationFailure(ITestResult iTestResult) {
        log.entry(iTestResult);
    }

    @Override
    public void onConfigurationSkip(ITestResult iTestResult) {
        log.entry(iTestResult);
    }

    @Override
    public void onConfigurationSuccess(ITestResult iTestResult) {
        log.entry(iTestResult);
    }

    public void onTestStart(ITestResult iTestResult) {
        log.entry(iTestResult);
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.entry(iTestResult);
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.entry(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.entry(iTestResult);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.entry(iTestResult);
    }

}
