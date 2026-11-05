package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;

public class BufferedImageUtilsgetBufferByteArray_StringUtilsisNotEmptyFikaTest {

    @Test
    public void testGetBufferByteArrayInvokesStringUtilsIsNotEmpty() {
        // Create a real BufferedImage object
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        
        // Call the entry point method with a format string that will trigger StringUtils.isNotEmpty
        BufferedImageUtils.getBufferByteArray(image, ".png");
    }
}
