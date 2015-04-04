/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.testng.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Created by rac on 27.10.14.
 */
public class SuiteListener implements ISuiteListener {

    private static final Logger log = LogManager.getLogger(SuiteListener.class);

    /**
     * This method is invoked before the SuiteRunner starts.
     *
     * @param suite
     */
    public void onStart(ISuite suite) {
        log.entry(suite);
    }

    /**
     * This method is invoked after the SuiteRunner has run all the test suites.
     *
     * @param suite
     */
    public void onFinish(ISuite suite) {
        log.entry(suite);
    }
}
