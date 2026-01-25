package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.batik.transcoder.TranscoderInput;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SVGConvertortoPng_TranscoderInputmethodFikaTest {

    @Test
    public void testToPng() throws Exception {
        SVGConvertor svgConvertor = new SVGConvertor();
        
        byte[] svgData = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\"><rect width=\"100\" height=\"100\" fill=\"blue\"/></svg>".getBytes();
        float width = 100.0f;
        float maxHeight = 100.0f;
        int svgScale = 1;
        
        svgConvertor.toPng(svgData, width, maxHeight, svgScale);
    }
}
