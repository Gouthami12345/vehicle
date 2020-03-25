package com.vehicle.vehicle.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicle.vehicle.VehicleApplication;
import com.vehicle.vehicle.invriant.VehicleInvariant;
import com.vehicle.vehicle.model.RequestPayLoad;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = VehicleApplication.class)
@WebMvcTest(VehicleResource.class)
//@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@Import(VehicleInvariant.class)
class VehicleResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void createVehicle() throws Exception {
        RequestPayLoad requestPayLoad = new RequestPayLoad();
        requestPayLoad.setTransmissionType("AUTO");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/vehicles/vehicle")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(requestPayLoad))
        );
    }
    @Test
    void createVehicle_400() throws Exception {
        RequestPayLoad requestPayLoad = new RequestPayLoad();
        requestPayLoad.setTransmissionType("");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/vehicles/vehicle")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(requestPayLoad))
        );
    }

    @Test
    void createVehicle_Exception() throws Exception {
        RequestPayLoad requestPayLoad = new RequestPayLoad();
        requestPayLoad.setTransmissionType("AUTO");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/vehicles/vehicle")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(String.valueOf(requestPayLoad))
        );
    }
}