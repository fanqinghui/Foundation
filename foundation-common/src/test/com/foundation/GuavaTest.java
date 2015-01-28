package com.foundation;

import com.google.common.base.*;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Comparator;
import java.util.logging.Logger;

/**
 * Created by admin on 2015/1/27.
 */
public class GuavaTest {

    @Test
    public void testStr(){
        String str="good";
        String str2="";
        String strNull=null;
        //sring empty and null 相关
        pt(Strings.emptyToNull(str));

        pt(Strings.isNullOrEmpty(str2));
        pt(Strings.isNullOrEmpty(strNull));

        pt(Strings.nullToEmpty(strNull));
        pt(Strings.emptyToNull(strNull));
        pt(Strings.emptyToNull(str2));

        //相同的前缀or后缀
        pt(Strings.commonPrefix("abcdefg", "aabdadfa"));//a
        pt(Strings.commonSuffix("ccss","ddss"));//ss
        //填充
        pt(Strings.padStart("lxl", 6, '1'));//111lxl
        pt(Strings.padEnd("fqh",5,'2'));//fqh22
        pt(Strings.repeat("fqhlxl",2));//字符串重复
        pt(Strings.repeat("fqh",3));//字符串重复
        //字符串拆分与拼接
        pt( Joiner.on(",").skipNulls().join("fanqinghui", "lixiaolei", "yiwenxia", null, "dangwei", "zhaoxue", "weixiaojuan", "shigezhuang", "chenglihui", "other"));
        String spStr=",2,3,4,5,null,8,9,";
       pt(Splitter.on(",").trimResults().split(spStr));
       // Preconditions.checkArgument(false);
        Objects.equal("a", "a"); // returns true
        Objects.equal(null, "a"); // returns false
        Objects.equal("a", null); // returns false
        Objects.equal(null, null); // returns true
       pt( ComparisonChain.start().compare("1","1").compare("2","2").compare("t","s").result());
    }

    public void pt(Object obj){
        if(obj!=null) {
            Logger.getAnonymousLogger().info(obj.toString());
        }else{
            Logger.getAnonymousLogger().info("null");
        }
    }
}
