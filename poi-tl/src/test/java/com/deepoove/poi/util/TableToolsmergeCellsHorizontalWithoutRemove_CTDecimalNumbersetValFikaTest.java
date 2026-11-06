package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.TableWidthType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class TableToolsmergeCellsHorizontalWithoutRemove_CTDecimalNumbersetValFikaTest {

    @Test
    public void testMergeCellsHorizontalWithoutRemove() throws Exception {
        // Create a mock table
        XWPFTable table = Mockito.mock(XWPFTable.class);
        
        // Create a mock row
        XWPFTableRow row = Mockito.mock(XWPFTableRow.class);
        Mockito.when(table.getRow(Mockito.anyInt())).thenReturn(row);
        
        // Create real cells with proper configuration
        XWPFTableCell fromCell = new XWPFTableCell(
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc.Factory.newInstance(),
            null, 
            null
        );
        fromCell.setWidth("1000");
        
        XWPFTableCell toCell = new XWPFTableCell(
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc.Factory.newInstance(),
            null, 
            null
        );
        toCell.setWidth("1000");
        
        // Configure row to return cells
        Mockito.when(row.getCell(0)).thenReturn(fromCell);
        Mockito.when(row.getCell(1)).thenReturn(toCell);
        
        // Execute the entry point method
        TableTools.mergeCellsHorizontalWithoutRemove(table, 0, 0, 1);
    }
}
