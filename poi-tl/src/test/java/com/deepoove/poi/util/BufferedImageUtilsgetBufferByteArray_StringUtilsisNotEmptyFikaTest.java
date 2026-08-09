package com.deepoove.poi.util;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

public class BufferedImageUtilsgetBufferByteArray_StringUtilsisNotEmptyFikaTest {

    @Test
    public void testGetBufferByteArrayInvokesStringUtilsIsNotEmpty() throws Exception {
        BufferedImageUtils utils = new BufferedImageUtils();
        
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        String format = ".png";
        
        BufferedImageUtils.getBufferByteArray(image, format);
    }
}
