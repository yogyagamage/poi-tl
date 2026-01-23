package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.StringUtils;

public class RegexUtilsescapeExprSpecialWord_StringUtilsisNotBlankFikaTest {

    @Test
    public void testEscapeExprSpecialWordInvokesStringUtilsIsNotBlank() {
        // Instantiate the class (even though all methods are static, we create an instance as per constraints)
        RegexUtils regexUtils = new RegexUtils();
        
        // Call the entry point method with a string that will trigger the third-party method call
        // The third-party method StringUtils.isNotBlank will be invoked inside escapeExprSpecialWord
        regexUtils.escapeExprSpecialWord("test$string");
    }
}
