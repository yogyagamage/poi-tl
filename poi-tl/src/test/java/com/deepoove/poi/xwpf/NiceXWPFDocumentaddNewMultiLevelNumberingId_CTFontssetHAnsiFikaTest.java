package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTFontssetHAnsiFikaTest {

    @Test
    public void test() {
        NiceXWPFDocument document = new NiceXWPFDocument();
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.BULLET
        };
        
        document.addNewMultiLevelNumberingId(formats);
    }
}
