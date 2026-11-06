package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTNumFmtsetValFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() {
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.BULLET,
            NumberingFormat.LOWER_LETTER
        };
        
        document.addNewMultiLevelNumberingId(numFmts);
    }
}
