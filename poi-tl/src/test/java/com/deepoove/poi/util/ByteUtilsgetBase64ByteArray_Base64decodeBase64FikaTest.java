package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;

public class ByteUtilsgetBase64ByteArray_Base64decodeBase64FikaTest {

    @Test
    public void testGetBase64ByteArray() {
        // Valid base64 string without prefix
        String base64String = "SGVsbG8gV29ybGQ=";
        ByteUtils.getBase64ByteArray(base64String);
        
        // Valid base64 string with prefix
        String base64WithPrefix = "data:image/png;base64,SGVsbG8gV29ybGQ=";
        ByteUtils.getBase64ByteArray(base64WithPrefix);
        
        // Invalid base64 string (should not invoke decodeBase64)
        String invalidBase64 = "Not base64!";
        ByteUtils.getBase64ByteArray(invalidBase64);
    }
}
