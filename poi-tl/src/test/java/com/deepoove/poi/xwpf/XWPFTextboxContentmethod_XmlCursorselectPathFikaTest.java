package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.apache.xmlbeans.XmlCursor;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFSDT;
import java.util.ArrayList;
import java.util.List;

public class XWPFTextboxContentmethod_XmlCursorselectPathFikaTest {

    @Test
    public void testEntryPoint() throws Exception {
        CTTxbxContent ctTxbxContent = CTTxbxContent.Factory.newInstance();
        XWPFRun run = Mockito.mock(XWPFRun.class);
        IBody part = Mockito.mock(IBody.class);
        XmlObject xmlObject = Mockito.mock(XmlObject.class);
        
        new XWPFTextboxContent(ctTxbxContent, run, part, xmlObject);
    }
}
