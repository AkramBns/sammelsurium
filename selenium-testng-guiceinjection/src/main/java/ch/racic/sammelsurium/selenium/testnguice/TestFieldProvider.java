/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.selenium.testnguice;

import com.google.inject.Provider;

/**
 * Created by rac on 05.04.15.
 */
public class TestFieldProvider implements Provider<TestField> {

    ThreadLocal<TestField> testField;

    public TestFieldProvider() {
        testField = new ThreadLocal<TestField>();
    }

    public TestField get() {
        if (testField.get() == null)
            testField.set(new TestField(Thread.currentThread().getName() + " " + Thread.currentThread().getId()));
        return testField.get();
    }
}
