package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;

public class ReadMapAccessorgenerateCode_CodeFlowloadTargetFikaTest {

    @Test
    public void test() {
        MethodVisitor mv = Mockito.mock(MethodVisitor.class);
        CodeFlow cf = Mockito.mock(CodeFlow.class);
        
        Mockito.when(cf.lastDescriptor()).thenReturn(null);
        
        ReadMapAccessor accessor = new ReadMapAccessor();
        accessor.generateCode("anyProperty", mv, cf);
    }
}
