package com.foundation;

import java.util.logging.Logger;

/**
 * <p>Created by: qingHui
 * <p>Date: 15-1-11 下午10:23
 * <p>Version: 1.0
 */
public class BaseTest {
    public void println(Object obj){
        Logger.getAnonymousLogger().info(obj.toString());
    }
}
