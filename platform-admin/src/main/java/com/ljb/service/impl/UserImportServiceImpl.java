package com.ljb.service.impl;

import com.ljb.dao.SysRoleDao;
import com.ljb.dao.SysUserDao;
import com.ljb.dao.SysUserRoleDao;
import com.ljb.entity.SysRole;
import com.ljb.entity.SysUser;
import com.ljb.entity.SysUserRole;
import com.ljb.example.SysRoleExample;
import com.ljb.example.SysUserRoleExample;
import com.ljb.security.IdentityUtils;
import com.ljb.service.UserImportService;
import com.ljb.utils.Constant;
import com.ljb.utils.DateUtils;
import com.ljb.utils.FileResult;
import com.ljb.utils.SHA256Util;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/18<br>
 * 描述: <br>
 */
@Service
public class UserImportServiceImpl implements UserImportService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public FileResult importByExcel(MultipartFile file) {
        FileResult fileResult=new FileResult();
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if (file.getSize() > Constant.EXCELSIZE) {
            fileResult.setMsg(FileResult.FileSizeError);
            return fileResult;
        }
        Workbook workbook = null;
        try {
            if (fileType.equals("xls")) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (fileType.equals("xlsx")) {
                workbook = new XSSFWorkbook(file.getInputStream());
            } else {
                fileResult.setMsg(FileResult.FileTypeError);
                return fileResult;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet=workbook.getSheetAt(0);
        List<SysUser> users=new ArrayList<>();
        List<SysUser> unRegisterUsers=new ArrayList<>();
        boolean isError=false;
        for(int i=sheet.getFirstRowNum()+1;i<sheet.getPhysicalNumberOfRows();i++){
            try {
                SysUser user = sysUserDao.findByNumber(transString(sheet.getRow(i).getCell(0)));
                if(user==null) {
                    try {
                        user=new SysUser();
                        user.setNumber(transString(sheet.getRow(i).getCell(0)));
                        user.setUsername(sheet.getRow(i).getCell(1).toString());
                        user.setPassword(SHA256Util.getSHA256Str(transString(sheet.getRow(i).getCell(2))));
                        user.setMobile(transString(sheet.getRow(i).getCell(3)));
                        user.setEmail(transString(sheet.getRow(i).getCell(4)));
                        user.setStatus(1);
                        user.setIsDelete(0);
                        user.setCreateId(IdentityUtils.getUserId());
                        user.setCreateTime(DateUtils.currentTime());
                        unRegisterUsers.add(user);
                    }catch (Exception e){

                    }
                }else{
                    users.add(user);
                }
            }catch (NullPointerException e){
                isError=true;
                break;
            }
        }
        if(isError) {
            fileResult.setMsg(FileResult.FileReadError);
            return fileResult;
        }
        if(unRegisterUsers.size()>0){
            sysUserDao.saveBatch(unRegisterUsers);
            users.addAll(unRegisterUsers);
            List<SysUserRole> userRoles = new ArrayList<>();
            SysRoleExample sysRoleExample=new SysRoleExample();
            sysRoleExample.createCriteria().andNameEqualTo(Constant.MEMBER_ROLE);
            List<SysRole> sysRoles= sysRoleDao.selectByExample(sysRoleExample);
            if(sysRoles.size()>0) {
                for (SysUser user : unRegisterUsers) {
                    SysUserRoleExample sysUserRoleExample=new SysUserRoleExample();
                    sysUserRoleExample.createCriteria().andRoleIdEqualTo(sysRoles.get(0).getId()).andUserIdEqualTo(user.getId());
                    if(sysUserRoleDao.selectByExample(sysUserRoleExample).size()<=0) {
                        SysUserRole sysUserRole = new SysUserRole();
                        if (SecurityUtils.getSubject().isAuthenticated()) {
                            sysUserRole.setCreateId(IdentityUtils.getUserId());
                        } else {
                            sysUserRole.setCreateId(user.getId());
                        }
                        sysUserRole.setUserId(user.getId());
                        sysUserRole.setRoleId(sysRoles.get(0).getId());
                        sysUserRole.setCreateTime(DateUtils.currentTime());
                        sysUserRole.setUpdateTime(DateUtils.currentTime());
                        userRoles.add(sysUserRole);
                    }
                }
            }
            if(userRoles.size()>0) {
                sysUserRoleDao.saveBatch(userRoles);
            }
        }
        fileResult.setMsg(FileResult.Success);
        fileResult.setList(users);
        return fileResult;
    }

    public String transString(Cell cell){
        String value;
        try {
            value=cell.toString();
            if(value.indexOf(".")>-1){
                DecimalFormat df = new DecimalFormat("#");//转换成整型
                value=df.format(cell.getNumericCellValue());
            }
        }catch (Exception e){
            value="空";
        }

        return value;
    }
}
