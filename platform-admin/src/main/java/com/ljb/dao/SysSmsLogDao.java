package com.ljb.dao;

import com.ljb.entity.SysSmsLog;
import com.ljb.example.SysSmsLogExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 短信日志Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:05:13
 */
@Repository
public interface SysSmsLogDao extends BaseDao<SysSmsLog,Integer,SysSmsLogExample> {

}
