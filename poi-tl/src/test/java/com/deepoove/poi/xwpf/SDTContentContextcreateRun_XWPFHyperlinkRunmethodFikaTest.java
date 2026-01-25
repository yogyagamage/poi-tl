package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

public class SDTContentContextcreateRun_XWPFHyperlinkRunmethodFikaTest {

    @Test
    public void testCreateRunInvokesXWPFHyperlinkRunConstructor() throws Exception {
        XWPFStructuredDocumentTagContent paragraphWrapper = Mockito.mock(XWPFStructuredDocumentTagContent.class);
        SDTContentContext context = new SDTContentContext(paragraphWrapper);
        
        XWPFHyperlinkRun hyperlinkRun = Mockito.mock(XWPFHyperlinkRun.class);
        CTHyperlink ctHyperlink = CTHyperlink.Factory.newInstance();
        CTR ctr = CTR.Factory.newInstance();
        
        Mockito.when(hyperlinkRun.getCTHyperlink()).thenReturn(ctHyperlink);
        Mockito.when(hyperlinkRun.getCTR()).thenReturn(ctr);
        
        IRunBody runBody = Mockito.mock(IRunBody.class);
        
        context.createRun(hyperlinkRun, runBody);
    }
}
