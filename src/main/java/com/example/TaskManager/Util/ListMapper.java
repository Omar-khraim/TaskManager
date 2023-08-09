package com.example.TaskManager.Util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListMapper <T,U>{

    @Autowired
    private ModelMapper modelMapper;

    public List<?> MapList(T type, List<U> list){
        return list.stream()
                .map(x-> modelMapper.map(x, type.getClass()))
                .collect(Collectors.toList());
    }
}
