package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;

public class ByteUtilsgetBase64ByteArray_Base64isBase64FikaTest {

    @Test
    void testGetBase64ByteArrayReachesBase64IsBase64() {
        ByteUtils.getBase64ByteArray("base64,SGVsbG8=");
    }
}
