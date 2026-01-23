package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.batik.transcoder.TranscoderOutput;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.transcoder.TranscoderException;
import java.io.IOException;

public class SVGConvertortoPng_TranscoderOutputmethodFikaTest {

    @Test
    public void testToPng() throws TranscoderException, IOException {
        SVGConvertor convertor = new SVGConvertor();
        
        byte[] svgData = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\"><rect width=\"100\" height=\"100\" fill=\"blue\"/></svg>".getBytes();
        float width = 100.0f;
        float maxHeight = 100.0f;
        int svgScale = 1;
        
        convertor.toPng(svgData, width, maxHeight, svgScale);
    }
}
