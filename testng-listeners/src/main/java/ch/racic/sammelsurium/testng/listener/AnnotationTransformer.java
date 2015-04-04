/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.testng.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IAnnotationTransformer2;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by rac on 23.09.14.
 */
public class AnnotationTransformer implements IAnnotationTransformer2 {

    private static final Logger log = LogManager.getLogger(AnnotationTransformer.class);

    public void transform(IConfigurationAnnotation iConfigurationAnnotation, Class aClass, Constructor constructor, Method method) {
        log.entry(iConfigurationAnnotation, aClass, constructor, method);
    }

    public void transform(IDataProviderAnnotation iDataProviderAnnotation, Method method) {
        log.entry(iDataProviderAnnotation, method);
    }

    public void transform(IFactoryAnnotation iFactoryAnnotation, Method method) {
        log.entry(iFactoryAnnotation, method);
    }

    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        log.entry(iTestAnnotation, aClass, constructor, method);
    }
}
