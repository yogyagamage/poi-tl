package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TableToolswidthTable_CTTblPraddNewTblWFikaTest {

    @Test
    public void testWidthTableInvokesAddNewTblW() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        CTTbl ctTbl = CTTbl.Factory.newInstance();
        CTTblPr tblPr = ctTbl.addNewTblPr();
        CTTblGrid tblGrid = ctTbl.addNewTblGrid();
        
        java.lang.reflect.Field ctTblField = XWPFTable.class.getDeclaredField("ctTbl");
        ctTblField.setAccessible(true);
        ctTblField.set(table, ctTbl);
        
        float[] colWidths = new float[]{5.0f, 5.0f};
        
        TableTools.widthTable(table, colWidths);
    }
}
