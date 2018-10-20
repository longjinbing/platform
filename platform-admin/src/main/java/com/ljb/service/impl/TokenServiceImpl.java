package com.ljb.service.impl;

import com.ljb.cache.JedisPoolUtil;
import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.ljb.dao.TokenDao;
import com.ljb .entity.Token;
import com.ljb.service.TokenService;
import com.ljb.example.TokenExample;

/**
 * 用户票据Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-15 17:20:47
 */
@Service
public class TokenServiceImpl implements TokenService<Token,Integer, TokenExample> {
    @Autowired
    private TokenDao tokenDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = tokenDao.selectMapList(query);
        Long total = tokenDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public void logout(Integer[] ids){
        TokenExample tokenExample=new TokenExample();
        tokenExample.createCriteria().andIdIn(Arrays.asList(ids));
        List<Token> tokens=tokenDao.selectByExample(tokenExample);
        for (Token token:tokens){
            JedisPoolUtil.remove(token.getTicket());
            //待实现去除缓存
            JedisPoolUtil.remove(token.getPrinciple());
        }
        tokenDao.deleteByExample(tokenExample);
    }

    @Override
    public Token selectById(Integer id) {
        return tokenDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return tokenDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return tokenDao.deleteBatch(ids);
    }

    @Override
    public int save(Token entity) {
                                                                                                                entity.setCreateTime(DateUtils.currentTime());
                                                                                entity.setCreateId(IdentityUtils.getUserId());
                                                                                                                                        return tokenDao.insert(entity);
    }

    @Override
    public int update(Token entity) {
                                                                                                                                                                                                                                                                                return tokenDao.updateByPrimaryKeySelective(entity);
    }

}
