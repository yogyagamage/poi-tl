package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;

class ReadMapAccessorgenerateCode_MethodVisitorvisitMethodInsnFikaTest {

    @Test
    void testGenerateCode() {
        MethodVisitor mv = Mockito.mock(MethodVisitor.class);
        CodeFlow cf = Mockito.mock(CodeFlow.class);
        
        Mockito.when(cf.lastDescriptor()).thenReturn("Ljava/util/Map");
        
        ReadMapAccessor instance = new ReadMapAccessor();
        instance.generateCode("testKey", mv, cf);
    }
}
