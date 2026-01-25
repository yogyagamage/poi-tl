package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.TableWidthType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TableToolssetWidth_XWPFTableRowgetCellFikaTest {

    @Test
    public void testSetWidthPathToGetCell() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 3);
        
        CTTbl ctTbl = table.getCTTbl();
        CTTblPr tblPr = ctTbl.getTblPr();
        if (tblPr == null) {
            tblPr = ctTbl.addNewTblPr();
        }
        CTTblWidth tblWidth = tblPr.addNewTblW();
        tblWidth.setType(STTblWidth.DXA);
        tblWidth.setW(BigInteger.valueOf(5000));
        
        CTTblGrid grid = ctTbl.addNewTblGrid();
        grid.addNewGridCol().setW(BigInteger.valueOf(1000));
        grid.addNewGridCol().setW(BigInteger.valueOf(2000));
        grid.addNewGridCol().setW(BigInteger.valueOf(2000));
        
        List<XWPFTableRow> rows = table.getRows();
        for (XWPFTableRow row : rows) {
            for (int i = 0; i < 3; i++) {
                if (row.getCell(i) == null) {
                    row.createCell();
                }
            }
        }
        
        int[] colWidths = new int[]{1000, 2000, 2000};
        TableTools.setWidth(table, "5000", colWidths);
    }
}
