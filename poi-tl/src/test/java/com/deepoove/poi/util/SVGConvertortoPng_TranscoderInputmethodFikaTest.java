package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;

public class SVGConvertortoPng_TranscoderInputmethodFikaTest {

    @Test
    public void testToPngInvokesTranscoderInputConstructor() throws TranscoderException, IOException {
        byte[] svgData = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\"><rect width=\"100\" height=\"100\" fill=\"blue\"/></svg>".getBytes();
        SVGConvertor.toPng(svgData, 100.0f, 100.0f, 1);
    }
}
