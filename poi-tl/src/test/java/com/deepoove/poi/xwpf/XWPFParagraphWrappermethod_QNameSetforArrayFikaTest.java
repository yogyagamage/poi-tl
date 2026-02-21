package com.deepoove.poi.xwpf;

import org.apache.xmlbeans.QNameSet;
import org.junit.jupiter.api.Test;
import javax.xml.namespace.QName;

public class XWPFParagraphWrappermethod_QNameSetforArrayFikaTest {

    @Test
    public void testRunQNameSetInitialization() {
        // Directly trigger the static initialization of RUN_QNAME_SET
        // which calls QNameSet.forArray()
        QNameSet set = XWPFParagraphWrapper.RUN_QNAME_SET;
    }
}
