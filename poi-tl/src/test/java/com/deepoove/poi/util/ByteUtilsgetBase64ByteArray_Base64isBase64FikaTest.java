package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.codec.binary.Base64;

public class ByteUtilsgetBase64ByteArray_Base64isBase64FikaTest {

    @Test
    public void testGetBase64ByteArray() {
        ByteUtils instance = new ByteUtils();
        String input = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mNkYPhfDwAChwGA60e6kgAAAABJRU5ErkJggg==";
        ByteUtils.getBase64ByteArray(input);
    }
}
