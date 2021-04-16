package com.example.P2carinfo;

import com.example.P2carinfo.car.Car;
import com.example.P2carinfo.car.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void whenFindByName_thenReturnCar(){
        Car tesla = new Car("ModelS","Tesla");

        entityManager.persistAndFlush(tesla);

        Car found = carRepository.findByCarId(10L);

        assertThat(found.getCarId()).isEqualTo(tesla.getCarId());
    }

    @Test
    public  void whenInvalidName_thenReturnNull(){
        Car nonExistant = carRepository.findByCarId(20L);
        assertThat(nonExistant).isNull();
    }
}
