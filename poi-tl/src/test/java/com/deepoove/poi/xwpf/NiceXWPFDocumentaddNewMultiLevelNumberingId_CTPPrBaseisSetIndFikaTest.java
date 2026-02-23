package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

import static org.mockito.Mockito.when;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTPPrBaseisSetIndFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL
        };
        
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        document.addNewMultiLevelNumberingId(numFmts);
    }
}
