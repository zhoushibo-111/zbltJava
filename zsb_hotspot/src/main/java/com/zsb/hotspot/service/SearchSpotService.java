package com.zsb.hotspot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zsb.hotspot.pojo.Searchspot;
import com.zsb.hotspot.dao.SearchSpotDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SearchSpotService {
    @Resource
    private SearchSpotDao searchSpotDao;


//    public void save(Searchspot searchspot){
//        searchSpotDao.save(searchspot);
//    }

//    public Page<Searchspot> findBytitleLike(String keywords, int page, int size){
//        Page<Searchspot> page1 = new Page<>(page,size);
//        List<Searchspot> list = searchSpotDao.findByTitleOrContentLike(keywords,keywords);
//        page1.setRecords(list);
//        return page1;
//    }
}
