package com.example.P2carinfo;

import com.example.P2carinfo.car.Car;
import com.example.P2carinfo.car.CarManagerService;
import com.example.P2carinfo.car.CarRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService sutCarService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void givenCar_whenGetCarDetails_thenReturnCarInfo() {
        Car mazda = new Car("mazda3", "mazda");
        mazda.setCarId(10L);
        given( carRepository.findByCarId(10L)).willReturn(mazda);
        Car car = sutCarService.getCarDetails( 10L);
        Assertions.assertThat( car.getCarId()).isEqualTo(10L);
    }

}
