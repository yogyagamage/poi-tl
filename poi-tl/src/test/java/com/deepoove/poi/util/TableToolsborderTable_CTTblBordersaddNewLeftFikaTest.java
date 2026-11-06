package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TableToolsborderTable_CTTblBordersaddNewLeftFikaTest {

    @Test
    public void testBorderTableInvokesAddNewLeft() throws Exception {
        XWPFTable table = Mockito.mock(XWPFTable.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr ctTblPr = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders ctTblBorders = 
            ctTblPr.addNewTblBorders();
        
        Mockito.when(table.getCTTbl()).thenReturn(
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl.Factory.newInstance()
        );
        table.getCTTbl().setTblPr(ctTblPr);
        
        TableTools.borderTable(table, 8);
    }
}
