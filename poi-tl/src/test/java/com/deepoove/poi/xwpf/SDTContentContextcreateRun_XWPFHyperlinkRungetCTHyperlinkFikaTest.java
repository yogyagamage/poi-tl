package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

import static org.mockito.Mockito.when;

public class SDTContentContextcreateRun_XWPFHyperlinkRungetCTHyperlinkFikaTest {

    @Test
    public void testCreateRunInvokesGetCTHyperlink() throws Exception {
        XWPFStructuredDocumentTagContent paragraphWrapper = Mockito.mock(XWPFStructuredDocumentTagContent.class);
        SDTContentContext context = new SDTContentContext(paragraphWrapper);
        
        XWPFHyperlinkRun hyperlinkRun = Mockito.mock(XWPFHyperlinkRun.class);
        IRunBody runBody = Mockito.mock(IRunBody.class);
        
        CTHyperlink ctHyperlink = CTHyperlink.Factory.newInstance();
        CTR ctr = CTR.Factory.newInstance();
        
        when(hyperlinkRun.getCTHyperlink()).thenReturn(ctHyperlink);
        when(hyperlinkRun.getCTR()).thenReturn(ctr);
        
        context.createRun(hyperlinkRun, runBody);
    }
}
