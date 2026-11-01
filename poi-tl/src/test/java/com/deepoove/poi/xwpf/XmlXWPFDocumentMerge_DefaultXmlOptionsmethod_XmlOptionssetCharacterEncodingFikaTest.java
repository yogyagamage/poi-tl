package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;

public class XmlXWPFDocumentMerge_DefaultXmlOptionsmethod_XmlOptionssetCharacterEncodingFikaTest {

    @Test
    public void testDefaultXmlOptionsStaticInitializer() {
        // Accessing the class will trigger static initialization
        // which includes the call to XmlOptions.setCharacterEncoding("UTF-8")
        Class<DefaultXmlOptions> clazz = DefaultXmlOptions.class;
        
        // Force class initialization if not already done
        try {
            Class.forName("com.deepoove.poi.xwpf.DefaultXmlOptions");
        } catch (ClassNotFoundException e) {
            // Should not happen since we're in the same package
        }
    }
}
