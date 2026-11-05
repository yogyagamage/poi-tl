package com.deepoove.poi.resolver;

import org.junit.jupiter.api.Test;
import javax.xml.namespace.QName;

public class RunningRunBodymethod_QNamemethodFikaTest2 {

    @Test
    public void testQNameConstructorInvocation() {
        // This will trigger the static initializer in RunningRunBody
        // which creates QName objects using the target constructor
        Class<?> clazz = RunningRunBody.class;
        
        // Force class loading to trigger static initialization
        try {
            Class.forName(clazz.getName());
        } catch (ClassNotFoundException e) {
            // This should never happen since we're referencing the class directly
        }
    }
}
