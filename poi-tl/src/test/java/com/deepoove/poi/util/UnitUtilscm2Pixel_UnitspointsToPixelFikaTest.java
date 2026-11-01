package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;

public class UnitUtilscm2Pixel_UnitspointsToPixelFikaTest {

    @Test
    public void test_cm2Pixel_invokes_Units_pointsToPixel() {
        // Direct invocation of the method under test
        // This will trigger the internal call to Units.pointsToPixel(...)
        UnitUtils.cm2Pixel(2.54); // 2.54 cm = 1 inch, which should produce a non-zero pixel value
    }
}
