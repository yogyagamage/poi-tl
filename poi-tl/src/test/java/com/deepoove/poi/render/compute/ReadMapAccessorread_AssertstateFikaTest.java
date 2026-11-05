package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import java.util.HashMap;
import java.util.Map;

public class ReadMapAccessorread_AssertstateFikaTest {

    @Test
    public void testReadInvokesAssertState() throws Exception {
        ReadMapAccessor accessor = new ReadMapAccessor();
        EvaluationContext context = null;
        Map<String, String> target = new HashMap<>();
        target.put("key", "value");
        String name = "key";
        
        accessor.read(context, target, name);
    }
}
