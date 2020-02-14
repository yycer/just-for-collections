package com.frankie.fun.optional;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * @author: Yao Frankie
 * @date: 2020/2/14 09:09
 */
@Setter
@Getter
public class Car {
    private Optional<Insurance> insurance;
}
