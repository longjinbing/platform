package com.ljb.service.impl;

import com.ljb.annotion.DescBean;
import com.ljb.security.IdentityUtils;
import com.ljb.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.ljb.dao.SysMenuDao;
import com.ljb .entity.SysMenu;
import com.ljb.service.SysMenuService;
import com.ljb.example.SysMenuExample;

/**
 * 菜单管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Service
public class SysMenuServiceImpl implements SysMenuService<SysMenu,Integer, SysMenuExample> {
    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    private DescBean descBean;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysMenuDao.selectMapList(query);
        Long total = sysMenuDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public SysMenu selectById(Integer id) {
        return sysMenuDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return sysMenuDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return sysMenuDao.deleteBatch(ids);
    }

    @Override
    public int save(SysMenu entity) {
                                                                                                                                                                                                                                                                                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                        entity.setCreateTime(DateUtils.currentTime());
                            return sysMenuDao.insert(entity);
    }

    @Override
    public int update(SysMenu entity) {
                                                                                                                                                                                                                                                                                                    entity.setUpdateId(IdentityUtils.getUserId());
                                                                        entity.setUpdateTime(DateUtils.currentTime());
                                                                                            return sysMenuDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public Boolean resetMenu() {
        sysMenuDao.deleteByExample(null);
        List<ZTree> ztreeList = descBean.getZtree();
        for (ZTree root : ztreeList) {
            int rootNum = 1;
            List<ZTree> menuList = root.getChildren();
            SysMenu r = new SysMenu();
            r.setName(root.getName());
            r.setIcon(root.getIcon());
            r.setOrderNum(rootNum);
            r.setType(0);
            r.setParentId(0);
            r.setStatus(1);
            r.setUrl("#");
            sysMenuDao.insert(r);
            rootNum++;
            int menuNum = 1;
            if (menuList != null) {
                for (ZTree menu : menuList) {
                    SysMenu m = new SysMenu();
                    m.setName(menu.getName());
                    m.setIcon(menu.getIcon());
                    m.setOrderNum(menuNum);
                    m.setType(1);
                    m.setParentId(r.getId());
                    m.setUrl(menu.getUrl());
                    m.setStatus(menu.getChecked() ? 1 : 0);
                    sysMenuDao.insert(m);
                    menuNum++;
                    List<ZTree> buttonList = menu.getChildren();
                    int buttonNum = 1;
                    if (buttonList != null) {
                        for (ZTree button : buttonList) {
                            SysMenu b = new SysMenu();
                            b.setName(button.getName());
                            b.setIcon(button.getIcon());
                            b.setOrderNum(buttonNum);
                            b.setType(2);
                            b.setParentId(m.getId());
                            b.setUrl(button.getUrl());
                            b.setStatus(button.getChecked() ? 1 : 0);
                            sysMenuDao.insert(b);
                            buttonNum++;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public Collection<Object> menuList(Integer sysUserId) {
        return TreeUtils.buildTree(sysMenuDao.menuList(sysUserId));
    }

    @Override
    public Collection<Object> zTreeList(Integer sysUserId) {
        List<SysMenu> menus = getAllSysMenu(sysUserId);
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(0);
        sysMenu.setName("主菜单");
        sysMenu.setParentId(-1);
        sysMenu.setType(-1);
        menus.add(sysMenu);
        return TreeUtils.buildTree(menus);
    }

    @Override
    public Collection<Object> menuSelectList(Integer sysUserId) {
        return TreeUtils.buildTree(getAllSysMenu(sysUserId));
    }

    public List<SysMenu> getAllSysMenu(Integer sysUserId) {
        List<SysMenu> sysMenus = sysMenuDao.findByUserId(sysUserId);
        return sysMenus;
    }


}
