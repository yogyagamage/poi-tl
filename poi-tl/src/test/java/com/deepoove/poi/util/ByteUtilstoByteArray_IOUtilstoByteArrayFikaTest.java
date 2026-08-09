package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteUtilstoByteArray_IOUtilstoByteArrayFikaTest {

    @Test
    public void testToByteArray() {
        // Create a real InputStream
        byte[] data = new byte[]{1, 2, 3, 4, 5};
        InputStream inputStream = new ByteArrayInputStream(data);
        
        // Call the entry point method with real InputStream
        ByteUtils.toByteArray(inputStream);
    }
}
