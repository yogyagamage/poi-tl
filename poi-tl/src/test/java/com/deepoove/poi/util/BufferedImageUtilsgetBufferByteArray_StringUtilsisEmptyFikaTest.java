package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;

public class BufferedImageUtilsgetBufferByteArray_StringUtilsisEmptyFikaTest {

    @Test
    public void testGetBufferByteArrayInvokesStringUtilsIsEmpty() {
        // Create a real BufferedImage object
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        
        // Call with empty format string to trigger StringUtils.isEmpty
        BufferedImageUtils.getBufferByteArray(image, "");
        
        // Also test with null format
        BufferedImageUtils.getBufferByteArray(image, null);
        
        // Test with format starting with dot
        BufferedImageUtils.getBufferByteArray(image, ".png");
        
        // Test with non-empty format
        BufferedImageUtils.getBufferByteArray(image, "jpg");
    }
}
