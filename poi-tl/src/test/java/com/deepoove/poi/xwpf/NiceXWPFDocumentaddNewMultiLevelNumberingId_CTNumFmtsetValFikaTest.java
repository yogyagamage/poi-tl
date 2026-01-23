package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTNumFmtsetValFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a new NiceXWPFDocument using the no-arg constructor
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        // Create NumberingFormat array that will trigger the target method call
        // Using DECIMAL format which will call CTNumFmt.setVal()
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.DECIMAL
        };
        
        // Call the entry point method - this should traverse the path and 
        // invoke CTNumFmt.setVal() internally
        BigInteger result = document.addNewMultiLevelNumberingId(formats);
        
        // No assertions or verifications - just ensure the method chain executes
    }
}
