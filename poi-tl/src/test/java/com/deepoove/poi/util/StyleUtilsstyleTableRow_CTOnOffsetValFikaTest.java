package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import com.deepoove.poi.xwpf.XWPFOnOff;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;

import java.lang.reflect.Method;

public class StyleUtilsstyleTableRow_CTOnOffsetValFikaTest {

    @Test
    public void testStyleTableRowInvokesCTOnOffsetVal() throws Exception {
        // Create a real XWPFDocument and table
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        
        // Create a RowStyle with repeated = true to trigger the target path
        RowStyle rowStyle = new RowStyle();
        // Use reflection to set repeated since there's no setter in provided sources
        Method setRepeatedMethod = RowStyle.class.getDeclaredMethod("setRepeated", boolean.class);
        setRepeatedMethod.setAccessible(true);
        setRepeatedMethod.invoke(rowStyle, true);
        
        // Call the entry point method
        StyleUtils.styleTableRow(row, rowStyle);
    }
}
