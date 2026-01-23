package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFFieldRun;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlObject;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;

import static org.mockito.Mockito.mock;

public class ParagraphContextcreateRun_XWPFFieldRunmethodFikaTest {

    @Test
    public void testCreateRunInvokesXWPFFieldRunConstructor() throws Exception {
        XWPFParagraphWrapper paragraphWrapper = mock(XWPFParagraphWrapper.class);
        ParagraphContext paragraphContext = new ParagraphContext(paragraphWrapper);
        
        CTSimpleField ctSimpleField = CTSimpleField.Factory.newInstance();
        CTR ctr = CTR.Factory.newInstance();
        ctSimpleField.setRArray(new CTR[]{ctr});
        
        IRunBody runBody = mock(IRunBody.class);
        
        paragraphContext.createRun(ctSimpleField, runBody);
    }
}
