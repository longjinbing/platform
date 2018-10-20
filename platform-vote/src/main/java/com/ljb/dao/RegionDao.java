package com.ljb.dao;

import com.ljb.entity.Region;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 地区管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:04:53
 */
@Repository
public interface RegionDao{
    List<Map<String,Object>> schoolList();
    List<Map<String,Object>> collegeList();
    List<Map<String,Object>> teacherList();
}
