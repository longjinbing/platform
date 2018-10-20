package com.ljb.annotion;

import java.util.List;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import com.ljb.utils.AopTargetUtils;
import com.ljb.utils.StringUtils;
import com.ljb.utils.ZTree;
import com.mysql.fabric.xmlrpc.base.Array;

import freemarker.template.utility.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lvbey
 */

@Component("descBean") // 交给spring管理方便其他类获取该类对象
public class DescBean implements ApplicationContextAware {

	private static Logger logger = LoggerFactory.getLogger(DescBean.class);

	private ApplicationContext applicationContext;

	private String basePackages;

	private List<ZTree> ztreeList;

	/**
	 * 通过依赖注入获取配置文件中的属性值
	 *
	 * @param
	 */
	public void setBasePackages() {
		this.basePackages = "com.ljb.controller";
		ztreeList = new ArrayList<>();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void init() {
		setBasePackages();
		if (this.applicationContext == null) {
			return;
		}
		Map<String, Object> descMap = this.applicationContext.getBeansWithAnnotation(Desc.class);
		logger.info(descMap.toString());
		Class<? extends Object> clazz = null;
		List<ZTree> baseList=new ArrayList<>();
		ZTree root=new ZTree();
		for (Map.Entry<String, Object> entry : descMap.entrySet()) {
			clazz = entry.getValue().getClass();
			String className = (clazz.getName()).substring(0, clazz.getName().indexOf('$')>=0?clazz.getName().indexOf('$'):clazz.getName().length());
			try {
				clazz = Class.forName(className);
				Desc desc1 = (Desc) clazz.getAnnotation(Desc.class);
				RequestMapping requestMapping1=(RequestMapping)clazz.getAnnotation(RequestMapping.class);
				root = getZTree(desc1, "");
				root.setName(desc1.group());
				root.setUrl("#");
				ZTree menu = getZTree(desc1, desc1.url());
				Method[] methods = clazz.getMethods();
				for (Method c : methods) {
					Desc desc2 = (Desc) c.getAnnotation(Desc.class);
					RequestMapping requestMapping2= (RequestMapping) c.getAnnotation(RequestMapping.class);
					if (desc2 != null) {
						ZTree button = getZTree(desc2, requestMapping1.value()[0] + requestMapping2.value()[0]);
						if(desc2.level()==1) {
							menu.addChild(button);
						}else{
                            baseList.add(button);
						}

					}
				}
				root.addChild(menu);
				addZtree(root);
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		addZtree(root);
		ztreeList.add(getBaseZTree(baseList));
	}

	public List<ZTree> getZtree() {
		if (this.ztreeList == null) {
			init();
			logger.info(String.valueOf(ztreeList.get(0).getChildren().size()));
		}
		return this.ztreeList;
	}

	public ZTree getZTree(Desc desc, String url) {
		ZTree zTree = new ZTree();
		zTree.setName(desc.name());
		zTree.setIcon(desc.icon());
		zTree.setChecked(desc.display());
		zTree.setUrl(url.indexOf("/{id}")>-1?url.substring(0, url.indexOf("/{id}")+1):url);
		return zTree;
	}

	public ZTree getBaseZTree(List<ZTree> list){
		ZTree baseRoot=new ZTree();
		baseRoot.setName("基本权限");
		baseRoot.setUrl("#");
		baseRoot.setChecked(false);
		baseRoot.setIcon("glyphicon glyphicon-cog");
		ZTree menuRoot=new ZTree();
		menuRoot .setName("访问权限");
		menuRoot.setUrl("#");
		menuRoot.setChecked(false);
		menuRoot.setIcon("glyphicon glyphicon-cog");
		menuRoot.setChildren(list);
		List<ZTree> menuList=new ArrayList<>();
		menuList.add(menuRoot);
		baseRoot.setChildren(menuList);
		return baseRoot;
	}

	public void addZtree(ZTree root){
			boolean flag = false;
			int index = 0;
			for (int i = 0; i < ztreeList.size(); i++) {
				if (ztreeList.get(i).getName().equals(root.getName())) {
					flag = true;
					index = i;
				}
			}
			if (flag) {
				ZTree zTree = ztreeList.get(index);
				ztreeList.remove(index);
				if(root.getChecked()==true||zTree.getChecked()==true){
					zTree.setChecked(true);
				}
				zTree.addChild(root.getChildren().get(0));
				ztreeList.add(zTree);
			} else {
				ztreeList.add(root);
			}
	}
}
