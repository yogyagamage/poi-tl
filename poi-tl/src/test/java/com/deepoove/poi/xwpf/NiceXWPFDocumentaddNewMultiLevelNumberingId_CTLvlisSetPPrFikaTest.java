package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvlisSetPPrFikaTest {

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
