package com.zsb.hotspot.controller;

import com.zsb.hotspot.pojo.Comment;
import com.zsb.hotspot.service.CommentService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private RedisTemplate redisTemplate;
    @ApiOperation("查询全部")
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Comment> list = commentService.findAll();
        return new Result(true, StatusCode.OK,"查询全部成功",list);
    }
    @ApiOperation("根据id查询")
    @RequestMapping(value = "{commentId}",method = RequestMethod.GET)
    public Result findById(@PathVariable String commentId){
        Comment comment = commentService.findById(commentId);
        return new Result(true, StatusCode.OK,"根据id查询成功",comment);
    }
    @ApiOperation("新增")
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Comment comment){
        commentService.add(comment);
        return new Result(true, StatusCode.OK,"新增成功",comment);
    }
    @ApiOperation("修改")
    @RequestMapping(value="{id}",method=RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody Comment comment){
        comment.set_id(id);
        commentService.update(comment);
        return new Result(true, StatusCode.OK,"更新成功",comment);

    }
    @ApiOperation("删除")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {

        commentService.deleteById(id);

        return new Result(true, StatusCode.OK, "删除成功");

    }
    @ApiOperation("根据热题查评论")
    @RequestMapping(value = "{hotspotid}", method = RequestMethod.GET)
    public Result findByarticleId(@PathVariable String hotspotid) {

        List<Comment> list = commentService.findByhotspotId(hotspotid);

        return new Result(true, StatusCode.OK, "查询成功", list);

    }
    @ApiOperation("根据用户id查评论再根据发布时间排序")
    @GetMapping(value="special/{userid}")
    public Result findByUseridorderDate(@PathVariable String userid){
        List<Comment> list = commentService.findByUseridOrderDate(userid);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }
    @ApiOperation("根据评论的id点赞评论")
    @RequestMapping(value = "thumbup/{commentid}",method = RequestMethod.PUT)
    public Result updatethumbup(@PathVariable String commentid,@RequestParam(defaultValue = "123") String userid){
        //查询用户的点赞信息，userid和评论id
        Object flag = redisTemplate.opsForValue().get("thumbup_"+userid+"_"+commentid);
        if(flag==null){
            commentService.updatethumbup(commentid);

            redisTemplate.opsForValue().set("thumbup_"+userid+"_"+commentid,1);
            return new Result(true, StatusCode.OK, "点赞成功");
        }
        //为空点赞 不为空就不点赞
        return new Result(false, StatusCode.REPERROR, "不能重复点赞");
    }
}
