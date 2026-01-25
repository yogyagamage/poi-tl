package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TableToolswidthTable_CTTblGridaddNewGridColFikaTest {

    @Test
    public void testWidthTableCallsAddNewGridCol() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        CTTbl ctTbl = table.getCTTbl();
        CTTblGrid grid = ctTbl.addNewTblGrid();
        grid.addNewGridCol().setW(BigInteger.valueOf(1000));
        
        float[] colWidths = new float[] { 5.0f, 5.0f };
        TableTools.widthTable(table, colWidths);
    }
}
