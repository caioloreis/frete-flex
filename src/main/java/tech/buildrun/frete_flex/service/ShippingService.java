package tech.buildrun.frete_flex.service;

import org.springframework.stereotype.Service;
import tech.buildrun.frete_flex.domain.ExpressShippingCalculate;
import tech.buildrun.frete_flex.domain.StandardShippingCalculate;

@Service
public class ShippingService {
    private final StandardShippingCalculate standardShippingCalculate;
    private final ExpressShippingCalculate expressShippingCalculate;

    public ShippingService(StandardShippingCalculate standardShippingCalculate,
                            ExpressShippingCalculate expressShippingCalculate1) {
        this.standardShippingCalculate = standardShippingCalculate;
        this.expressShippingCalculate = expressShippingCalculate1;
    }


    public Double calculate(String shippingType,
                            Double distance,
                            Double weight){

        if (shippingType.equalsIgnoreCase("standard")) {
            return standardShippingCalculate.calculate(distance, weight);

        }else if (shippingType.equalsIgnoreCase("express")) {
            return expressShippingCalculate.calculate(distance, weight);
        }

        return null;
    }

}
