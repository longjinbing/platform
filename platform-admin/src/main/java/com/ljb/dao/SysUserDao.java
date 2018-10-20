package com.ljb.dao;

import com.ljb.entity.SysUser;
import com.ljb.example.SysUserExample;
import com.ljb.utils.BaseDao;
import java.util.List;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 系统用户Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Repository
public interface SysUserDao extends BaseDao<SysUser,Integer,SysUserExample> {
    SysUser findByNumber(String number);
    List<Map<String, Object>> selectMapTList(Map<String, Object> map);
}
