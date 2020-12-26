package com.zsb.hotspot.repository;

import com.zsb.hotspot.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByHotspotid(String hotspotId);
    //根据发布时间和点赞数
    List<Comment> findByPublishdateAndThumbup(Date date, Integer thumbup);

    //根据用户id查询 根据发布时间排序
    List<Comment> findByUseridOrderByPublishdateDesc(String userid);


}
