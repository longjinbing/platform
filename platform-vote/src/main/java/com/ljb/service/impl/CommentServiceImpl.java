package com.ljb.service.impl;

import com.ljb.cache.JedisPoolUtil;
import com.ljb.dao.*;
import com.ljb.entity.*;
import com.ljb.example.*;
import com.ljb.security.IdentityUtils;
import com.ljb.service.CommentService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import com.ljb.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import javax.validation.constraints.Max;
import java.util.*;

/**
 * 评价管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
@Service
public class CommentServiceImpl implements CommentService<Comment, Integer, CommentExample> {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CourseCommentDao courseCommentDao;
    @Autowired
    private CourseUserDao courseUserDao;
    @Autowired
    private CommentResultDao commentResultDao;
    @Autowired
    CommentResultDetailsDao commentResultDetailsDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = commentDao.selectMapList(query);
        Long total = commentDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public PageUtils selectHList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = commentDao.selectMapHList(query);
        Long total = commentDao.selectHCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }
    @Override
    public Map<String,Object> selectResult(Integer id) {
        CommentResult commentResult=commentResultDao.selectByPrimaryKey(id);
        CommentResultExample commentResultExample=new CommentResultExample();
        commentResultExample.createCriteria().andUserIdEqualTo(commentResult.getCreateId()).andCommentIdEqualTo(commentResult.getCommentId());
        List<CommentResult> commentResults=commentResultDao.selectByExample(commentResultExample);
        if(commentResults.size()==0){
            return null;
        }
        double self=0,every=0,sum=0;
        boolean s=false;
        int e=0;
        for(CommentResult cr:commentResults){
            if(!cr.getUserId().equals(cr.getCreateId())){
                if(cr.getRemark() != null && !cr.getRemark().isEmpty()) {
                    every += Double.valueOf(cr.getRemark());
                    e++;
                }else{
                    every+=0;
                }
            }else{
                if(cr.getRemark() != null && !cr.getRemark().isEmpty()) {
                    self += Double.valueOf(cr.getRemark());
                    s=true;
                }else{
                    self+=0;
                }
            }
        }
        sum=self*0.6+(every/e)*0.4;
        Map<String,Object> result=new HashMap<>();
        result.put("self", (int)(self*0.6));
        result.put("every",(int)((every/e)*0.6));
        result.put("sum",(int)sum );
        result.put("selfStatus",s?"已完成":"未完成");
        result.put("everyStatus", e);
        return result;
    }


    @Override
    public Comment selectById(Integer id) {
        return commentDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectMapById(Integer id) {
        return commentDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return commentDao.deleteBatch(ids);
    }

    @Override
    public int save(Comment entity) {
        entity.setCreateId(IdentityUtils.getUserId());
        entity.setCreateTime(DateUtils.currentTime());
        return commentDao.insert(entity);
    }

    @Override
    public int saveByCourse(CommentModel entity) {
        entity.setStatus(1);
        save((Comment)entity);
        CourseComment courseComment=new CourseComment();
        courseComment.setCourseId(entity.getCourseId());
        courseComment.setCreateId(IdentityUtils.getUserId());
        courseComment.setCreateTime(DateUtils.currentTime());
        courseComment.setCommentId(entity.getId());
        return courseCommentDao.insert(courseComment);
    }

    @Override
    public int update(Comment entity) {
        entity.setUpdateId(IdentityUtils.getUserId());
        entity.setUpdateTime(DateUtils.currentTime());
        return commentDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public R start(Integer id) {
        Comment comment= commentDao.selectByPrimaryKey(id);
        if(comment==null){
            return R.error(-1, "数据错误");
        }
        if(comment.getType()!=1){
            return R.error(-1, "暂时不支持此种类型评价");
        }
        CourseCommentExample courseCommentExample=new CourseCommentExample();
        courseCommentExample.createCriteria().andCommentIdEqualTo(comment.getId());
        List<CourseComment> list=courseCommentDao.selectByExample(courseCommentExample);
        if(list.size()<=0){
            return R.error(-1, "数据错误");
        }
        CourseUserExample courseUserExample=new CourseUserExample();
        courseUserExample.createCriteria().andCourseIdEqualTo(list.get(0).getCourseId());
        List<CourseUser> courseUserlist=courseUserDao.selectByExample(courseUserExample);
        if(courseUserlist.size()<20){
            return R.error(-1, " 课程最少需要有20位学生才能开始评价");
        }
        //4次互评 1次自评
        List<Integer> userIds=new ArrayList<>();
        for(CourseUser courseUser:courseUserlist){
            userIds.add(courseUser.getUserId());
        }

        List<CommentResult> commentResults=new ArrayList<>();
        List<Integer> indexs=new ArrayList<>();
        Random random=new Random();
        for(int j=0;j<4;j++){
            int first = random.nextInt(userIds.size());
            while (indexs.contains(first)){
                first = random.nextInt(userIds.size());
            }
            indexs.add(first);
            for (int i = 0; i < userIds.size(); i++) {
                CommentResult commentResult = new CommentResult();
                if (first + i >= userIds.size()) {
                    commentResult.setUserId( userIds.get(first + i - userIds.size()));
                } else {
                    commentResult.setUserId(userIds.get(first + i));
                }
                commentResult.setCreateId(courseUserlist.get(i).getUserId());
                commentResult.setStatus(1);
                commentResult.setCommentId(comment.getId());
                commentResults.add(commentResult);
            }
        }
        for (int i = 0; i < userIds.size(); i++) {
            CommentResult commentResult = new CommentResult();
            commentResult.setUserId(userIds.get(i));
            commentResult.setCreateId(userIds.get(i));
            commentResult.setStatus(1);
            commentResult.setCommentId(comment.getId());
            commentResults.add(commentResult);
        }
        commentResultDao.saveBatch(commentResults);
        comment.setStatus(2);
        commentDao.updateByPrimaryKeySelective(comment);
        return R.ok("开启评价成功");
    }
    @Override
    public R clear(Integer id) {
        Comment comment= commentDao.selectByPrimaryKey(id);
        if(comment==null){
            return R.error(-1, "数据错误");
        }
        comment.setStatus(1);
        commentDao.updateByPrimaryKeySelective(comment);
        CommentResultExample commentResultExample=new CommentResultExample();
        commentResultExample.createCriteria().andCommentIdEqualTo(comment.getId());
        commentResultDao.deleteByExample(commentResultExample);
        CommentResultDetailsExample commentResultDetailsExample=new CommentResultDetailsExample();
        commentResultDetailsExample.createCriteria().andCommentIdEqualTo(comment.getId());
        commentResultDetailsDao.deleteByExample(commentResultDetailsExample);
        return R.ok("清除评价完成");
    }

    @Override
    public R complete(Integer id) {
        Comment comment= commentDao.selectByPrimaryKey(id);
        if(comment==null){
            return R.error(-1, "数据错误");
        }
        comment.setStatus(3);
        commentDao.updateByPrimaryKeySelective(comment);
        commentResultDao.complete(id);
        return R.ok("完成评价成功");
    }
}
