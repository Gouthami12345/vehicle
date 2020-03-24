package com.vehicle.vehicle.resource;

import com.vehicle.vehicle.exception.VehicleException;
import com.vehicle.vehicle.invriant.VehicleInvariant;
import com.vehicle.vehicle.model.RequestPayLoad;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequestMapping("v1")
@RestController("vehicles")
public class VehicleResource {
    @Autowired
    VehicleInvariant vehicleInvariant;

    @PostMapping(value = "vehicle", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createVehicle(@RequestBody RequestPayLoad requestPayLoad) {
        MDC.put("uuid", Optional.ofNullable(MDC.get("uuid")).orElse(UUID.randomUUID().toString()));
        vehicleInvariant.validate(requestPayLoad);
        log.info("Request payLoad:: {} ", requestPayLoad);
        return ResponseEntity.ok().body(MDC.get("uuid"));
    }
}
