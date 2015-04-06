/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.selenium.testnguice;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

/**
 * Created by rac on 05.04.15.
 */
@Guice(modules = TestModule.class)
public class TestFieldTest {

    private static final Logger log = LogManager.getLogger(TestFieldTest.class);

    @Inject
    TestField tf;

    Injector page = com.google.inject.Guice.createInjector(new TestModule());

    @Test
    public void simpleTest() {
        log.debug("Field in test class: " + tf.getId());
        ObjectWithTestField otf = page.getInstance(ObjectWithTestField.class);
        log.debug("Field in object: " + otf.getTestFieldId());
    }

    @Test
    public void simpleTest2() {
        log.debug("Field in test class: " + tf.getId());
        ObjectWithTestField otf = page.getInstance(ObjectWithTestField.class);
        log.debug("Field in object: " + otf.getTestFieldId());
    }

    @Test
    public void simpleTest3() {
        log.debug("Field in test class: " + tf.getId());
        ObjectWithTestField otf = page.getInstance(ObjectWithTestField.class);
        log.debug("Field in object: " + otf.getTestFieldId());
    }

}
