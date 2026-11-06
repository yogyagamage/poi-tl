package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import org.apache.batik.transcoder.TranscoderOutput;

public class SVGConvertortoPng_TranscoderOutputmethodFikaTest {

    @Test
    public void testToPng() throws Exception {
        byte[] svgData = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\"><rect width=\"100\" height=\"100\" fill=\"blue\"/></svg>".getBytes();
        SVGConvertor.toPng(svgData, 100.0f, 100.0f, 1);
    }
}
