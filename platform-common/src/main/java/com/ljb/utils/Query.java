package com.ljb.utils;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询参数
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-14 23:15
 */
public class Query extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    //当前页码
    private Long offset;

    //每页条数
    private int limit;

    public Query(Map<String, Object> params) {
        //分页参数
        try {
            this.offset =Long.valueOf(params.getOrDefault("offset", 0).toString());
            this.limit =Integer.valueOf(params.getOrDefault("limit", 10).toString());
            String field = params.getOrDefault("field", "").toString();
            String search = params.getOrDefault("search", "").toString();
            String sort = params.getOrDefault("sort", "").toString();
            String order = params.getOrDefault("order", "").toString();
            String stime = params.getOrDefault("stime", "").toString();
            String etime = params.getOrDefault("etime", "").toString();
            this.put("offset", offset);
            this.put("limit", limit);
            if (search.length()>1) {
                this.put("field", field);
                this.put("search", search);
            }
            if (sort.length()>1) {
                this.put("sort", sort);
                this.put("order", order);
            }
            if (stime.length()>1 && etime.length()>1) {
                this.put("stime", stime);
                this.put("etime", etime);
            }
            if(params.containsKey("pid")){
                this.put("pid", params.get("pid"));
            }
        }catch (Exception e){
            throw e;
        }
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
