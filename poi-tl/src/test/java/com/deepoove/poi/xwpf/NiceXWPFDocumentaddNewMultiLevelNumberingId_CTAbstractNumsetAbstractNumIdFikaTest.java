package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTAbstractNumsetAbstractNumIdFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a new NiceXWPFDocument using the default constructor
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        // Create NumberingFormat array to pass to the method
        // Using DECIMAL as a valid format that will not trigger the bullet branch
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.DECIMAL
        };
        
        // Call the entry point method - this should trigger the chain
        // that eventually calls CTAbstractNum.setAbstractNumId()
        document.addNewMultiLevelNumberingId(formats);
    }
}
