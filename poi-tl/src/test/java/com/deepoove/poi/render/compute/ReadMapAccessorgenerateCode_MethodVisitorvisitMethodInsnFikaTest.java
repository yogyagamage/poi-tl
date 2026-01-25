package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;

import static org.mockito.Mockito.mock;

public class ReadMapAccessorgenerateCode_MethodVisitorvisitMethodInsnFikaTest {

    @Test
    public void testGenerateCode() throws Exception {
        ReadMapAccessor readMapAccessor = new ReadMapAccessor();
        MethodVisitor methodVisitor = mock(MethodVisitor.class);
        CodeFlow codeFlow = new CodeFlow("com/test/ClassName", null);
        
        readMapAccessor.generateCode("testKey", methodVisitor, codeFlow);
    }
}
