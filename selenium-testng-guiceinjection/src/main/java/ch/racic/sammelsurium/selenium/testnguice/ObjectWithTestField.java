/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.selenium.testnguice;

import com.google.inject.Inject;

/**
 * Created by rac on 05.04.15.
 */
public class ObjectWithTestField {
    @Inject
    private TestField tf;

    public String getTestFieldId() {
        return tf.getId();
    }
}
