package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import java.math.BigInteger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TableToolswidthTable_CTTblWidthsetTypeFikaTest {

    @Test
    public void testWidthTable() throws Exception {
        XWPFTable table = mock(XWPFTable.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl ctTbl = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr ctTblPr = 
            ctTbl.addNewTblPr();
        CTTblWidth ctTblWidth = ctTblPr.addNewTblW();
        
        when(table.getCTTbl()).thenReturn(ctTbl);
        
        float[] colWidths = new float[]{10.0f, 20.0f};
        
        TableTools.widthTable(table, colWidths);
    }
}
