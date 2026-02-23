package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;

public class ByteUtilsgetBase64ByteArray_Base64isBase64FikaTest {

    @Test
    public void testGetBase64ByteArray() {
        String base64Input = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mNkYPhfDwAChwGA60e6kgAAAABJRU5ErkJggg==";
        ByteUtils.getBase64ByteArray(base64Input);
    }
}
