package tech.buildrun.frete_flex.domain;

public interface ShippingCalculator {

    Double calculate(Double distance, Double weight);
}
