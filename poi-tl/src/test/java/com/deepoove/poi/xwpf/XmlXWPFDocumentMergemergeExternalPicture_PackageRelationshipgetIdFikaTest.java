package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class XmlXWPFDocumentMergemergeExternalPicture_PackageRelationshipgetIdFikaTest {

    @Test
    public void testMergePathToPackageRelationshipGetId() throws Exception {
        // Create source document
        NiceXWPFDocument sourceDoc = new NiceXWPFDocument();
        
        // Create merged document with external picture relationship
        NiceXWPFDocument mergedDoc = new NiceXWPFDocument();
        
        // Add an external relationship to merged document
        mergedDoc.getPackagePart().addExternalRelationship(
            "http://example.com/image.png", 
            XWPFRelation.IMAGES.getRelation()
        );
        
        // Create iterator with merged document
        List<NiceXWPFDocument> docs = new ArrayList<>();
        docs.add(mergedDoc);
        Iterator<NiceXWPFDocument> iterator = docs.iterator();
        
        // Create a paragraph and run in source document
        XWPFParagraph paragraph = sourceDoc.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        // Instantiate XmlXWPFDocumentMerge using constructor
        XmlXWPFDocumentMerge merge = new XmlXWPFDocumentMerge();
        
        // Call entry point method - this should trigger the full call chain
        merge.merge(sourceDoc, iterator, run);
        
        // Clean up
        sourceDoc.close();
    }
}
