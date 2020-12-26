package com.zsb.hotspot.service;

import com.zsb.hotspot.pojo.Comment;
import com.zsb.hotspot.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Comment> findAll(){
        List<Comment> list = commentRepository.findAll();
        return list;
    }

    public Comment findById(String commentid) {
        Optional<Comment> opt = commentRepository.findById(commentid);
        if(opt.isPresent()){
            return opt.get();
        }
        return null;

    }
    public void add(Comment comment){
        String id = idWorker.nextId()+"";
        comment.set_id(id);
        //初始化数据
        comment.setPublishdate(new Date());
        comment.setThumbup(0);
        commentRepository.save(comment);
    }
    public void update(Comment comment){
        commentRepository.save(comment);
    }
    public void deleteById(String id){
        commentRepository.deleteById(id);
    }
    public List<Comment> findByhotspotId(String hotspotId){
        return commentRepository.findByHotspotid(hotspotId);
    }
    public List<Comment> findByUseridOrderDate(String userid){
        return commentRepository.findByUseridOrderByPublishdateDesc(userid);
    }
    public void updatethumbup(String commentid){
        //用分布式锁 redis 或者 zk 解决 再说
        //使用mongo模板 直接操作
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(commentid));
        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"comment");
    }
    public void cancelthumbup(String commentid){
        //使用mongo模板 直接操作
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(commentid));
        Update update = new Update();
        update.inc("thumbup",-1);
        mongoTemplate.updateFirst(query,update,"comment");
    }
}
