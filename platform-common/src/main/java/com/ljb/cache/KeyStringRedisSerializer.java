package com.ljb.cache;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;

import java.nio.charset.Charset;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/13<br>
 * 描述: <br>
 */
public class KeyStringRedisSerializer implements RedisSerializer<Object> {
    private final Charset charset;
    private final String target = "\"";
    private final String replacement = "";

    public KeyStringRedisSerializer() {
        this(Charset.forName("UTF8"));
    }

    public KeyStringRedisSerializer(Charset charset) {
        Assert.notNull(charset);
        this.charset = charset;
    }

    public String deserialize(byte[] bytes) {
        return bytes == null ? null : new String(bytes, this.charset);
    }

    @Override
    public byte[] serialize(Object object) {
        String string = JSON.toJSONString(object);
        if (string == null) {
            return null;
        }
        string = string.replace(target, replacement);
        return string.getBytes(charset);
    }


}
