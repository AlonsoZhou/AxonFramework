/*
 * Copyright (c) 2010-2018. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.metrics;

import org.axonframework.config.Configurer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class MetricsConfigurerModuleTest {

    private GlobalMetricRegistry globalMetricRegistry;
    private MetricsConfigurerModule metricsConfigurerModule;

    @Before
    public void setUp() {
        globalMetricRegistry = mock(GlobalMetricRegistry.class);
        metricsConfigurerModule = new MetricsConfigurerModule(globalMetricRegistry);
    }

    @Test
    public void testConfigureModuleCallsGlobalMetricRegistry() {
        Configurer configurerMock = mock(Configurer.class);

        metricsConfigurerModule.configureModule(configurerMock);

        verify(globalMetricRegistry).registerWithConfigurer(configurerMock);
    }
}
