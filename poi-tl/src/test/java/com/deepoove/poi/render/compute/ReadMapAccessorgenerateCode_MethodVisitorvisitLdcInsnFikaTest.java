package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;

import static org.mockito.Mockito.mock;

public class ReadMapAccessorgenerateCode_MethodVisitorvisitLdcInsnFikaTest {

    @Test
    public void testGenerateCode() {
        ReadMapAccessor readMapAccessor = new ReadMapAccessor();
        MethodVisitor methodVisitor = mock(MethodVisitor.class);
        CodeFlow codeFlow = mock(CodeFlow.class);
        
        readMapAccessor.generateCode("testProperty", methodVisitor, codeFlow);
    }
}
