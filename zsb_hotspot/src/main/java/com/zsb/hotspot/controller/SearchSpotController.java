package com.zsb.hotspot.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.zsb.hotspot.pojo.Searchspot;
import com.zsb.hotspot.service.SearchSpotService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/EShotword")
public class SearchSpotController {
    @Autowired
    private SearchSpotService searchSpotService;

//    @RequestMapping(method = RequestMethod.POST)
//    public Result save(@RequestBody Searchspot searchspot){
//        searchSpotService.save(searchspot);
//        return new Result(true, StatusCode.OK, "操作成功");
//    }
//    @RequestMapping(value = "/search/{keywords}/{page}/{size}",method = RequestMethod.GET)
//    public Result findByTitleLike(@PathVariable String keywords,
//                                  @PathVariable int page,@PathVariable int size){
//        Page<Searchspot> searchspotPage = searchSpotService.findBytitleLike(keywords, page, size);
//        return new Result(true, StatusCode.OK, "搜索成功",
//                new PageResult<Searchspot>(searchspotPage.getTotal(),searchspotPage.getRecords()));
//
//    }

}
