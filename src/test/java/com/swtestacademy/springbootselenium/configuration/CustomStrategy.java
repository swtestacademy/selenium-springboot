package com.swtestacademy.springbootselenium.configuration;

import org.junit.platform.commons.JUnitException;
import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;

public class CustomStrategy implements ParallelExecutionConfiguration, ParallelExecutionConfigurationStrategy {
    private int parallelism;

    @Override
    public int getParallelism() {
        return parallelism;
    }

    @Override
    public int getMinimumRunnable() {
        return 0;
    }

    @Override
    public int getMaxPoolSize() {
        return 256 + parallelism;
    }

    @Override
    public int getCorePoolSize() {
        return parallelism;
    }

    @Override
    public int getKeepAliveSeconds() {
        return 60;
    }

    @Override
    public Predicate<? super ForkJoinPool> getSaturatePredicate() {
        return (ForkJoinPool p) -> true;
    }

    @Override
    public ParallelExecutionConfiguration createConfiguration(ConfigurationParameters configurationParameters) {
        this.parallelism = configurationParameters.get("custom.parallelism", Integer::valueOf).orElseThrow(() ->
                new JUnitException(String.format("Configuration parameter '%s' must be: ",
                        "junit.jupiter.execution.parallel.config.custom.parallelism")));
        return this;
    }
}
