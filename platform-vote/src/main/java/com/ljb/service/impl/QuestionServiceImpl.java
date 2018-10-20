package com.ljb.service.impl;

import com.ljb.dao.CommentDao;
import com.ljb.dao.CommentQuestionDao;
import com.ljb.dao.QuestionDao;
import com.ljb.entity.Comment;
import com.ljb.entity.CommentQuestion;
import com.ljb.entity.Question;
import com.ljb.entity.QuestionModel;
import com.ljb.example.CommentExample;
import com.ljb.example.QuestionExample;
import com.ljb.security.IdentityUtils;
import com.ljb.service.QuestionService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import com.ljb.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 评价问题Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
@Service
public class QuestionServiceImpl implements QuestionService<Question, Integer, QuestionExample> {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private CommentQuestionDao commentQuestionDao;
    @Autowired
    private CommentDao commentDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = questionDao.selectMapList(query);
        Long total = questionDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public R selectList(Integer id) {
        Comment comment=commentDao.selectByPrimaryKey(id);
        if(comment.getType()!=1){
            return R.error(-1, "系统暂时不支持该种评价");
        }
        List<Map<String, Object>> list = questionDao.questionList(1);
        return R.ok().put("data", list);
    }

    @Override
    public Question selectById(Integer id) {
        return questionDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectMapById(Integer id) {
        return questionDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return questionDao.deleteBatch(ids);
    }

    @Override
    public int saveByComment(QuestionModel entity) {
        save(entity);
        CommentQuestion commentQuestion=new CommentQuestion();
        commentQuestion.setQuestionId(entity.getId());
        commentQuestion.setCommentId(entity.getCommentId());
        commentQuestion.setCreateId(IdentityUtils.getUserId());
        commentQuestion.setCreateTime(DateUtils.currentTime());
        return commentQuestionDao.insert(commentQuestion);
    }

    @Override
    public int save(Question entity) {
        entity.setCreateId(IdentityUtils.getUserId());
        entity.setCreateTime(DateUtils.currentTime());
        return questionDao.insert(entity);
    }

    @Override
    public int update(Question entity) {
        return questionDao.updateByPrimaryKeySelective(entity);
    }

}
