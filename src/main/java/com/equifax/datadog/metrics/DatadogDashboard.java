package com.equifax.datadog.metrics;



public class DatadogDashboard {

    private static final DDSketch sketch = DDSketches.unboundedDense();

    public static void sendMetric(String metricName, double value) {
        sketch.accept(value);
        // Send the metric to Datadog using their API
    }
}
