package com.deepoove.poi.plugin.table;

import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class RemoveTableColumnRenderPolicyminusGridSpan_CTDecimalNumbersetValFikaTest {

    @Test
    public void testMinusGridSpan() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 3);
        XWPFTableRow row = table.getRow(0);
        
        XWPFTableCell cell = row.getCell(1);
        CTTc ctTc = cell.getCTTc();
        CTTcPr tcPr = ctTc.isSetTcPr() ? ctTc.getTcPr() : ctTc.addNewTcPr();
        CTDecimalNumber gridSpan = tcPr.isSetGridSpan() ? tcPr.getGridSpan() : tcPr.addNewGridSpan();
        gridSpan.setVal(BigInteger.valueOf(3));
        
        RemoveTableColumnRenderPolicy policy = new RemoveTableColumnRenderPolicy();
        
        java.lang.reflect.Method method = RemoveTableColumnRenderPolicy.class
                .getDeclaredMethod("minusGridSpan", XWPFTableRow.class, int.class);
        method.setAccessible(true);
        method.invoke(policy, row, 1);
    }
}
