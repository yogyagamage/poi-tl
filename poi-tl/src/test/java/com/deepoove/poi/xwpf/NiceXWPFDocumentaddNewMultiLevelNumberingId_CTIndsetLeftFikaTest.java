package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTIndsetLeftFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() {
        NiceXWPFDocument document = new NiceXWPFDocument();
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.LOWER_LETTER
        };
        
        document.addNewMultiLevelNumberingId(formats);
    }
}
