package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReadMapAccessorgenerateCode_MethodVisitorvisitLdcInsnFikaTest {

    @Test
    public void testGenerateCode() {
        String propertyName = "testProperty";
        MethodVisitor mv = mock(MethodVisitor.class);
        CodeFlow cf = mock(CodeFlow.class);
        
        when(cf.lastDescriptor()).thenReturn("Ljava/util/Map");
        
        ReadMapAccessor accessor = new ReadMapAccessor();
        accessor.generateCode(propertyName, mv, cf);
    }
}
