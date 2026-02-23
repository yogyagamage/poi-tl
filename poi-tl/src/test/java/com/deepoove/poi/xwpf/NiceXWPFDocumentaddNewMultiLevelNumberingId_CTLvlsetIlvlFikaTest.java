package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvlsetIlvlFikaTest {

    @Test
    public void test() throws Exception {
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.BULLET
        };
        
        document.addNewMultiLevelNumberingId(numFmts);
    }
}
