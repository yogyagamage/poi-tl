package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteUtilstoByteArray_IOUtilstoByteArrayFikaTest {

    @Test
    public void testToByteArray() {
        // Create a real InputStream with some data
        byte[] data = "test data".getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);
        
        // Call the entry point method with the real InputStream
        ByteUtils.toByteArray(inputStream);
        
        // The test will execute the full chain:
        // ByteUtils.toByteArray() -> IOUtils.toByteArray()
        // No assertions needed as per requirements
    }
}
