package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.xwpf.XWPFShadingPattern;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StyleUtilsretriveParagraphStyle_CTPBdrgetBottomFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesCTPBdrGetBottom() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = mock(XWPFParagraph.class);
        
        // Create real CTP object using XmlObject factory
        CTP ctp = CTP.Factory.newInstance();
        CTPPr ppr = ctp.addNewPPr();
        CTPBdr pBdr = ppr.addNewPBdr();
        CTBorder bottomBorder = pBdr.addNewBottom();
        
        // Configure paragraph mock to return the CTP
        when(paragraph.getCTP()).thenReturn(ctp);
        when(paragraph.isWordWrapped()).thenReturn(false);
        when(paragraph.getAlignment()).thenReturn(ParagraphAlignment.LEFT);
        when(paragraph.getSpacingBeforeLines()).thenReturn(-1);
        when(paragraph.getSpacingAfterLines()).thenReturn(-1);
        when(paragraph.getSpacingBefore()).thenReturn(-1);
        when(paragraph.getSpacingAfter()).thenReturn(-1);
        when(paragraph.getSpacingBetween()).thenReturn(-1.0);
        
        // Invoke the entry point method
        StyleUtils.retriveParagraphStyle(paragraph);
        
        // The execution path will invoke pBdr.getBottom() when checking ct.isSetBottom()
        // No assertions needed as per requirements
    }
}
