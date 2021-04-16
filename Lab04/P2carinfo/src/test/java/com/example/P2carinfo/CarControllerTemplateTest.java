package com.example.P2carinfo;

import com.example.P2carinfo.car.Car;
import com.example.P2carinfo.car.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class CarControllerTemplateTest {
    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository carRepository;

    @AfterEach
    public void resetDB(){carRepository.deleteAll();}

    @Test
    public void whenValidInput_thenCreateCar() throws IOException, Exception{
        Car tesla = new Car("ModelS","Tesla");
        Long teslaId = tesla.getCarId();
        ResponseEntity<Car> entity = restTemplate.postForEntity("/cars/create", tesla, Car.class);
        Car found = carRepository.findByCarId(10L);
        assertThat(found.getCarId()).isEqualTo(tesla.getCarId());
    }
}
