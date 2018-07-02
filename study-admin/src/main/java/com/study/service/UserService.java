package com.study.service;

import com.study.model.User;

import java.util.List;

/**
 * 用户
 *
 * @author wupeiming
 * @create 2018-06-21 15:51
 */

public interface UserService {
    List<User> findAllUser(int pageNum, int pageSize);
}
