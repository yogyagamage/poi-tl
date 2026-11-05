package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class TableToolsborderTable_CTTblPraddNewTblBordersFikaTest {

    @Test
    public void testBorderTableInvokesAddNewTblBorders() throws Exception {
        XWPFTable mockTable = Mockito.mock(XWPFTable.class);
        org.apache.poi.xwpf.usermodel.XWPFTableRow mockRow = Mockito.mock(org.apache.poi.xwpf.usermodel.XWPFTableRow.class);
        org.apache.poi.xwpf.usermodel.XWPFTableCell mockCell = Mockito.mock(org.apache.poi.xwpf.usermodel.XWPFTableCell.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr mockCellPr = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl mockCTTbl = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr mockTblPr = mockCTTbl.addNewTblPr();

        Mockito.when(mockTable.getCTTbl()).thenReturn(mockCTTbl);
        Mockito.when(mockTable.getRow(Mockito.anyInt())).thenReturn(mockRow);
        Mockito.when(mockRow.getCell(Mockito.anyInt())).thenReturn(mockCell);
        Mockito.when(mockCell.getCTTc()).thenReturn(
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc.Factory.newInstance()
        );
        
        TableTools.borderTable(mockTable, 8);
    }
}
