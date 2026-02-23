package com.deepoove.poi.render;

import com.deepoove.poi.render.WhereDelegate;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class WhereDelegateaddPicture_XWPFRunaddPictureFikaTest {

    @Test
    public void testAddPicturePath() throws Exception {
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        WhereDelegate whereDelegate = new WhereDelegate(mockRun);
        
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        whereDelegate.addPicture(inputStream, 1, 100, 100);
    }
}
