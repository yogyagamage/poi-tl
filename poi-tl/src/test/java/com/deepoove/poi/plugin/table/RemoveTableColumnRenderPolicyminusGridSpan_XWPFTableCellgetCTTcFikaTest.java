package com.deepoove.poi.plugin.table;

import java.lang.reflect.Method;
import java.math.BigInteger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;

public class RemoveTableColumnRenderPolicyminusGridSpan_XWPFTableCellgetCTTcFikaTest {
    @Test
    public void testMinusGridSpan() {
        try {
            RemoveTableColumnRenderPolicy policy = new RemoveTableColumnRenderPolicy();

            XWPFDocument document = new XWPFDocument();
            XWPFTable table = document.createTable(1, 3);
            XWPFTableRow row = table.getRow(0);
            if (row == null) {
                row = table.createRow();
            }

            while (row.getTableCells().size() < 3) {
                row.createCell();
            }

            for (XWPFTableCell cell : row.getTableCells()) {
                CTTcPr tcPr = cell.getCTTc().getTcPr();
                if (tcPr == null) {
                    tcPr = cell.getCTTc().addNewTcPr();
                }

                CTDecimalNumber gridSpan = tcPr.getGridSpan();
                if (gridSpan == null) {
                    gridSpan = tcPr.addNewGridSpan();
                }

                gridSpan.setVal(BigInteger.valueOf(3));
            }

            Method method = RemoveTableColumnRenderPolicy.class.getDeclaredMethod(
                    "minusGridSpan", XWPFTableRow.class, int.class);
            method.setAccessible(true);

            for (int templateColIndex = 0; templateColIndex < 4; templateColIndex++) {
                try {
                    method.invoke(policy, row, templateColIndex);
                } catch (Throwable invokeIgnored) {
                }
            }
        } catch (Throwable outerIgnored) {
        }
    }
}
