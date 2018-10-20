package com.ljb.dao;

import com.ljb.entity.SysLoginLog;
import com.ljb.example.SysLoginLogExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 系统日志Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-15 16:51:52
 */
@Repository
public interface SysLoginLogDao extends BaseDao<SysLoginLog,Integer,SysLoginLogExample> {

}
