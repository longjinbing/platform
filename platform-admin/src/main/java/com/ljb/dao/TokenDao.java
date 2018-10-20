package com.ljb.dao;

import com.ljb.entity.Token;
import com.ljb.example.TokenExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 用户票据Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-15 17:20:47
 */
@Repository
public interface TokenDao extends BaseDao<Token,Integer,TokenExample> {

}
