package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteUtilstoByteArray_IOUtilstoByteArrayFikaTest {

    @Test
    public void testToByteArray() {
        byte[] data = "test data".getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);
        ByteUtils.toByteArray(inputStream);
    }
}
