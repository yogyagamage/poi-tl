package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import java.util.HashMap;
import java.util.Map;

public class ReadMapAccessorread_AssertstateFikaTest {

    @Test
    public void testReadInvokesAssertState() throws Exception {
        ReadMapAccessor accessor = new ReadMapAccessor();
        EvaluationContext context = new StandardEvaluationContext();
        Map<String, Object> targetMap = new HashMap<>();
        targetMap.put("key", "value");
        
        accessor.read(context, targetMap, "key");
    }
}
