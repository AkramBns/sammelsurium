/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.testng.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * Created by rac on 22.09.14.
 */
public class InvokedMethodListener implements IInvokedMethodListener2 {

    private static final Logger log = LogManager.getLogger(InvokedMethodListener.class);


    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult, ITestContext iTestContext) {
        log.entry(iInvokedMethod, iTestResult, iTestContext);
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult, ITestContext iTestContext) {
        log.entry(iInvokedMethod, iTestResult, iTestContext);
    }

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        log.entry(iInvokedMethod, iTestResult);
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        log.entry(iInvokedMethod, iTestResult);
    }
}
