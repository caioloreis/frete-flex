package tech.buildrun.frete_flex.service;

import org.springframework.stereotype.Service;
import tech.buildrun.frete_flex.domain.ShippingCalculator;


@Service
public class ShippingService {
    private final ShippingCalculator shippingCalculator;

    public ShippingService(ShippingCalculator shippingCalculator) {
        this.shippingCalculator = shippingCalculator;

    }


    public Double calculate(String shippingType,
                            Double distance,
                            Double weight){

        if (shippingType.equalsIgnoreCase("standard")) {
            return shippingCalculator.calculate(distance, weight);

        }else if (shippingType.equalsIgnoreCase("express")) {
            return shippingCalculator.calculate(distance, weight);
        }

        return null;
    }

}
