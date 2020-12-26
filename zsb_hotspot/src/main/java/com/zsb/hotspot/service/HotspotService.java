package com.zsb.hotspot.service;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zsb.hotspot.dao.HotspotDao;
import com.zsb.hotspot.pojo.Hotspot;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class HotspotService {
    @Resource
    private HotspotDao hotspotDao;
    @Resource
    private IdWorker idWorker;
    @Resource
    private RedisTemplate<String, Hotspot> redisTemplate;

    public Page<Hotspot> findAll(Map map, int page, int size){
        EntityWrapper<Hotspot> wrapper = new EntityWrapper<>();
        Set<String> fieldSet = map.keySet();
        for(String field:fieldSet){
            wrapper.eq(null!=map.get(field),field,map.get(field));
        }
        Page<Hotspot> page1 = new Page<>(page,size);
        List<Hotspot> list = hotspotDao.selectPage(page1,wrapper);
        page1.setRecords(list);
        return page1;
    }
    public Hotspot findById(String id){
        Hotspot hotspot = redisTemplate.opsForValue().get("Hotspot_"+id);
        if (hotspot==null){
            hotspot = hotspotDao.selectById(id);
            redisTemplate.opsForValue().set("Hotspot_"+id,hotspot,2, TimeUnit.HOURS);
        }
            return hotspot;
    }
    public Integer add(Hotspot hotspot){
        hotspot.setId(idWorker.nextId()+"");
        hotspot.setVisits(0); //浏览量
        hotspot.setThumbup(0); //点赞数
        hotspot.setComment(0); //评论数
        Integer row = hotspotDao.insert(hotspot);
        return row;
    }
    public Integer update(Hotspot hotspot){
        redisTemplate.delete("Hotspot_"+hotspot.getId());
        EntityWrapper<Hotspot> wrapper = new EntityWrapper<>();
        wrapper.eq("id",hotspot.getId());
        Integer row = hotspotDao.update(hotspot, wrapper);
        return row;

    }
    public Integer delete(String id){
        redisTemplate.delete("Hotspot_"+id);
        Integer row = hotspotDao.deleteById(id);
        return row;
    }
}
