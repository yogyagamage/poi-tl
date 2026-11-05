package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;

public class XWPFParagraphWrappermethod_QNameSetforArrayFikaTest {

    @Test
    public void testRunQNameSetInitialization() {
        // Access the static field to trigger static initialization
        QNameSet result = XWPFParagraphWrapper.RUN_QNAME_SET;
    }
}
