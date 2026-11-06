package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;

public class BufferedImageUtilsgetBufferByteArray_StringUtilsisNotEmptyFikaTest {

    @Test
    public void testGetBufferByteArrayInvokesStringUtilsIsNotEmpty() {
        // Create a real BufferedImage with valid dimensions
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        
        // Provide a format string that will trigger the StringUtils.isNotEmpty call
        String format = ".png";
        
        // Execute the entry point method
        BufferedImageUtils.getBufferByteArray(image, format);
    }
}
