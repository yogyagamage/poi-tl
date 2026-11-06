package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

import static org.mockito.Mockito.mock;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTFontssetHAnsiFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() {
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.BULLET
        };
        
        document.addNewMultiLevelNumberingId(numFmts);
    }
}
