package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

public class SDTContentContextcreateRun_XWPFHyperlinkRunmethodFikaTest {

    @Test
    public void testCreateRunInvokesXWPFHyperlinkRunConstructor() throws Exception {
        XWPFStructuredDocumentTagContent mockContent = Mockito.mock(XWPFStructuredDocumentTagContent.class);
        SDTContentContext context = new SDTContentContext(mockContent);
        
        CTHyperlink ctHyperlink = CTHyperlink.Factory.newInstance();
        CTR ctr = ctHyperlink.addNewR();
        IRunBody mockRunBody = Mockito.mock(IRunBody.class);
        
        context.createRun(ctHyperlink, mockRunBody);
    }
}
