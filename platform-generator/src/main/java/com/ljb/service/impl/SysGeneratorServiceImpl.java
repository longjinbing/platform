package com.ljb.service.impl;

import com.alibaba.fastjson.JSON;
import com.ljb.dao.TableDao;
import com.ljb.service.SysGeneratorService;
import com.ljb.utils.GenUtils;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysGeneratorServiceImpl implements SysGeneratorService {

	@Autowired
    private TableDao tableDao;

    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        return tableDao.queryList(map);
    }

    @Override
    public Long queryTotal(Map<String, Object> map) {
        return tableDao.queryTotal(map);
    }

    @Override
    public Map<String, Object> queryTable(String tableName) {
         return tableDao.queryTable(tableName);
    }

    @Override
    public List<Map<String, Object>> queryColumns(String tableName) {
        return tableDao.queryColumns(tableName);
    }

    @Override
    public byte[] generatorCode(Map<String, Object> map) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        String[] tableNames = new String[]{};
        tableNames = JSON.parseArray((String) map.get("tables")).toArray(tableNames);
        for (String tableName : tableNames) {
            //查询表信息
            Map<String, Object> table = queryTable(tableName);
            //查询列信息
            List<Map<String, Object>> columns = queryColumns(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns, zip,map);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

}
