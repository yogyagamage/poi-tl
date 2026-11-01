package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class XWPFParagraphWrapperinsertNewHyperLinkRun_PackagePartaddExternalRelationshipFikaTest {

    @Test
    public void testInsertNewHyperLinkRun() throws Exception {
        // Create real document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create wrapper instance
        Object wrapper = createWrapperInstance(paragraph);
        
        // Invoke the method with valid parameters
        java.lang.reflect.Method method = wrapper.getClass().getDeclaredMethod(
            "insertNewHyperLinkRun", int.class, String.class);
        method.setAccessible(true);
        method.invoke(wrapper, 0, "http://example.com");
        
        document.close();
    }
    
    private Object createWrapperInstance(XWPFParagraph paragraph) throws Exception {
        // Use reflection to create instance since we don't have the actual class
        Class<?> wrapperClass = Class.forName("com.deepoove.poi.xwpf.XWPFParagraphWrapper");
        java.lang.reflect.Constructor<?> constructor = wrapperClass.getDeclaredConstructor(XWPFParagraph.class);
        constructor.setAccessible(true);
        return constructor.newInstance(paragraph);
    }
}
