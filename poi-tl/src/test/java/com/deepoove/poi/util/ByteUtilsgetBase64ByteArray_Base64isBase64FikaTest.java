package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.codec.binary.Base64;

public class ByteUtilsgetBase64ByteArray_Base64isBase64FikaTest {

    @Test
    public void testGetBase64ByteArray() {
        ByteUtils instance = new ByteUtils();
        String base64String = "SGVsbG8gV29ybGQ=";
        ByteUtils.getBase64ByteArray(base64String);
    }
}
