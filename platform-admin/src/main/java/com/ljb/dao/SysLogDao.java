package com.ljb.dao;

import com.ljb.entity.SysLog;
import com.ljb.example.SysLogExample;
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
public interface SysLogDao extends BaseDao<SysLog,Integer,SysLogExample> {

    int complete(Object[] ids);

}
