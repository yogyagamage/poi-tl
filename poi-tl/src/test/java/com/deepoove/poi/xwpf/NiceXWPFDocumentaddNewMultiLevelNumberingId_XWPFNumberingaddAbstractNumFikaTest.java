package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_XWPFNumberingaddAbstractNumFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws IOException {
        // Create a new NiceXWPFDocument using the simplest constructor
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        // Create a simple NumberingFormat array to pass to the method
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL
        };
        
        // Call the entry point method - this should traverse the path 
        // and eventually call XWPFNumbering.addAbstractNum(...)
        BigInteger result = document.addNewMultiLevelNumberingId(numFmts);
        
        // No assertions needed - test passes if no exceptions are thrown
    }
}
