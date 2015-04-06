/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.selenium.testnguice;

import com.google.inject.AbstractModule;

/**
 * Created by rac on 05.04.15.
 */
public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TestField.class).toProvider(new TestFieldProvider());
    }
}
