package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TableToolssetWidth_CTTblGridaddNewGridColFikaTest {

    @Test
    public void testSetWidthInvokesAddNewGridCol() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 3);
        
        CTTbl ctTbl = CTTbl.Factory.newInstance();
        CTTblGrid tblGrid = ctTbl.addNewTblGrid();
        CTTblGridCol gridCol = tblGrid.addNewGridCol();
        gridCol.setW(BigInteger.valueOf(1000));
        
        int[] colWidths = new int[]{1000, 2000, 3000};
        TableTools.setWidth(table, "5000", colWidths);
        
        document.close();
    }
}
