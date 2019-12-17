/** 
 * @file: ClearCollection.java 
 * @Package： com.ywjs.common.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月15日 上午10:45:49 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ClearCollection
 * @Description TODO(清空容器的工具) 
 * @Author 周伟
 * @Date 2019年11月15日 上午10:45:49
 */
public class ClearCollectionUtil {
    
    
    public static void clear(Map map1,Map map2 ,List list){
        map1.clear();
        map2.clear();
        list.clear();
    }
    
    public static void clearList(List ... list){
        for (int i = 0; i < list.length; i++) {
            if(list[i] != null){
                list[i].clear();
            }
        }
    }
    
    /**
     * 
     * @Description: TODO(批量置空map) 
     * @author： 2019年11月15日  周伟  创建初始版本
     * @param map
     */
    public static void clearMap(Map ... map){
        for (int i = 0; i < map.length; i++) {
            if(map[i] != null){
                map[i].clear();
            }
        }
    }
    
    
    public static void main(String[] args) {
        Map<String,String> map1 = new HashMap<>();
        map1.put("1", "1");
        Map<String,String> map2 = new HashMap<>();
        map2.put("2", "2");
        ArrayList<String> list = new ArrayList<>();
        list.add("list");
        System.out.println(map2);
        list.add("1");
        ClearCollectionUtil.clear(map1,map2,list);
        ClearCollectionUtil.clearMap(map1,map2);
        System.out.println(map2+"========");
    }

}
