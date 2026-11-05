package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;

public class BufferedImageUtilsgetBufferByteArray_StringUtilsisEmptyFikaTest {

    @Test
    public void testGetBufferByteArray() throws Exception {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        BufferedImageUtils.getBufferByteArray(image, "");
    }
}
