package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblLayoutType;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class TableToolssetWidth_XWPFTablegetRowsFikaTest {

    @Test
    public void testSetWidthInvokesGetRows() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 3);
        
        CTTbl ctTbl = table.getCTTbl();
        CTTblPr tblPr = ctTbl.getTblPr();
        if (tblPr == null) {
            tblPr = ctTbl.addNewTblPr();
        }
        CTTblWidth tblWidth = tblPr.getTblW();
        if (tblWidth == null) {
            tblWidth = tblPr.addNewTblW();
        }
        tblWidth.setType(STTblWidth.DXA);
        tblWidth.setW(BigInteger.valueOf(5000));
        
        CTTblGrid tblGrid = ctTbl.getTblGrid();
        if (tblGrid == null) {
            tblGrid = ctTbl.addNewTblGrid();
        }
        for (int i = 0; i < 3; i++) {
            CTTblGridCol gridCol = tblGrid.addNewGridCol();
            gridCol.setW(BigInteger.valueOf(1000));
        }
        
        CTTblLayoutType layoutType = tblPr.getTblLayout();
        if (layoutType == null) {
            layoutType = tblPr.addNewTblLayout();
        }
        layoutType.setType(STTblLayoutType.FIXED);
        
        int[] colWidths = new int[]{1000, 2000, 2000};
        
        TableTools.setWidth(table, "5000", colWidths);
        
        document.close();
    }
}
