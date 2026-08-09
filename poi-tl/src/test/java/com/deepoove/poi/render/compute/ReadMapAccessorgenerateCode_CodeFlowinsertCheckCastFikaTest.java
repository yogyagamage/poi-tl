package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;

import static org.mockito.Mockito.mock;

public class ReadMapAccessorgenerateCode_CodeFlowinsertCheckCastFikaTest {

    @Test
    public void testGenerateCodeInvokesInsertCheckCast() {
        ReadMapAccessor accessor = new ReadMapAccessor();
        MethodVisitor mv = mock(MethodVisitor.class);
        CodeFlow cf = mock(CodeFlow.class);
        
        accessor.generateCode("testProperty", mv, cf);
    }
}
