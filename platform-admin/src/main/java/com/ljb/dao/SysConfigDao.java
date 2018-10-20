package com.ljb.dao;

import com.ljb.entity.SysConfig;
import com.ljb.example.SysConfigExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 系统配置Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:04:53
 */
@Repository
public interface SysConfigDao extends BaseDao<SysConfig,Integer,SysConfigExample> {

}
