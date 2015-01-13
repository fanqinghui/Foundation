package com.foundation.util;

import com.foundation.dao.entry.sys.SysUser;
import common.json.JsonUtils;
import org.junit.Test;

/**
 * <p>Created by: qingHui
 * <p>Date: 15-1-11 下午10:10
 * <p>Version: 1.0
 */
public class JsonTest{

    @Test
    public void seriable(){
        SysUser user=new SysUser();
        user.setId(1L);
        user.setUserName("name");
        user.setEmail("afeifqh@12..com");
        user.setDisabled(1);
        String result=JsonUtils.formateObject(user);

    }
}
