package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvlsetIlvlFikaTest {

    @Test
    public void testInvokeSetIlvl() {
        NiceXWPFDocument document = new NiceXWPFDocument();
        
        NumberingFormat[] numFmts = new NumberingFormat[2];
        numFmts[0] = Mockito.mock(NumberingFormat.class);
        numFmts[1] = Mockito.mock(NumberingFormat.class);
        
        when(numFmts[0].getNumFmt()).thenReturn(1);
        when(numFmts[0].getLvlText()).thenReturn("1");
        when(numFmts[1].getNumFmt()).thenReturn(1);
        when(numFmts[1].getLvlText()).thenReturn("2");
        
        document.addNewMultiLevelNumberingId(numFmts);
    }
}
