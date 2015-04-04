/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.testng.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IExecutionListener;

/**
 * Created by rac on 14.02.15.
 */
public class ExecutionListener implements IExecutionListener {

    private static final Logger log = LogManager.getLogger(ExecutionListener.class);


    public void onExecutionStart() {
        log.entry();
    }

    public void onExecutionFinish() {
        log.entry();
    }
}
