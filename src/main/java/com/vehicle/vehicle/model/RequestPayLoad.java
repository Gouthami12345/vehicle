package com.vehicle.vehicle.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestPayLoad implements Serializable {
    private String vin, year, make, model, transmissionType;
}
