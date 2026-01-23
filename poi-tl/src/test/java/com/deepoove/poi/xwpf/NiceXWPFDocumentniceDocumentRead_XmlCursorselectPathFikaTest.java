package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.deepoove.poi.util.PoitlIOUtils;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFChart;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFactory;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFSDT;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.schema.AbstractDocumentFactory;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.slf4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NiceXWPFDocumentniceDocumentRead_XmlCursorselectPathFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() throws IOException {
        InputStream docxStream = createValidDocxInputStream();
        boolean adjustDoc = true;
        
        NiceXWPFDocument document = new NiceXWPFDocument(docxStream, adjustDoc);
    }

    private InputStream createValidDocxInputStream() throws IOException {
        XWPFDocument baseDoc = new XWPFDocument();
        
        // Create minimal document structure to avoid XmlValueDisconnectedException
        baseDoc.createParagraph();
        
        // Create a structured document tag to ensure contentControls is not empty
        // This will trigger the XmlCursor.selectPath call in niceDocumentRead()
        try {
            // Use reflection to access protected method if needed, but we can create
            // a simple document with content controls through normal API
            CTSdtBlock sdtBlock = CTSdtBlock.Factory.newInstance();
            baseDoc.getDocument().getBody().addNewSdt();
        } catch (Exception e) {
            // Continue with basic document
        }
        
        // Write to byte array and return as InputStream
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        baseDoc.write(baos);
        baseDoc.close();
        
        return new ByteArrayInputStream(baos.toByteArray());
    }
}
