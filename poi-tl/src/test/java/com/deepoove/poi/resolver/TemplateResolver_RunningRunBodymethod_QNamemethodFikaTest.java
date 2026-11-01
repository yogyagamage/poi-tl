package com.deepoove.poi.resolver;

import org.junit.jupiter.api.Test;
import javax.xml.namespace.QName;

public class TemplateResolver_RunningRunBodymethod_QNamemethodFikaTest {

    @Test
    public void testRunningRunBody() {
        // The static initializer of RunningRunBody will create QName objects
        // when the class is loaded. We need to trigger class loading.
        Class<?> clazz = RunningRunBody.class;
        
        // Access a static field to force class initialization
        // This will execute the static block containing QName constructor calls
        try {
            java.lang.reflect.Field field = clazz.getDeclaredField("qname");
            field.setAccessible(true);
            Object value = field.get(null);
        } catch (Exception e) {
            // Ignore exceptions - we just need class initialization to happen
        }
    }
}
