package tech.buildrun.frete_flex.domain;

import org.springframework.stereotype.Component;

@Component
public class ExpressShippingCalculate implements ShippingCalculate {

    @Override
    public Double calculate(Double distance, Double weight) {
        return weight * 1.5 + distance * 0.75;
    }
}
