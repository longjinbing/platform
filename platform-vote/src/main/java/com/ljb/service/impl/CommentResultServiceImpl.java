package com.ljb.service.impl;

import com.ljb.dao.CommentResultDao;
import com.ljb.dao.CommentResultDetailsDao;
import com.ljb.dao.CourseCommentDao;
import com.ljb.dao.SysUserDao;
import com.ljb.entity.*;
import com.ljb.example.CommentResultDetailsExample;
import com.ljb.example.CommentResultExample;
import com.ljb.security.IdentityUtils;
import com.ljb.service.CommentResultService;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.apache.commons.collections4.MultiSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.zip.CRC32;

/**
 * 评价结果Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
@Service
public class CommentResultServiceImpl implements CommentResultService<CommentResult, Integer, CommentResultExample> {
    @Autowired
    private CommentResultDao commentResultDao;
    @Autowired
    CommentResultDetailsDao commentResultDetailsDao;
    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    CourseCommentDao courseCommentDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = commentResultDao.selectMapList(query);
        Long total = commentResultDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public PageUtils selectResultList(Map<String, Object> map) {
        Query query = new Query(map);
        Integer commentId=Integer.valueOf(map.get("pid").toString());
        CommentResultExample commentResultExample=new CommentResultExample();
        commentResultExample.createCriteria().andCommentIdEqualTo(commentId);
        Map<Integer,Object> result=new HashMap<>();
         List<CommentResult> commentResults=commentResultDao.selectByExample(commentResultExample);
         List<CommentResult> cR= null;
        for(CommentResult commentResult:commentResults){
            if(result.containsKey(commentResult.getUserId())){
                cR=(List<CommentResult>) map.get(commentResult.getCreateId());
            }else{
                cR=new ArrayList<>();
            }
            cR.add(commentResult);
            result.put(commentResult.getCreateId(), cR);
        }
        Set<Map.Entry<Integer,Object>> set=result.entrySet();
        Iterator iterator=set.iterator();
        List<Map<String,Object>> grades=new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<Integer,Object> entry=(Map.Entry<Integer,Object>)iterator.next();
            List<CommentResult> commentResultList=(List<CommentResult>)entry.getValue();
            Map<String,Object> m=new HashMap<>();
            SysUser sysUser=null;
            double self=0,every=0,sum=0;
            boolean s=false;
            int e=0;
            for(CommentResult cr:commentResultList){
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
                    m= BeanUtils.bean2Map(cr,true);
                    sysUser=sysUserDao.selectByPrimaryKey(cr.getUserId());
                }
            }
            map.put("username",sysUser.getUsername());
            map.put("monile", sysUser.getMobile());
            map.put("number", sysUser.getNumber());
            sum=self*0.6+(every/e)*0.4;
            m.put("self", (int)(self*0.6));
            m.put("every",(int)((every/e)*0.6));
            m.put("sum",(int)sum );
            m.put("selfStatus",s?"已完成":"未完成");
            m.put("everyStatus", e);
            grades.add(m);
        }
        PageUtils pageUtils = new PageUtils(grades,Long.valueOf( grades.size()), query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public PageUtils selectHList(Map<String, Object> map) {
        map.put("pid", IdentityUtils.getUserId());
        Query query = new Query(map);
        List<Map<String, Object>> list = commentResultDao.selectMapHList(query);
        Long total = commentResultDao.selectHCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }


    @Override
    public CommentResult selectById(Integer id) {
        return commentResultDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectHMapById(Integer id) {
        return commentResultDao.selectHMapById(id);
    }

    @Override
    public Map<String, Object> selectMapById(Integer id) {
        return commentResultDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return commentResultDao.deleteBatch(ids);
    }

    @Override
    public int save(CommentResult entity) {
        entity.setCreateId(IdentityUtils.getUserId());
        entity.setCreateTime(DateUtils.currentTime());
        return commentResultDao.insert(entity);
    }

    @Override
    public int save(QuestionAnswer questionAnswer) {
        CommentResult commentResult = commentResultDao.selectByPrimaryKey(questionAnswer.getCommentResultId());
        commentResult.setCreateTime(DateUtils.currentTime());
        commentResult.setUpdateId(IdentityUtils.getUserId());
        commentResult.setStatus(2);
        CommentResultDetails commentResultDetails = new CommentResultDetails();
        commentResultDetails.setCreateId(IdentityUtils.getUserId());
        commentResultDetails.setCreateTime(DateUtils.currentTime());
        int sum = 0;
        for (int i = 1; i <= questionAnswer.getAnswers().size(); i++) {
            try {
                switch (questionAnswer.getAnswers().get(i - 1)) {
                    case "A":
                        sum += 5;
                        break;
                    case "B":
                        sum += 4.5;
                        break;
                    case "C":
                        sum += 4;
                        break;
                    case "D":
                        sum += 3.5;
                        break;
                    case "E":
                        sum += 3;
                        break;
                    default:
                        break;
                }
                Method method = commentResultDetails.getClass().getMethod("setA" + i, String.class);
                method.invoke(commentResultDetails, questionAnswer.getAnswers().get(i - 1));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        commentResult.setRemark(String.valueOf(sum+5));
        commentResultDao.updateByPrimaryKey(commentResult);
        commentResultDetails.setCommentId(commentResult.getCommentId());
        commentResultDetails.setCommentResultId(commentResult.getId());
        commentResultDetails.setStatus(1);
        return commentResultDetailsDao.insert(commentResultDetails);
    }

    @Override
    public int update(CommentResult entity) {
        entity.setUpdateId(IdentityUtils.getUserId());
        entity.setUpdateTime(DateUtils.currentTime());
        return commentResultDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int update(QuestionAnswer questionAnswer) {
        CommentResult commentResult = commentResultDao.selectByPrimaryKey(questionAnswer.getCommentResultId());
        commentResult.setUpdateTime(DateUtils.currentTime());
        commentResult.setUpdateId(IdentityUtils.getUserId());
        commentResult.setStatus(3);
        CommentResultDetailsExample commentResultDetailsExample = new CommentResultDetailsExample();
        commentResultDetailsExample.createCriteria().andCommentResultIdEqualTo(commentResult.getId());
        CommentResultDetails commentResultDetails = commentResultDetailsDao.selectByExample(commentResultDetailsExample).get(0);
        commentResultDetails.setUpdateId(IdentityUtils.getUserId());
        commentResultDetails.setUpdateTime(DateUtils.currentTime());
        commentResultDetails.setCommentResultId(commentResult.getId());
        int sum=0;
        for (int i = 1; i <= questionAnswer.getAnswers().size(); i++) {
            try {
                switch (questionAnswer.getAnswers().get(i - 1)) {
                    case "A":
                        sum += 5;
                        break;
                    case "B":
                        sum += 4.5;
                        break;
                    case "C":
                        sum += 4;
                        break;
                    case "D":
                        sum += 3.5;
                        break;
                    case "E":
                        sum += 3;
                        break;
                    default:
                        break;
                }
                Method method = commentResultDetails.getClass().getMethod("setA" + i, String.class);
                method.invoke(commentResultDetails, questionAnswer.getAnswers().get(i - 1));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        commentResult.setRemark(String.valueOf(sum+5));
        commentResultDao.updateByPrimaryKey(commentResult);
        return commentResultDetailsDao.updateByPrimaryKey(commentResultDetails);
    }

}
