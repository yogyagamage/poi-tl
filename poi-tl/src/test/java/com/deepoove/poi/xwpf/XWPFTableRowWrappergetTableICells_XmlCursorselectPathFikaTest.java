package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class XWPFTableRowWrappergetTableICells_XmlCursorselectPathFikaTest {

    @Test
    public void testGetTableICellsInvokesSelectPath() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        
        CTRow ctRow = row.getCtRow();
        CTTc ctTc = ctRow.addNewTc();
        ctTc.addNewP();
        
        XWPFTableRowWrapper wrapper = new XWPFTableRowWrapper(row);
        List<org.apache.poi.xwpf.usermodel.ICell> cells = wrapper.getTableICells();
    }
}
