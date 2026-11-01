package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;

public class BufferedImageUtilsgetBufferByteArray_StringUtilsisNotEmptyFikaTest {

    @Test
    public void testGetBufferByteArray() {
        // Create a real BufferedImage object
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        
        // Test with format that starts with '.' to ensure StringUtils.isNotEmpty is called
        // and the ternary operator evaluates the first part
        String format = ".png";
        
        // This will invoke StringUtils.isNotEmpty(format) in the method
        BufferedImageUtils.getBufferByteArray(image, format);
        
        // Also test with non-null format without dot to ensure coverage
        BufferedImageUtils.getBufferByteArray(image, "jpg");
        
        // Test with null format to cover that path
        BufferedImageUtils.getBufferByteArray(image, null);
        
        // Test with empty string format
        BufferedImageUtils.getBufferByteArray(image, "");
        
        // Test with whitespace format
        BufferedImageUtils.getBufferByteArray(image, " ");
    }
}
