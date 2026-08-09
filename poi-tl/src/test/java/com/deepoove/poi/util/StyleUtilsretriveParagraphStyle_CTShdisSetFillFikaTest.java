package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.xwpf.XWPFShadingPattern;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StyleUtilsretriveParagraphStyle_CTShdisSetFillFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = mock(XWPFParagraph.class);
        
        // Create real CTP object
        CTP ctp = CTP.Factory.newInstance();
        CTPPr ppr = ctp.addNewPPr();
        
        // Create CTShd with fill set
        CTShd shd = ppr.addNewShd();
        shd.setVal(STShd.Enum.forInt(1));
        shd.setFill("FFFFFF");
        
        // Create CTPBdr with borders
        CTPBdr pBdr = ppr.addNewPBdr();
        CTBorder leftBorder = pBdr.addNewLeft();
        leftBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.Enum.forInt(1));
        CTBorder topBorder = pBdr.addNewTop();
        topBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.Enum.forInt(1));
        CTBorder rightBorder = pBdr.addNewRight();
        rightBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.Enum.forInt(1));
        CTBorder bottomBorder = pBdr.addNewBottom();
        bottomBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.Enum.forInt(1));
        
        // Configure paragraph mock
        when(paragraph.getCTP()).thenReturn(ctp);
        when(paragraph.isWordWrapped()).thenReturn(true);
        when(paragraph.getAlignment()).thenReturn(ParagraphAlignment.LEFT);
        when(paragraph.getSpacingBeforeLines()).thenReturn(100);
        when(paragraph.getSpacingAfterLines()).thenReturn(100);
        when(paragraph.getSpacingBefore()).thenReturn(100);
        when(paragraph.getSpacingAfter()).thenReturn(100);
        when(paragraph.getSpacingBetween()).thenReturn(1.0);
        when(paragraph.getSpacingLineRule()).thenReturn(LineSpacingRule.AUTO);
        
        // Execute the method - this will invoke CTShd.isSetFill()
        ParagraphStyle result = StyleUtils.retriveParagraphStyle(paragraph);
    }
}
