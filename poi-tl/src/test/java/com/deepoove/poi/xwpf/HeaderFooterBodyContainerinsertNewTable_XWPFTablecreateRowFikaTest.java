package com.deepoove.poi.xwpf;

import com.deepoove.poi.util.ReflectionUtils;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFHeaderFooter;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlTokenSource;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class HeaderFooterBodyContainerinsertNewTable_XWPFTablecreateRowFikaTest {

    @Test
    public void testInsertNewTablePathToCreateRow() throws Exception {
        XWPFHeaderFooter mockHeaderFooter = Mockito.mock(XWPFHeaderFooter.class);
        XWPFParagraph mockParagraph = Mockito.mock(XWPFParagraph.class);
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        CTP mockCTP = Mockito.mock(CTP.class);
        XmlCursor mockCursor = Mockito.mock(XmlCursor.class);
        XWPFTable mockTable = Mockito.mock(XWPFTable.class);
        XWPFTableRow mockTableRow = Mockito.mock(XWPFTableRow.class);
        
        List<XWPFTableRow> emptyRows = new ArrayList<>();
        List<XWPFTableRow> rowsWithOneNull = new ArrayList<>();
        rowsWithOneNull.add(null);
        
        Mockito.when(mockRun.getParent()).thenReturn(mockParagraph);
        Mockito.when(mockParagraph.getCTP()).thenReturn(mockCTP);
        Mockito.when(mockCTP.newCursor()).thenReturn(mockCursor);
        Mockito.when(mockHeaderFooter.insertNewTbl(Mockito.any(XmlCursor.class))).thenReturn(mockTable);
        Mockito.when(mockTable.getRows()).thenReturn(emptyRows).thenReturn(rowsWithOneNull);
        Mockito.when(mockTable.getRow(0)).thenReturn(null);
        Mockito.when(mockTable.createRow()).thenReturn(mockTableRow);
        Mockito.when(mockTableRow.getCell(0)).thenReturn(null);
        
        HeaderFooterBodyContainer container = new HeaderFooterBodyContainer(mockHeaderFooter);
        container.insertNewTable(mockRun, 1, 1);
    }
}
