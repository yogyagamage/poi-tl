package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TableToolswidthTable_CTTblWidthsetTypeFikaTest {

    @Test
    public void testWidthTableInvokesSetType() throws Exception {
        XWPFTable table = Mockito.mock(XWPFTable.class);
        XWPFTableRow row = Mockito.mock(XWPFTableRow.class);
        XWPFTableCell cell = Mockito.mock(XWPFTableCell.class);
        
        CTTbl ctTbl = CTTbl.Factory.newInstance();
        CTTblPr ctTblPr = ctTbl.addNewTblPr();
        CTTblWidth ctTblWidth = ctTblPr.addNewTblW();
        
        CTTblGrid ctTblGrid = ctTbl.addNewTblGrid();
        ctTblGrid.addNewGridCol();
        
        Mockito.when(table.getCTTbl()).thenReturn(ctTbl);
        Mockito.when(table.getRow(Mockito.anyInt())).thenReturn(row);
        Mockito.when(row.getCell(Mockito.anyInt())).thenReturn(cell);
        
        List<XWPFTableRow> rows = new ArrayList<>();
        rows.add(row);
        Mockito.when(table.getRows()).thenReturn(rows);
        
        float[] colWidths = new float[]{2.5f, 3.5f};
        
        TableTools.widthTable(table, colWidths);
    }
}
