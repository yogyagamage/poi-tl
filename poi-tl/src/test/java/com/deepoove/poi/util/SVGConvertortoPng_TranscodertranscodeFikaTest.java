package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class SVGConvertortoPng_TranscodertranscodeFikaTest {

    @Test
    public void testToPngInvokesTranscode() throws Exception {
        // Minimal valid SVG content
        String svgContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\">" +
                "<rect width=\"100\" height=\"100\" fill=\"blue\"/>" +
                "</svg>";
        byte[] svgBytes = svgContent.getBytes("UTF-8");
        
        // Call entry point method which should eventually invoke Transcoder.transcode
        SVGConvertor.toPng(svgBytes, 100.0f, 100.0f, 1);
    }
}
