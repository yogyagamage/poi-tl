package com.deepoove.poi.config;

import com.deepoove.poi.policy.RenderPolicy;
import com.deepoove.poi.render.compute.DefaultELRenderDataCompute;
import com.deepoove.poi.render.compute.EnvModel;
import com.deepoove.poi.render.compute.RenderDataComputeFactory;
import com.deepoove.poi.render.compute.SpELRenderDataCompute;
import com.deepoove.poi.template.MetaTemplate;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.junit.jupiter.api.Test;

public class ConfigureBuilderbuidIterableLeft_PairgetRightFikaTest {

    @Test
    public void testBuidIterableLeft() {
        ConfigureBuilder builder = new ConfigureBuilder();
        builder.buidIterableLeft('a');
    }
}
