package com.deepoove.poi.util;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class BufferedImageUtilsgetBufferByteArray_StringUtilsisEmptyFikaTest {

    @Test
    public void testGetBufferByteArray() {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        String format = "";
        BufferedImageUtils.getBufferByteArray(image, format);
    }
}
