package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTDecimalNumbersetValFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() {
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.DECIMAL
        };
        
        document.addNewMultiLevelNumberingId(numFmts);
    }
}
