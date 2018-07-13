package com.study.controller;

import com.study.annotation.SysLog;
import com.study.service.SysUserService;
import com.study.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUser/{pageNum}/{pageSize}")
    public Object getUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        log.info("=========get({},{})==========",pageNum,pageSize);
        return sysUserService.findAllUser(pageNum, pageSize);
    }

    @PostMapping(value = "/postUser/{pageNum}/{pageSize}")
    public Object postUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        log.info("=========post({},{})==========",pageNum,pageSize);
        return sysUserService.findAllUser(pageNum, pageSize);
    }

    @DeleteMapping(value = "/deleteUser/{pageNum}/{pageSize}")
    public Object deleteUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        log.info("=========delete({},{})==========",pageNum,pageSize);
        return sysUserService.findAllUser(pageNum, pageSize);
    }

    @SysLog("获取mysql用户列表")
    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return sysUserService.findAllUser(pageNum, pageSize);
    }

    @SysLog("获取oracle用户列表")
    @ResponseBody
    @RequestMapping(value = "/all-oracle/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllOracleUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/log")
    public String getlog() {
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