package com.zsb.hotspot.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.zsb.hotspot.pojo.Hotspot;
import com.zsb.hotspot.service.HotspotService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/hotspot")
public class HotspotController {
    @Resource
    private HotspotService hotspotService;
    @ApiOperation("分页查询所有数据")
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public Result findAll(@RequestBody Map map, @PathVariable int page, @PathVariable int size){
        Page page1 = hotspotService.findAll(map,page,size);

        return new Result(true, StatusCode.OK,"查询成功", new PageResult(page1.getTotal(),page1.getRecords()));
    }
    @ApiOperation("根据ID查询数据")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findId(@PathVariable String id){
        Hotspot hotspot = hotspotService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",hotspot);
    }
    @ApiOperation("新增数据")
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Hotspot hotspot){
        Integer row = hotspotService.add(hotspot);
        return new Result(true,StatusCode.OK,"插入成功",row);
    }
    @ApiOperation("删除数据")
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable String id,@RequestBody Hotspot hotspot){
        hotspot.setId(id);
        Integer row = hotspotService.update(hotspot);
        return new Result(true,StatusCode.OK,"更新成功",row);
    }
    @ApiOperation("根据ID删除数据")
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        Integer row = hotspotService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功",row);
    }
    @ApiOperation("测试统一异常处理")
    @RequestMapping(value = "/exception",method = RequestMethod.GET)
    public Result exception() throws Exception{
        throw new Exception("测试统一异常处理");
    }

}
