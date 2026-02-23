package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;

import static org.mockito.Mockito.mock;

public class ReadMapAccessorgenerateCode_CodeFlowlastDescriptorFikaTest {

    @Test
    public void testGenerateCode() {
        ReadMapAccessor accessor = new ReadMapAccessor();
        String propertyName = "testProperty";
        MethodVisitor mv = mock(MethodVisitor.class);
        CodeFlow cf = new CodeFlow("testClassName", null);
        
        accessor.generateCode(propertyName, mv, cf);
    }
}
