package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFFieldRun;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class SDTContentContextcreateRun_XWPFFieldRunmethodFikaTest {

    @Test
    public void testCreateRunInvokesXWPFFieldRunConstructor() throws Exception {
        XWPFStructuredDocumentTagContent paragraphWrapper = Mockito.mock(XWPFStructuredDocumentTagContent.class);
        SDTContentContext context = new SDTContentContext(paragraphWrapper);
        
        XWPFFieldRun fieldRun = Mockito.mock(XWPFFieldRun.class);
        IRunBody runBody = Mockito.mock(IRunBody.class);
        
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField ctSimpleField = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR ctr = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR.Factory.newInstance();
        
        when(fieldRun.getCTField()).thenReturn(ctSimpleField);
        when(fieldRun.getCTR()).thenReturn(ctr);
        
        context.createRun(fieldRun, runBody);
    }
}
