package com.xiaohe.controller;

import com.xiaohe.pojo.Type;
import com.xiaohe.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @RequestMapping("findAll")
    public List<Type> findAll(){
        return typeService.findAll();
    }

}
