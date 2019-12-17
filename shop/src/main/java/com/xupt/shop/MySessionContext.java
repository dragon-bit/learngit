package com.xupt.shop;
import java.util.HashMap;
import java.util.Map;



public class MySessionContext {
    private static MySessionContext mySessionContext=new MySessionContext();
    private static Map<String, Cache> cacheMap ;
    public MySessionContext  MySessionContext(){
        cacheMap= new HashMap<String, Cache>();
        return mySessionContext;
    }
    /**
     * @methodDesc: 功能描述:(往缓存存值)
     */
    public void put(String key, Object oj) {
        put(key, oj, null);
    }
    /**
     * @methodDesc: 功能描述:(往缓存存值)
     */
    public synchronized void put(String key, Object oj, Long timeOut) {
        if (oj == null) {
            return;
        }
        Cache cache = new Cache();
        cache.setKey(key);
        if (timeOut != null)
            cache.setTimeOut(timeOut + System.currentTimeMillis());
        cache.setValue(oj);
        cacheMap.put(key, cache);
    }
    /**
     * @methodDesc: 功能描述:(删除)
     */
    public synchronized void deleteCache(String key) {
        cacheMap.remove(key);
    }
    /**
     * @methodDesc: 功能描述:(获取缓存中数据)
     */
    public synchronized Object get(String key) {
        Cache cache = cacheMap.get(key);
        Object oj = null;
        if (cache != null) {
            oj = cache.getValue();
        }
        return oj;
    }
    /**
     * @methodDesc: 功能描述:(检查数据是否在有效期内)
     */
    public synchronized void checkValidityData() {
        for (String key : cacheMap.keySet()) {
            Cache cache = cacheMap.get(key);
            Long timeOut = cache.getTimeOut();
            if (timeOut == null) {
                return;
            }
            long currentTime = System.currentTimeMillis();
            long endTime = timeOut;
            long result = (currentTime - endTime);
            if (result > 0) {
                System.out.println("清除:"+key);
                cacheMap.remove(key);
            }
        }
    }

}
