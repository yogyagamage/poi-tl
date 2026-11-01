package com.deepoove.poi.resolver;

import com.deepoove.poi.xwpf.XWPFParagraphWrapper;
import org.junit.jupiter.api.Test;
import org.apache.xmlbeans.QNameSet;
import javax.xml.namespace.QName;

public class TemplateResolver_XWPFParagraphWrappermethod_QNameSetforArrayFikaTest {

    @Test
    public void testQNameSetForArrayInvocation() throws Exception {
        // Trigger static initialization of XWPFParagraphWrapper which calls QNameSet.forArray
        Class.forName("com.deepoove.poi.xwpf.XWPFParagraphWrapper");
        
        // Additionally, we can directly access the static field to ensure initialization
        // and potentially trigger the method call again through reflection if needed
        XWPFParagraphWrapper wrapper;
    }
}
