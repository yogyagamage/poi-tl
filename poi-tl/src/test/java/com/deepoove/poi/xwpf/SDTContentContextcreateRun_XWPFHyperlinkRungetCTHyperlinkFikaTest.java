package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

class SDTContentContextcreateRun_XWPFHyperlinkRungetCTHyperlinkFikaTest {

    @Test
    void testCreateRunInvokesGetCTHyperlink() throws Exception {
        XWPFStructuredDocumentTagContent content = Mockito.mock(XWPFStructuredDocumentTagContent.class);
        SDTContentContext context = new SDTContentContext(content);
        
        XWPFHyperlinkRun hyperlinkRun = Mockito.mock(XWPFHyperlinkRun.class);
        IRunBody runBody = Mockito.mock(IRunBody.class);
        
        CTHyperlink ctHyperlink = CTHyperlink.Factory.newInstance();
        CTR ctr = CTR.Factory.newInstance();
        
        Mockito.when(hyperlinkRun.getCTHyperlink()).thenReturn(ctHyperlink);
        Mockito.when(hyperlinkRun.getCTR()).thenReturn(ctr);
        
        context.createRun(hyperlinkRun, runBody);
    }
}
