package com.example.TaskManager.Util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListMapper <T,E>{


    private final ModelMapper modelMapper;

    public ListMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public List<?> mapList(List<T> list,E convertTo ){
        return list.stream()
                .map(x-> modelMapper.map(x, convertTo.getClass()))
                .collect(Collectors.toList());
    }
}
