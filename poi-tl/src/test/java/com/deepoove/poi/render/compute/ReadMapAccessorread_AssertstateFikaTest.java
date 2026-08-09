package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.TypedValue;
import org.springframework.util.Assert;
import java.util.HashMap;
import java.util.Map;

public class ReadMapAccessorread_AssertstateFikaTest {

    @Test
    public void testReadInvokesAssertState() throws Exception {
        ReadMapAccessor accessor = new ReadMapAccessor();
        
        Map<String, Object> targetMap = new HashMap<>();
        targetMap.put("testKey", "testValue");
        
        EvaluationContext context = new org.springframework.expression.spel.support.StandardEvaluationContext();
        
        TypedValue result = accessor.read(context, targetMap, "testKey");
    }
}
