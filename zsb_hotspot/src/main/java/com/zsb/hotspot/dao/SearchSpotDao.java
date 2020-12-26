package com.zsb.hotspot.dao;
import com.zsb.hotspot.pojo.Searchspot;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
public interface SearchSpotDao{}
//@Configuration
//public interface SearchSpotDao extends ElasticsearchRepository<Searchspot,String> {
//
//    List<Searchspot> findByTitleOrContentLike(String title, String content);
//}
