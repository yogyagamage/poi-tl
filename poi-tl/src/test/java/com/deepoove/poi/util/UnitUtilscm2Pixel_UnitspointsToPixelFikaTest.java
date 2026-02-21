package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;

public class UnitUtilscm2Pixel_UnitspointsToPixelFikaTest {

    @Test
    public void testCm2Pixel() {
        // Directly invoke the method with a valid input
        // This will trigger the internal call to Units.pointsToPixel
        UnitUtils.cm2Pixel(2.54); // 2.54 cm = 1 inch
    }
}
