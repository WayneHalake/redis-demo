package com.example.demo.controller;


import com.example.demo.entity.TManagerUser;
import com.example.demo.service.ITManagerUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wayne
 * @since 2020-03-18
 */
@RestController
@RequestMapping("/managerUser")
public class TManagerUserController {

    private static final Logger logger = LoggerFactory.getLogger(TManagerUserController.class);

    @Autowired
    private ITManagerUserService managerUserService;

    @GetMapping("/selectUserById")
    public void selectManagerUser(String id){
        TManagerUser managerUser = managerUserService.getById(id);

        logger.info("managerUser: {}", managerUser.toString());
    }
}
