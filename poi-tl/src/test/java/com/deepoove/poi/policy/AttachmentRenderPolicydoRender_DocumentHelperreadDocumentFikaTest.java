package com.deepoove.poi.policy;

import com.deepoove.poi.data.AttachmentRenderData;
import com.deepoove.poi.data.AttachmentType;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.data.PictureType;
import com.deepoove.poi.data.Pictures;
import com.deepoove.poi.data.style.PictureStyle;
import com.deepoove.poi.render.RenderContext;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.StringReader;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class AttachmentRenderPolicydoRender_DocumentHelperreadDocumentFikaTest {

    @Test
    public void testDoRender() throws Exception {
        // Create instance of class under test
        AttachmentRenderPolicy policy = new AttachmentRenderPolicy();
        
        // Create mock RenderContext
        RenderContext<AttachmentRenderData> mockContext = Mockito.mock(RenderContext.class);
        
        // Create mock NiceXWPFDocument
        NiceXWPFDocument mockDoc = Mockito.mock(NiceXWPFDocument.class);
        Mockito.when(mockContext.getXWPFDocument()).thenReturn(mockDoc);
        
        // Create mock XWPFRun
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        Mockito.when(mockContext.getRun()).thenReturn(mockRun);
        
        // Create mock CTR
        CTR mockCtr = Mockito.mock(CTR.class);
        Mockito.when(mockRun.getCTR()).thenReturn(mockCtr);
        
        // Create mock AttachmentRenderData
        AttachmentRenderData mockData = Mockito.mock(AttachmentRenderData.class);
        Mockito.when(mockContext.getData()).thenReturn(mockData);
        
        // Setup AttachmentType
        AttachmentType mockFileType = Mockito.mock(AttachmentType.class);
        Mockito.when(mockData.getFileType()).thenReturn(mockFileType);
        Mockito.when(mockFileType.icon()).thenReturn("base64icon");
        Mockito.when(mockFileType.contentType()).thenReturn("application/octet-stream");
        Mockito.when(mockFileType.ext()).thenReturn(".bin");
        Mockito.when(mockFileType.programId()).thenReturn("Package");
        
        // Setup attachment data
        byte[] mockAttachment = new byte[]{1, 2, 3};
        Mockito.when(mockData.readAttachmentData()).thenReturn(mockAttachment);
        
        // Setup PictureRenderData to be null so it gets created in the method
        Mockito.when(mockData.getIcon()).thenReturn(null);
        
        // Setup mock picture data methods
        byte[] mockImage = new byte[]{4, 5, 6};
        Mockito.when(mockDoc.addPictureData(Mockito.any(byte[].class), Mockito.anyInt())).thenReturn("rId1");
        Mockito.when(mockDoc.addEmbeddData(Mockito.any(byte[].class), Mockito.anyString(), Mockito.anyString())).thenReturn("rId2");
        
        // Call the entry point method
        policy.doRender(mockContext);
    }
}
