package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;

public class BufferedImageUtilsgetBufferByteArray_StringUtilsisNotEmptyFikaTest {

    @Test
    public void testGetBufferByteArray() throws Exception {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        BufferedImageUtils.getBufferByteArray(image, ".png");
    }
}
