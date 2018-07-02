package com.study.controller;

import com.study.common.annotation.SysLog;
import com.study.service.SysUserService;
import com.study.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class SysUserController {
    private final Logger log= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private UserService userService;

    @SysLog("获取mysql用户列表")
    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return sysUserService.findAllUser(pageNum,pageSize);
    }

    @SysLog("获取oracle用户列表")
    @ResponseBody
    @RequestMapping(value = "/all-oracle/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllOracleUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/log")
    public String getlog(){
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
        return "123";
    }

    @RequestMapping("/index")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }




}