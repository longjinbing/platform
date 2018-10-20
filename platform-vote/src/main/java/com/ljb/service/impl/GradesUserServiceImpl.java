package com.ljb.service.impl;

import com.ljb.cache.JedisPoolUtil;
import com.ljb.dao.GradesUserDao;
import com.ljb.dao.SysRoleDao;
import com.ljb.dao.SysUserRoleDao;
import com.ljb.entity.GradesUser;
import com.ljb.entity.SysRole;
import com.ljb.entity.SysUser;
import com.ljb.entity.SysUserRole;
import com.ljb.example.GradesUserExample;
import com.ljb.example.SysRoleExample;
import com.ljb.example.SysUserRoleExample;
import com.ljb.security.IdentityUtils;
import com.ljb.service.GradesUserService;
import com.ljb.service.UserImportService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.FileResult;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 班级用户Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Service
public class GradesUserServiceImpl implements GradesUserService<GradesUser, Integer, GradesUserExample> {
    @Autowired
    private GradesUserDao gradesUserDao;
    @Autowired
    private UserImportService userImportService;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = gradesUserDao.selectMapList(query);
        Long total = gradesUserDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public GradesUser selectById(Integer id) {
        return gradesUserDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectMapById(Integer id) {
        return gradesUserDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return gradesUserDao.deleteBatch(ids);
    }

    @Override
    public int save(GradesUser entity) {
        GradesUserExample gradesUserExample = new GradesUserExample();
        gradesUserExample.createCriteria().andUserIdEqualTo(entity.getUserId()).andGradesIdEqualTo(entity.getGradesId());
        if (gradesUserDao.selectByExample(gradesUserExample).size() > 0) {
            return 0;
        }
        entity.setCreateId(IdentityUtils.getUserId());
        entity.setCreateTime(DateUtils.currentTime());
        JedisPoolUtil.clear("*CourseUserDao*");
        return gradesUserDao.insert(entity);
    }

    @Override
    public FileResult saveBatch(MultipartFile file, Integer id) {
        FileResult fileResult = userImportService.importByExcel(file);
        if (fileResult.getMsg() != FileResult.Success) {
            return fileResult;
        }
        List<SysUser> users = (List<SysUser>) fileResult.getList();
        List<GradesUser> gradesUsers = new ArrayList<>();
        List<SysUserRole> sysUserRoles=new ArrayList<>();
        SysRoleExample sysRoleExample=new SysRoleExample();
        sysRoleExample.createCriteria().andNameEqualTo("学生");
        SysRole sysRole=sysRoleDao.selectByExample(sysRoleExample).get(0);
        for (SysUser user : users) {
            GradesUserExample gradesUserExample=new GradesUserExample();
            gradesUserExample.createCriteria().andUserIdEqualTo(user.getId()).andGradesIdEqualTo(id);
            if(gradesUserDao.selectByExample(gradesUserExample).size()<=0) {
                GradesUser gradesUser = new GradesUser();
                gradesUser.setUserId(user.getId());
                gradesUser.setGradesId(id);
                gradesUser.setCreateId(IdentityUtils.getUserId());
                gradesUser.setCreateTime(DateUtils.currentTime());
                gradesUsers.add(gradesUser);
            }
            SysUserRoleExample sysUserRoleExample=new SysUserRoleExample();
            sysUserRoleExample.createCriteria().andUserIdEqualTo(user.getId()).andRoleIdEqualTo(sysRole.getId());
            if(sysUserRoleDao.selectByExample(sysUserRoleExample).size()<=0){
                SysUserRole sysUserRole=new SysUserRole();
                sysUserRole.setUserId(user.getId());
                sysUserRole.setRoleId(sysRole.getId());
                sysUserRole.setCreateId(IdentityUtils.getUserId());
                sysUserRole.setCreateTime(DateUtils.currentTime());
                sysUserRoles.add(sysUserRole);
            }
        }
        if(gradesUsers.size()>0) {
            gradesUserDao.saveBatch(gradesUsers);
        }
        if(sysUserRoles.size()>0){
            sysUserRoleDao.saveBatch(sysUserRoles);
        }
        return fileResult;
    }

    @Override
    public int update(GradesUser entity) {
        return gradesUserDao.updateByPrimaryKeySelective(entity);
    }

}
