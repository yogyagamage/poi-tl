package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvlisSetPPrFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a new NiceXWPFDocument using the no-arg constructor
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        // Create NumberingFormat array to pass to the method
        // We need at least one element to ensure the loop executes
        NumberingFormat[] numberingFormats = new NumberingFormat[] {
            NumberingFormat.BULLET
        };
        
        // Call the entry point method
        BigInteger result = document.addNewMultiLevelNumberingId(numberingFormats);
        
        // No assertions - test only needs to execute the method chain
    }
}
