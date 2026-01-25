package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFFieldRun;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParagraphContextcreateRun_XWPFFieldRungetCTFieldFikaTest {

    @Test
    public void testCreateRunWithXWPFFieldRun() throws Exception {
        XWPFParagraphWrapper paragraphWrapper = mock(XWPFParagraphWrapper.class);
        ParagraphContext paragraphContext = new ParagraphContext(paragraphWrapper);
        
        XWPFFieldRun fieldRun = mock(XWPFFieldRun.class);
        IRunBody runBody = mock(IRunBody.class);
        
        CTR ctr = CTR.Factory.newInstance();
        CTSimpleField ctField = CTSimpleField.Factory.newInstance();
        
        when(fieldRun.getCTField()).thenReturn(ctField);
        when(fieldRun.getCTR()).thenReturn(ctr);
        
        paragraphContext.createRun(fieldRun, runBody);
    }
}
