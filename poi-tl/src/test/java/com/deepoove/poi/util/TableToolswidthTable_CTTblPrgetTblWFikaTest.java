package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TableToolswidthTable_CTTblPrgetTblWFikaTest {

    @Test
    public void testWidthTableCallsGetTblW() {
        XWPFTable table = Mockito.mock(XWPFTable.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl ctTbl = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl.Factory.newInstance();
        Mockito.when(table.getCTTbl()).thenReturn(ctTbl);
        
        CTTblPr tblPr = ctTbl.addNewTblPr();
        tblPr.addNewTblW();
        
        CTTblGrid tblGrid = ctTbl.addNewTblGrid();
        Mockito.when(table.getCTTbl()).thenReturn(ctTbl);
        
        float[] colWidths = new float[]{10.0f, 20.0f};
        TableTools.widthTable(table, colWidths);
    }
}
