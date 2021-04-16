package com.example.P2carinfo;

import com.example.P2carinfo.car.Car;
import com.example.P2carinfo.car.CarController;
import com.example.P2carinfo.car.CarManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService service;

    @Test
    public void givenCar_whenGetCar_thenReturnCar() throws Exception{
        Car tesla = new Car("ModelS", "Tesla");
        tesla.setCarId(10L);
        Long teslaId = tesla.getCarId();
        given(service.getCarDetails(10L)).willReturn(tesla);

        mvc.perform(MockMvcRequestBuilders.get("/cars/" + teslaId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("model").value("ModelS"));

        verify(service, VerificationModeFactory.times(1)).getCarDetails(teslaId);
        reset(service);
    }
}
