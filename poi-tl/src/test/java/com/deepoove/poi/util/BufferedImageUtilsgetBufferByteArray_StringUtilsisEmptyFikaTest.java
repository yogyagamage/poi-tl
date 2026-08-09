package com.deepoove.poi.util;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class BufferedImageUtilsgetBufferByteArray_StringUtilsisEmptyFikaTest {

    @Test
    public void testGetBufferByteArrayInvokesStringUtilsIsEmpty() throws Exception {
        // Create a real BufferedImage
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        
        // Call the entry point with format that will cause StringUtils.isEmpty to be called
        // Using null format will make formatName null, triggering StringUtils.isEmpty
        BufferedImageUtils.getBufferByteArray(image, null);
        
        // Also test with empty string format
        BufferedImageUtils.getBufferByteArray(image, "");
        
        // Test with format starting with dot
        BufferedImageUtils.getBufferByteArray(image, ".png");
        
        // Test with non-empty format
        BufferedImageUtils.getBufferByteArray(image, "jpg");
    }
}
