package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;

public class XWPFParagraphWrappermethod_QNamemethodFikaTest2 {

    @Test
    public void testQNameConstructorInvocation() {
        // Accessing the static fields will trigger the static initializer
        // which contains the QName constructor calls
        XWPFParagraphWrapper wrapper = null; // Not needed for static initialization
        
        // Trigger class loading and static initialization
        Class<?> clazz = XWPFParagraphWrapper.class;
        
        // Access one of the static fields to ensure initialization
        Object hyperQName = XWPFParagraphWrapper.HYPER_QNAME;
        Object fldSimpleQName = XWPFParagraphWrapper.FLDSIMPLE_QNAME;
        Object rQName = XWPFParagraphWrapper.R_QNAME;
        Object bookmarkStartQName = XWPFParagraphWrapper.BOOKMARK_START_QNAME;
        Object bookmarkEndQName = XWPFParagraphWrapper.BOOKMARK_END_QNAME;
        Object commentStartQName = XWPFParagraphWrapper.COMMENT_START_QNAME;
        Object commentEndQName = XWPFParagraphWrapper.COMMENT_END_QNAME;
        Object runQNameSet = XWPFParagraphWrapper.RUN_QNAME_SET;
    }
}
