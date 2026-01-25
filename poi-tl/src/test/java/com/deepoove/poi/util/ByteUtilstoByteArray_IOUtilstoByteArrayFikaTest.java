package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteUtilstoByteArray_IOUtilstoByteArrayFikaTest {

    @Test
    public void testToByteArray() {
        ByteUtils instance = new ByteUtils();
        InputStream inputStream = new ByteArrayInputStream(new byte[]{1, 2, 3});
        ByteUtils.toByteArray(inputStream);
    }
}
