package com.frankie.fun;

import com.frankie.fun.optional.Car;
import com.frankie.fun.optional.Insurance;
import com.frankie.fun.optional.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author: Yao Frankie
 * @date: 2020/2/14 09:11
 */
@SpringBootTest
public class OptionalTest {

    @Test
    public void mapTest(){
        Optional<Person> personOpt = Optional.of(new Person());
        Optional<Optional<Car>> car = personOpt.map(Person::getCar);

    }

    @Test
    public void listTest(){
        ArrayList<Person> people = new ArrayList<>();

        Insurance insurance1 = new Insurance();
        insurance1.setName("Health");
        Car car1 = new Car();
        car1.setInsurance(Optional.of(insurance1));
        Person person1 = new Person();
        person1.setCar(Optional.of(car1));

        people.add(person1);
        System.out.println(people);

    }
}
