package com.study.controller;

import com.study.annotation.SysLog;
import com.study.service.SysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/log")
public class SysLogController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysLogService sysLogService;

    @SysLog("获取日志列表")
    @ResponseBody
    @RequestMapping(value = "/all")
    public Object getLogList() {
        HashMap map = new HashMap();
        return sysLogService.queryList(map);
    }
}