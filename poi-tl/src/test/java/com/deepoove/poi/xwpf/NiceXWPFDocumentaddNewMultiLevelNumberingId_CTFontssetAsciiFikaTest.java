package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTFontssetAsciiFikaTest {

    @Test
    public void test() throws Exception {
        // Create a new NiceXWPFDocument using the default constructor
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        // Create a NumberingFormat array with at least one BULLET format
        // to trigger the path that calls CTFonts.setAscii
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.BULLET
        };
        
        // Call the entry point method
        document.addNewMultiLevelNumberingId(formats);
    }
}
