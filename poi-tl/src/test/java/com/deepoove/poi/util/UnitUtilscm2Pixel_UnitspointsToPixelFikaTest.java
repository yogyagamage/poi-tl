package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;

public class UnitUtilscm2Pixel_UnitspointsToPixelFikaTest {

    @Test
    public void test_cm2Pixel_invokes_pointsToPixel() {
        double testCm = 2.54;
        UnitUtils.cm2Pixel(testCm);
    }
}
