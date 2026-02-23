package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTFontssetHintFikaTest {

    @Test
    public void test() throws Exception {
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.BULLET
        };
        
        document.addNewMultiLevelNumberingId(numFmts);
    }
}
