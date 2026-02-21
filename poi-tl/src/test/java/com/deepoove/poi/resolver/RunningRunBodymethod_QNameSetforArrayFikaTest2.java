package com.deepoove.poi.resolver;

import org.junit.jupiter.api.Test;
import org.apache.xmlbeans.QNameSet;
import javax.xml.namespace.QName;

public class RunningRunBodymethod_QNameSetforArrayFikaTest2 {

    @Test
    public void testQNameSetForArrayInvocation() {
        // Access the static field which triggers QNameSet.forArray() during class initialization
        QNameSet result = RunningRunBody.qname;
        
        // Additional call to ensure the method is invoked during test execution
        QName[] qnames = new QName[]{
            new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "br"),
            new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "t"),
            new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cr"),
            new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tab")
        };
        QNameSet.forArray(qnames);
    }
}
