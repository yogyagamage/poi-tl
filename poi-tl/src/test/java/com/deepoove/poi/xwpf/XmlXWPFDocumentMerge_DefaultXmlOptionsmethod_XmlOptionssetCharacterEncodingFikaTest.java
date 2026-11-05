package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;

public class XmlXWPFDocumentMerge_DefaultXmlOptionsmethod_XmlOptionssetCharacterEncodingFikaTest {

    @Test
    public void testDefaultXmlOptionsInitialization() {
        // Accessing the static field will trigger the static initializer
        // which contains the call to XmlOptions.setCharacterEncoding("UTF-8")
        DefaultXmlOptions.OPTIONS_INNER.toString();
    }
}
