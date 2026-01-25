package com.deepoove.poi.policy;

import com.deepoove.poi.data.BookmarkTextRenderData;
import com.deepoove.poi.data.HyperlinkTextRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.policy.TextRenderPolicy.Helper;
import com.deepoove.poi.util.StyleUtils;
import com.deepoove.poi.util.TableTools;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class HelperrenderTextRun_XWPFRunsetTextFikaTest2 {

    @Test
    public void test() throws Exception {
        // Create mock XWPFRun with proper CT_R object
        XWPFRun mockRun = mock(XWPFRun.class, Mockito.RETURNS_DEEP_STUBS);
        
        // Create TextRenderData with text that will trigger the setText call
        TextRenderData data = new TextRenderData("test text");
        
        // Call the entry point method
        Helper.renderTextRun(mockRun, data);
        
        // The test will execute the full chain and reach XWPFRun.setText(String, int)
        // No assertions needed as per requirements
    }
}
