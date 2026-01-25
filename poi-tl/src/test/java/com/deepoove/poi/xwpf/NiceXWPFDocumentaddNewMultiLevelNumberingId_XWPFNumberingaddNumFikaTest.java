package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_XWPFNumberingaddNumFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws IOException {
        // Create a minimal valid DOCX in-memory to avoid "Package should contain a content type part"
        byte[] minimalDocx = MinimalDocxCreator.createMinimalDocx();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(minimalDocx);
        
        // Use constructor that accepts InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array to pass to the method
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.LOWER_LETTER
        };
        
        // Call the entry point method - this should traverse the path and invoke XWPFNumbering.addNum
        document.addNewMultiLevelNumberingId(formats);
    }
    
    // Helper class to create a minimal valid DOCX in memory
    private static class MinimalDocxCreator {
        static byte[] createMinimalDocx() {
            // Create a new empty XWPFDocument which generates proper package structure
            try (XWPFDocument tempDoc = new XWPFDocument()) {
                // Write to byte array
                java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
                tempDoc.write(baos);
                return baos.toByteArray();
            } catch (IOException e) {
                // Fallback: return a very basic DOCX structure
                return createFallbackDocx();
            }
        }
        
        private static byte[] createFallbackDocx() {
            // This is a minimal valid DOCX with [Content_Types].xml and .rels files
            // It's essentially an empty DOCX package
            try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
                 java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(baos)) {
                
                // [Content_Types].xml
                zos.putNextEntry(new java.util.zip.ZipEntry("[Content_Types].xml"));
                String contentTypes = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<Types xmlns=\"http://schemas.openxmlformats.org/package/2006/content-types\">" +
                    "<Default Extension=\"rels\" ContentType=\"application/vnd.openxmlformats-package.relationships+xml\"/>" +
                    "<Default Extension=\"xml\" ContentType=\"application/xml\"/>" +
                    "<Override PartName=\"/word/document.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml\"/>" +
                    "</Types>";
                zos.write(contentTypes.getBytes(java.nio.charset.StandardCharsets.UTF_8));
                zos.closeEntry();
                
                // _rels/.rels
                zos.putNextEntry(new java.util.zip.ZipEntry("_rels/.rels"));
                String rels = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">" +
                    "<Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument\" Target=\"word/document.xml\"/>" +
                    "</Relationships>";
                zos.write(rels.getBytes(java.nio.charset.StandardCharsets.UTF_8));
                zos.closeEntry();
                
                // word/document.xml
                zos.putNextEntry(new java.util.zip.ZipEntry("word/document.xml"));
                String document = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<w:document xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">" +
                    "<w:body><w:p><w:r><w:t></w:t></w:r></w:p></w:body>" +
                    "</w:document>";
                zos.write(document.getBytes(java.nio.charset.StandardCharsets.UTF_8));
                zos.closeEntry();
                
                // word/_rels/document.xml.rels
                zos.putNextEntry(new java.util.zip.ZipEntry("word/_rels/document.xml.rels"));
                String wordRels = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">" +
                    "</Relationships>";
                zos.write(wordRels.getBytes(java.nio.charset.StandardCharsets.UTF_8));
                zos.closeEntry();
                
                zos.finish();
                return baos.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException("Failed to create minimal DOCX", e);
            }
        }
    }
}
