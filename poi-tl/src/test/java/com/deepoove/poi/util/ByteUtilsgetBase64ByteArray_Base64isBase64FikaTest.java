package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.codec.binary.Base64;

public class ByteUtilsgetBase64ByteArray_Base64isBase64FikaTest {

    @Test
    public void testGetBase64ByteArrayInvokesIsBase64() {
        // Arrange
        String validBase64 = "SGVsbG8gV29ybGQ="; // "Hello World" in Base64
        
        // Act - This will traverse the path and invoke Base64.isBase64(...)
        ByteUtils.getBase64ByteArray(validBase64);
    }
}
