package com.deepoove.poi.xwpf;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.junit.jupiter.api.Test;
import java.net.URI;

public class XWPFParagraphWrapperinsertNewHyperLinkRun_PackagePartaddExternalRelationshipFikaTest {

    @Test
    public void testInsertNewHyperLinkRun() throws Exception {
        // Create real XWPFDocument
        XWPFDocument document = new XWPFDocument();
        
        // Create real paragraph
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create wrapper with real paragraph
        XWPFParagraphWrapper wrapper = new XWPFParagraphWrapper(paragraph);
        
        // Get the package part from the document
        PackagePart packagePart = document.getPart().getPackagePart();
        
        // Invoke the entry point method
        wrapper.insertNewHyperLinkRun(0, "https://example.com");
    }
}
