package com.ljb.service.impl;

import com.ljb.cache.JedisPoolUtil;
import com.ljb.dao.SysMenuDao;
import com.ljb.dao.SysRoleMenuDao;
import com.ljb.entity.SysMenu;
import com.ljb.entity.SysRoleMenu;
import com.ljb.example.SysMenuExample;
import com.ljb.example.SysRoleMenuExample;
import com.ljb.security.IdentityUtils;
import com.ljb.service.SysRoleMenuService;
import com.ljb.utils.*;
import com.ljb.model.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 角色菜单Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService<SysRoleMenu, Integer, SysRoleMenuExample> {
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public Collection<Object> menuList(Integer roleId, Integer adminId) {
        List<MenuModel> result = new ArrayList<>();
        List<SysMenu> allMenu = new ArrayList<>();
        allMenu = sysMenuDao.findByUserId(adminId);
        SysMenuExample sysMenuExample = new SysMenuExample();
        List<SysMenu> hasMenu = sysMenuDao.findByRoleId(roleId);
        List<Integer> integers=new ArrayList<>();
        for (SysMenu menu : hasMenu) {
            integers.add(menu.getId());
        }
        List<ZTree> list = new ArrayList<>();
        for(int i=0;i<allMenu.size();i++){
            ZTree zTree = new ZTree();
            BeanUtils.copyProperties(allMenu.get(i),zTree);
            if (integers.contains(allMenu.get(i).getId()))
                zTree.setChecked(true);
            list.add(zTree);
        }
        return TreeUtils.buildTree(list);
    }

    @Override
    public int save(Integer roleId, Integer[] menuIds, Integer adminId) {
        SysRoleMenuExample sysRoleMenuExample = new SysRoleMenuExample();
        sysRoleMenuExample.createCriteria().andRoleIdEqualTo(roleId);
        sysRoleMenuDao.deleteByExample(sysRoleMenuExample);
        List<SysRoleMenu> list = new ArrayList<>();
        for (Integer menuId : menuIds) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenu.setRoleId(roleId);
            sysRoleMenu.setCreateId(adminId);
            sysRoleMenu.setCreateTime(DateUtils.currentTime());
            list.add(sysRoleMenu);
        }
        JedisPoolUtil.clear("*SysMenuDao.findByRoleId*");
        return sysRoleMenuDao.saveBatch(list) > 0 ? 1 : 0;
    }

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysRoleMenuDao.selectMapList(query);
        Long total = sysRoleMenuDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public SysRoleMenu selectById(Integer id) {
        return sysRoleMenuDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectMapById(Integer id) {
        return sysRoleMenuDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return sysRoleMenuDao.deleteBatch(ids);
    }

    @Override
    public int save(SysRoleMenu entity) {
        entity.setCreateId(IdentityUtils.getUserId());
        entity.setCreateTime(DateUtils.currentTime());
        return sysRoleMenuDao.insert(entity);
    }

    @Override
    public int update(SysRoleMenu entity) {
        entity.setUpdateId(IdentityUtils.getUserId());
        entity.setUpdateTime(DateUtils.currentTime());
        return sysRoleMenuDao.updateByPrimaryKeySelective(entity);
    }

}
