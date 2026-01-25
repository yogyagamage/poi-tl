package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFFieldRun;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SDTContentContextcreateRun_XWPFFieldRunmethodFikaTest {

    @Test
    public void testCreateRunInvokesXWPFFieldRunConstructor() throws Exception {
        XWPFStructuredDocumentTagContent paragraphWrapper = Mockito.mock(XWPFStructuredDocumentTagContent.class);
        SDTContentContext sdtContentContext = new SDTContentContext(paragraphWrapper);
        
        CTSimpleField ctSimpleField = CTSimpleField.Factory.newInstance();
        CTR ctr = CTR.Factory.newInstance();
        ctSimpleField.setRArray(new CTR[]{ctr});
        
        IRunBody runBody = Mockito.mock(IRunBody.class);
        
        sdtContentContext.createRun(ctSimpleField, runBody);
    }
}
