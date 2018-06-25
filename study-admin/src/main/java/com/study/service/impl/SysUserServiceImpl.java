package com.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.study.dao.SysUserMapper;
import com.study.model.SysUser;
import com.study.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户
 *
 * @author wupeiming
 * @create 2018-06-21 15:51
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Override
    public List<SysUser> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return sysUserMapper.selectAllUser();
    }
}
