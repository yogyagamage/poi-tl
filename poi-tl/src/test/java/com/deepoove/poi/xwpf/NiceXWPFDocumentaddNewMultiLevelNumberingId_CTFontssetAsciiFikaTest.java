package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTFontssetAsciiFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.BULLET
        };
        
        document.addNewMultiLevelNumberingId(numFmts);
    }
}
