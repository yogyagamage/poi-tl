package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;

public class BufferedImageUtilsgetBufferByteArray_StringUtilsisEmptyFikaTest {

    @Test
    public void testGetBufferByteArrayInvokesStringUtilsIsEmpty() {
        // Create a real BufferedImage with valid dimensions
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        
        // Call with format that will make execution reach StringUtils.isEmpty
        // Empty string will trigger the isEmpty check
        BufferedImageUtils.getBufferByteArray(image, "");
    }
}
