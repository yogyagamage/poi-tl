package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import java.io.IOException;

class SVGConvertortoPng_TranscodersetErrorHandlerFikaTest {

    @Test
    void testToPngInvokesSetErrorHandler() throws TranscoderException, IOException {
        byte[] svgData = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\"><rect width=\"100\" height=\"100\" fill=\"blue\"/></svg>".getBytes();
        SVGConvertor.toPng(svgData, 100.0f, 100.0f, 1);
    }
}
