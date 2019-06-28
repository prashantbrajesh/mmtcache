package com.mmt.mmtCache.bo;

/**
 * Created by braj on 19/05/19.
 */
public class CacheObj {
    String key;
    String value;

    public CacheObj() {
    }

    public CacheObj(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
