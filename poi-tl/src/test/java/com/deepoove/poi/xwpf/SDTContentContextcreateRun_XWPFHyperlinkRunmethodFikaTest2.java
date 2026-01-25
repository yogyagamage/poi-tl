package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

class SDTContentContextcreateRun_XWPFHyperlinkRunmethodFikaTest2 {

    @Test
    void testCreateRunInvokesXWPFHyperlinkRunConstructor() throws Exception {
        XWPFStructuredDocumentTagContent paragraphWrapper = Mockito.mock(XWPFStructuredDocumentTagContent.class);
        SDTContentContext context = new SDTContentContext(paragraphWrapper);
        
        CTHyperlink ctHyperlink = CTHyperlink.Factory.newInstance();
        CTR ctr = CTR.Factory.newInstance();
        ctHyperlink.setRArray(new CTR[]{ctr});
        
        IRunBody runBody = Mockito.mock(IRunBody.class);
        
        context.createRun(ctHyperlink, runBody);
    }
}
