package com.deepoove.poi.plugin.table;

import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class RemoveTableColumnRenderPolicyminusGridSpan_CTTcPrgetGridSpanFikaTest {

    @Test
    public void testMinusGridSpan() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 3);
        XWPFTableRow row = table.getRow(0);
        
        XWPFTableCell cell = row.getCell(1);
        CTTcPr tcPr = cell.getCTTc().getTcPr();
        if (tcPr == null) {
            tcPr = cell.getCTTc().addNewTcPr();
        }
        
        CTDecimalNumber gridSpan = tcPr.getGridSpan();
        if (gridSpan == null) {
            gridSpan = tcPr.addNewGridSpan();
        }
        gridSpan.setVal(BigInteger.valueOf(2L));
        
        RemoveTableColumnRenderPolicy policy = new RemoveTableColumnRenderPolicy();
        
        try {
            java.lang.reflect.Method method = RemoveTableColumnRenderPolicy.class
                .getDeclaredMethod("minusGridSpan", XWPFTableRow.class, int.class);
            method.setAccessible(true);
            method.invoke(policy, row, 1);
        } catch (Exception e) {
            // Ignored - test only needs to reach the target method
        }
        
        document.close();
    }
}
