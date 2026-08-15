package tech.buildrun.frete_flex.domain;

import org.springframework.stereotype.Component;

@Component
public class StandardShippingCalculate implements ShippingCalculate {

    @Override
    public Double calculate(Double distance, Double weight) {

        return weight * 1.0 + distance * 0.5;
    }
}
