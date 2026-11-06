package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.IBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class XWPFTableRowWrappergetTableICells_XWPFTableCellmethodFikaTest {

    @Test
    public void testGetTableICells() throws Exception {
        CTRow ctRow = CTRow.Factory.newInstance();
        CTTc ctTc = ctRow.addNewTc();
        
        XWPFTableRow row = Mockito.mock(XWPFTableRow.class);
        XWPFTable table = Mockito.mock(XWPFTable.class);
        IBody body = Mockito.mock(IBody.class);
        
        Mockito.when(row.getCtRow()).thenReturn(ctRow);
        Mockito.when(row.getTable()).thenReturn(table);
        Mockito.when(table.getBody()).thenReturn(body);
        Mockito.when(row.getTableCells()).thenReturn(new ArrayList<>());
        
        XWPFTableRowWrapper wrapper = new XWPFTableRowWrapper(row);
        wrapper.getTableICells();
    }
}
