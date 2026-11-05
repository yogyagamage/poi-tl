package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.codec.binary.Base64;

public class ByteUtilsgetBase64ByteArray_Base64isBase64FikaTest {

    @Test
    public void testGetBase64ByteArrayInvokesIsBase64() {
        // Arrange
        String base64Input = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mNkYPhfDwAChwGA60e6kgAAAABJRU5ErkJggg==";
        
        // Act - This should invoke Base64.isBase64() internally
        ByteUtils.getBase64ByteArray(base64Input);
    }
}
