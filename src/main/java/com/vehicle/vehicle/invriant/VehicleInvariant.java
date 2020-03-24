package com.vehicle.vehicle.invriant;

import com.vehicle.vehicle.exception.VehicleException;
import com.vehicle.vehicle.model.RequestPayLoad;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class VehicleInvariant {

    public void validate(RequestPayLoad requestPayLoad) {
        if (!Arrays.asList("MANUAL","AUTO").contains(requestPayLoad.getTransmissionType())) {
            throw new VehicleException("Invalid TransmissionType. Supported Types:: MANUAL, AUTO");
        }
    }
}
