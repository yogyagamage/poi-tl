package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTIndsetLeftFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a new NiceXWPFDocument using the no-arg constructor
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        // Create NumberingFormat array that will trigger the path
        // We need at least one element to enter the loop where CTInd.setLeft is called
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.BULLET
        };
        
        // Call the entry point method
        document.addNewMultiLevelNumberingId(formats);
    }
}
