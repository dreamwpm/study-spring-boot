package com.study.service;

import com.study.model.SysUser;

import java.util.List;

/**
 * 用户
 *
 * @author wupeiming
 * @create 2018-06-21 15:51
 */

public interface SysUserService {
    List<SysUser> findAllUser(int pageNum, int pageSize);
}
