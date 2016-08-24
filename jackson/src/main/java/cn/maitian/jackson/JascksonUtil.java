package cn.maitian.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by geng on 2016/8/3.
 */
public class JascksonUtil {
    static final ObjectMapper sMapper = new ObjectMapper();

    public static ObjectMapper initMapper() {
        // 防止：缺少json的某个字段属性引起UnrecognizedPropertyException
        sMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 解析器支持解析单引号
        sMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 解析器支持解析结束符
        sMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        return sMapper;
    }
}
