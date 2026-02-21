package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import com.deepoove.poi.xwpf.XWPFShadingPattern;
import com.deepoove.poi.xwpf.XWPFOnOff;
import com.deepoove.poi.util.UnitUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPBdrisSetBottomFikaTest {

    @Test
    public void testIsSetBottomInvocation() throws Exception {
        // Create a real ParagraphStyle with bottom border
        ParagraphStyle style = new ParagraphStyle();
        BorderStyle bottomBorder = new BorderStyle();
        style.setBottomBorder(bottomBorder);
        
        // Create a mock XWPFParagraph that returns real CTP objects
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create real CTP object chain
        CTP ctp = CTP.Factory.newInstance();
        CTPPr ppr = ctp.addNewPPr();
        CTInd ind = ppr.addNewInd();
        CTPBdr pBdr = ppr.addNewPBdr();
        
        // Set up the mock to return our real objects
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        
        // Invoke the method under test
        StyleUtils.stylePpr(paragraph, style);
    }
}
