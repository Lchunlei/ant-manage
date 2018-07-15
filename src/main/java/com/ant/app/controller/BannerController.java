package com.ant.app.controller;

import com.ant.app.entity.req.BannerList;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.model.Banner;
import com.ant.app.service.BannerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/6
 */
@Api(value = "轮播图",description = "轮播图")
@RestController
@RequestMapping("/page/ant/banner")
public class BannerController {
    private static final Logger log = LoggerFactory.getLogger(BannerController.class);
    @Autowired
    BannerServiceImpl bannerService;

    @ApiOperation(value = "查看轮播图列表", notes = "查看轮播图列表",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/list",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult getBnnerList(@RequestBody BannerList bannerList){
        if(bannerList.getPageNum()==null||bannerList.getPageNum()==0){
            bannerList.setPageNum(1);
            bannerList.setPageSize(10);
        }
        WebResult<List<Banner>> result = new WebResult();
        log.info("查看轮播图列表--------》"+bannerList);
        bannerService.getBannerList(bannerList,result);
        log.info("--------》"+result);
        return result;
    }



}
