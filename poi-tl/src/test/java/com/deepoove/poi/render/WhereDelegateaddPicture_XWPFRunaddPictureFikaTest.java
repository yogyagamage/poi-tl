package com.deepoove.poi.render;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.io.InputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;

class WhereDelegateaddPicture_XWPFRunaddPictureFikaTest {

    @Test
    void testAddPicture() throws InvalidFormatException, IOException {
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        WhereDelegate delegate = new WhereDelegate(mockRun);
        
        InputStream inputStream = InputStream.nullInputStream();
        delegate.addPicture(inputStream, 1, 100, 100);
    }
}
