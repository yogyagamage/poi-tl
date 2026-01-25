package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstylePpr_XWPFParagraphsetAlignmentFikaTest {

    @Test
    public void testStylePprInvokesSetAlignment() {
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        ParagraphStyle style = Mockito.mock(ParagraphStyle.class);
        
        Mockito.when(style.getAlign()).thenReturn(ParagraphAlignment.CENTER);
        Mockito.when(paragraph.getCTP()).thenReturn(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance());
        
        StyleUtils.stylePpr(paragraph, style);
    }
}
