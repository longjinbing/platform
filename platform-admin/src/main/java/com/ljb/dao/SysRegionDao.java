package com.ljb.dao;

import com.ljb.entity.SysRegion;
import com.ljb.example.SysRegionExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 地区管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:04:53
 */
@Repository
public interface SysRegionDao extends BaseDao<SysRegion,Integer,SysRegionExample> {
    List<SysRegion> zTreeList();
}
