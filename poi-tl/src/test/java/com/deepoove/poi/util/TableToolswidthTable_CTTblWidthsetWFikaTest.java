package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.IBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.apache.xmlbeans.XmlObject;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Units;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TableToolswidthTable_CTTblWidthsetWFikaTest {

    @Test
    public void testWidthTable() throws Exception {
        // Create real CTTbl object
        CTTbl ctTbl = CTTbl.Factory.newInstance();
        
        // Create mock XWPFTable that returns the real CTTbl
        XWPFTable table = Mockito.mock(XWPFTable.class);
        Mockito.when(table.getCTTbl()).thenReturn(ctTbl);
        
        // Mock getRow to return empty list initially
        Mockito.when(table.getRows()).thenReturn(new ArrayList<XWPFTableRow>());
        
        // Mock getNumberOfRows to return 0
        Mockito.when(table.getNumberOfRows()).thenReturn(0);
        
        // Create column widths array
        float[] colWidths = new float[]{5.0f, 5.0f};
        
        // Call the entry point method
        TableTools.widthTable(table, colWidths);
    }
}
