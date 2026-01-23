package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.TableWidthType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class TableToolsmergeCellsHorizontalWithoutRemove_CTDecimalNumbersetValFikaTest {

    @Test
    public void testMergeCellsHorizontalWithoutRemove() throws Exception {
        XWPFTable table = Mockito.mock(XWPFTable.class);
        XWPFTableRow row = Mockito.mock(XWPFTableRow.class);
        XWPFTableCell cell1 = Mockito.mock(XWPFTableCell.class);
        XWPFTableCell cell2 = Mockito.mock(XWPFTableCell.class);
        
        CTTc ctTc1 = CTTc.Factory.newInstance();
        CTTcPr tcPr = ctTc1.addNewTcPr();
        
        Mockito.when(table.getRow(0)).thenReturn(row);
        Mockito.when(row.getCell(0)).thenReturn(cell1);
        Mockito.when(row.getCell(1)).thenReturn(cell2);
        
        Mockito.when(cell1.getCTTc()).thenReturn(ctTc1);
        Mockito.when(cell1.getWidthType()).thenReturn(TableWidthType.DXA);
        Mockito.when(cell1.getWidth()).thenReturn(100);
        
        Mockito.when(cell2.getWidthType()).thenReturn(TableWidthType.DXA);
        Mockito.when(cell2.getWidth()).thenReturn(200);
        
        TableTools.mergeCellsHorizontalWithoutRemove(table, 0, 0, 1);
    }
}
