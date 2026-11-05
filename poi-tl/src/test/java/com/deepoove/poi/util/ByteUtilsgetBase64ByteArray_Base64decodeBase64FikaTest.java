package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;

public class ByteUtilsgetBase64ByteArray_Base64decodeBase64FikaTest {

    @Test
    public void testGetBase64ByteArrayInvokesDecodeBase64() {
        // Arrange
        String validBase64 = "SGVsbG8gV29ybGQ="; // "Hello World" in Base64
        
        // Act - This should traverse the path and invoke Base64.decodeBase64
        ByteUtils.getBase64ByteArray(validBase64);
    }
}
