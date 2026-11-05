package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class TableToolsborderTable_CTTblBordersaddNewInsideHFikaTest {

    @Test
    public void testBorderTableInvokesAddNewInsideH() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 2);
        
        CTTblPr tblPr = CTTblPr.Factory.newInstance();
        CTTblBorders tblBorders = tblPr.addNewTblBorders();
        
        tblBorders.addNewBottom();
        tblBorders.addNewLeft();
        tblBorders.addNewTop();
        tblBorders.addNewRight();
        tblBorders.addNewInsideV();
        
        TableTools.borderTable(table, 8);
    }
}
