package com.deepoove.poi.render;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class WhereDelegateaddPicture_XWPFRunaddPictureFikaTest {

    @Mock
    private XWPFRun mockRun;

    @Test
    public void testAddPicture() throws InvalidFormatException, IOException {
        WhereDelegate delegate = new WhereDelegate(mockRun);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[0]);
        delegate.addPicture(inputStream, 1, 100, 100);
    }
}
