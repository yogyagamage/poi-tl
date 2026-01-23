package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.codec.binary.Base64;

public class ByteUtilsgetBase64ByteArray_Base64decodeBase64FikaTest {

    @Test
    public void testGetBase64ByteArray() {
        String base64Input = "SGVsbG8gV29ybGQ=";
        ByteUtils.getBase64ByteArray(base64Input);
    }
}
