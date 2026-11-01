package com.deepoove.poi.plugin.toc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFFieldRun;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TOCRenderPolicyrender_XWPFParagraphinsertNewFieldRunFikaTest {

    @Mock
    private XWPFTemplate template;

    @Mock
    private RunTemplate runTemplate;

    @Mock
    private XWPFRun run;

    @Mock
    private XWPFParagraph tocPara;

    @Mock
    private XWPFFieldRun fieldRun;

    @Mock
    private CTSimpleField toc;

    @Test
    public void testRenderInvokesInsertNewFieldRun() throws Exception {
        when(runTemplate.getRun()).thenReturn(run);
        when(run.getParent()).thenReturn(tocPara);
        when(tocPara.insertNewFieldRun(0)).thenReturn(fieldRun);
        when(fieldRun.getCTField()).thenReturn(toc);

        Object data = new Object();
        TOCRenderPolicy policy = new TOCRenderPolicy();
        policy.render(runTemplate, data, template);
    }
}
