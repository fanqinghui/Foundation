package common.json;

import com.alibaba.fastjson.JSON;
import common.BasePo;

/**
 * <p>Created by: qingHui
 * <p>Date: 15-1-9 下午3:33
 * <p>Version: 1.0
 */
public class JsonUtils<T>{

    public static String formateObject(BasePo po) {
        String result = JSON.toJSONString(po);
        return result;
    }

    /*public static T parseObject(String str, Class<T> tClass){
      return JSON.parseObject(str,tClass);
    }*/
}
