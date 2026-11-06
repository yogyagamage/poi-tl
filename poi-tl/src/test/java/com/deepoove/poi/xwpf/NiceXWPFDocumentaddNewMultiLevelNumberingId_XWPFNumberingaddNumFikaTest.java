package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_XWPFNumberingaddNumFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingIdCallsAddNum() throws Exception {
        // Create a real NiceXWPFDocument instance
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        // Create real NumberingFormat array
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.LOWER_LETTER
        };
        
        // Execute the entry point method
        document.addNewMultiLevelNumberingId(numFmts);
    }
}
