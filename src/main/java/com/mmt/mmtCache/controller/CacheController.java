package com.mmt.mmtCache.controller;

import com.mmt.mmtCache.bo.CacheObj;
import com.mmt.mmtCache.customExceptions.BadRequestException;
import com.mmt.mmtCache.customExceptions.KeyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by braj on 19/05/19.
 */
@Controller
public class CacheController {

    @Autowired
    @Qualifier("getMap")
    Map<String,String> getMap;


    @RequestMapping(path="/SET/{key}/{value}",method = RequestMethod.POST,produces = "application/json")
    public @ResponseBody CacheObj setValue(@PathVariable("key") String key,
                    @PathVariable("value") String value) {

        CacheObj co = new CacheObj();
        if(key!=null & value!=null){
             co = new CacheObj(key,value);
             getMap.put(key,value);

        }

        return co;
    }


    @RequestMapping(path="/GET/{key}",method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody String getValue(@PathVariable("key") String key) {


        if(getMap.containsKey(key)){

            return getMap.get(key);
        }else {
            throw new KeyNotFoundException();
        }

    }


    @RequestMapping(path="/SIZE",method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody int getSize() {


        if(getMap!=null){

           return getMap.size();
        }else {
            throw new KeyNotFoundException();
        }

    }


    @RequestMapping(path="/INCR/{key}",method = RequestMethod.POST,produces = "application/json")
    public @ResponseBody int inc(@PathVariable("key") String key) {


        synchronized (getMap) {
            if (getMap.containsKey(key)) {

                try {
                    int tmp = Integer.parseInt(getMap.get(key));
                    getMap.put(key, String.valueOf(tmp + 1));
                    return tmp + 1;
                } catch (NumberFormatException ex) {
                    throw new BadRequestException();
                }

            } else {
                throw new KeyNotFoundException();
            }

        }
    }


    @RequestMapping(path="/KEYS/{pattern}",method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody String getallKeysHavingPattern(@PathVariable("pattern") String pattern) {


        StringBuilder sb = new StringBuilder();
        if(getMap!=null){



            getMap.keySet().stream().filter(k-> Pattern.matches(pattern,k)).forEach(k->
                    sb.append(k+" ")

            );

        }else {
            throw new KeyNotFoundException();
        }

        return sb.toString();
    }






}
