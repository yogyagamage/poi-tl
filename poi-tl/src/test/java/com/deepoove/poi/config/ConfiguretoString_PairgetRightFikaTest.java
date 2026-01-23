package com.deepoove.poi.config;

import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.DocxRenderPolicy;
import com.deepoove.poi.policy.NumberingRenderPolicy;
import com.deepoove.poi.policy.PictureRenderPolicy;
import com.deepoove.poi.policy.RenderPolicy;
import com.deepoove.poi.policy.TableRenderPolicy;
import com.deepoove.poi.policy.TextRenderPolicy;
import com.deepoove.poi.policy.reference.DefaultChartTemplateRenderPolicy;
import com.deepoove.poi.policy.reference.DefaultPictImageTemplateRenderPolicy;
import com.deepoove.poi.policy.reference.DefaultPictureTemplateRenderPolicy;
import com.deepoove.poi.policy.reference.MultiSeriesChartTemplateRenderPolicy;
import com.deepoove.poi.policy.reference.SingleSeriesChartTemplateRenderPolicy;
import com.deepoove.poi.render.compute.RenderDataComputeFactory;
import com.deepoove.poi.resolver.ElementTemplateFactory;
import com.deepoove.poi.template.ChartTemplate;
import com.deepoove.poi.template.MetaTemplate;
import com.deepoove.poi.template.PictImageTemplate;
import com.deepoove.poi.template.PictureTemplate;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.junit.jupiter.api.Test;

class ConfiguretoString_PairgetRightFikaTest {

    @Test
    void testToStringInvokesPairGetRight() {
        Configure configure = new Configure();
        configure.toString();
    }
}
