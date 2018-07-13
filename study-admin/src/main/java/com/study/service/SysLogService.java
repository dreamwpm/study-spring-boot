package com.study.service;

import com.study.entity.SysLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 */
public interface SysLogService {

    Object queryObject(Long id);

    List<SysLogEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(SysLogEntity sysLog);

    void update(SysLogEntity sysLog);

    void delete(Long id);

    void deleteBatch(Long[] ids);
}
