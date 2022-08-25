package com.whs.dubbonacosmybatisplusconsumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.whs.dubbonacosmybatisplusapi.entity.Person;
import com.whs.dubbonacosmybatisplusapi.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 巫浩盛
 * @since 2021-06-30
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Reference
    private PersonService personService;

    @RequestMapping("/getallperson")
    @ResponseBody
    public List<Person> getall(){
        List<Person> result = personService.getAllS();
        return result;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello dubbo demo";
    }

}
