package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;

public class StyleUtilsstyleRun_XWPFRunsetUnderlineColorFikaTest {

    @Test
    public void testStyleRunInvokesSetUnderlineColor() throws Exception {
        CTR ctr = CTR.Factory.newInstance();
        ctr.addNewRPr();
        XWPFRun run = new XWPFRun(ctr, null);
        
        Style style = new Style();
        style.setUnderlinePatterns(UnderlinePatterns.SINGLE);
        style.setUnderlineColor("FF0000");
        
        StyleUtils.styleRun(run, style);
    }
}
