package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.xwpf.XWPFShadingPattern;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;

import static org.mockito.Mockito.*;

public class StyleUtilsretriveParagraphStyle_CTPBdrgetRightFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesCTPBdrGetRight() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = mock(XWPFParagraph.class);
        
        // Create real CTP object
        CTP ctp = CTP.Factory.newInstance();
        
        // Create real CTPPr object
        CTPPr pr = ctp.addNewPPr();
        
        // Create real CTPBdr object
        CTPBdr ct = pr.addNewPBdr();
        
        // Create real CTBorder for right border
        CTBorder rightBorder = ct.addNewRight();
        
        // Configure paragraph mock to return real objects
        when(paragraph.getCTP()).thenReturn(ctp);
        when(paragraph.isWordWrapped()).thenReturn(false);
        when(paragraph.getAlignment()).thenReturn(null);
        when(paragraph.getSpacingBeforeLines()).thenReturn(-1);
        when(paragraph.getSpacingAfterLines()).thenReturn(-1);
        when(paragraph.getSpacingBefore()).thenReturn(-1);
        when(paragraph.getSpacingAfter()).thenReturn(-1);
        when(paragraph.getSpacingBetween()).thenReturn(-1.0);
        when(paragraph.getSpacingLineRule()).thenReturn(null);
        
        // Call the entry point method
        StyleUtils.retriveParagraphStyle(paragraph);
        
        // The call chain will execute: retriveParagraphStyle -> paragraph.getCTP() -> ctp.getPPr() 
        // -> pr.getPBdr() -> ct.getRight() which is the target third-party method
    }
}
