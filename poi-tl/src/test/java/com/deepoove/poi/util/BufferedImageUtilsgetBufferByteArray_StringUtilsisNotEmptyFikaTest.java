package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;

public class BufferedImageUtilsgetBufferByteArray_StringUtilsisNotEmptyFikaTest {

    @Test
    public void testGetBufferByteArrayInvokesStringUtilsIsNotEmpty() {
        // Create a real BufferedImage with valid dimensions
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        
        // Call with a format string that will trigger StringUtils.isNotEmpty
        BufferedImageUtils.getBufferByteArray(image, ".png");
        
        // Also test with non-null, non-empty format without dot prefix
        BufferedImageUtils.getBufferByteArray(image, "jpg");
        
        // Also test with null format (should still call isNotEmpty)
        BufferedImageUtils.getBufferByteArray(image, null);
        
        // Also test with empty string format
        BufferedImageUtils.getBufferByteArray(image, "");
    }
}
