package com.prette.rest_with_spring.business.mappers;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapper {

    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O,D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O,D> List<D> parseListObjects(List<O> origin, Class<D> destination){

        return origin.stream()
                .map(o -> mapper.map(o, destination))
                .collect(Collectors.toList());
    }
}
