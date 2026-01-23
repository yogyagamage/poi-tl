package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;

import static org.mockito.Mockito.mock;

public class ReadMapAccessorgenerateCode_CodeFlowloadTargetFikaTest {

    @Test
    public void testGenerateCode() throws Exception {
        ReadMapAccessor readMapAccessor = new ReadMapAccessor();
        MethodVisitor mv = mock(MethodVisitor.class);
        CodeFlow cf = new CodeFlow("test", null);
        
        readMapAccessor.generateCode("propertyName", mv, cf);
    }
}
