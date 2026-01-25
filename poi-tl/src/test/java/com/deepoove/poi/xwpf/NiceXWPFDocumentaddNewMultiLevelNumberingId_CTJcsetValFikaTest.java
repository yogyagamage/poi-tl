package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;

import java.io.ByteArrayInputStream;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTJcsetValFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a new NiceXWPFDocument using the default constructor
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        // Create a NumberingFormat array that will trigger the bullet path
        // STNumberFormat.BULLET corresponds to NumberingFormat.BULLET
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.BULLET
        };
        
        // Call the entry point method - this should traverse the path
        // and eventually call CTJc.setVal(STJc.Enum)
        document.addNewMultiLevelNumberingId(numFmts);
    }
}
