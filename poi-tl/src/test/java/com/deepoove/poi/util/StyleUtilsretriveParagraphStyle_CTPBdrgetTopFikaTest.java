package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.xwpf.XWPFShadingPattern;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayOutputStream;

public class StyleUtilsretriveParagraphStyle_CTPBdrgetTopFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        CTPBdr border = ppr.addNewPBdr();
        CTBorder topBorder = border.addNewTop();
        topBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.Enum.forString("single"));
        
        ParagraphStyle result = StyleUtils.retriveParagraphStyle(paragraph);
        
        document.close();
    }
}
