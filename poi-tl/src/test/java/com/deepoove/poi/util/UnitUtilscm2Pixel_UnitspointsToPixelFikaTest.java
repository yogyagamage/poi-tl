package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.util.Units;

public class UnitUtilscm2Pixel_UnitspointsToPixelFikaTest {

    @Test
    public void test() {
        // Entry point is static, no instance needed
        double inputCm = 1.0;
        UnitUtils.cm2Pixel(inputCm);
        // This will invoke Units.pointsToPixel(...) internally
    }
}
