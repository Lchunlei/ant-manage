package com.ant.app.controller;

import com.ant.app.Constants;
import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.model.Banner;
import com.ant.app.service.BannerServiceImpl;
import com.ant.app.systable.SysTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/6
 */
@RestController
@RequestMapping("/ant/banner")
public class BannerController {
    private static final Logger log = LoggerFactory.getLogger(BannerController.class);
    @Value("${banner.img.save.path}")
    private String filePath;
    @Value("${banner.img.web.url}")
    private String webUrl;

    @Autowired
    BannerServiceImpl bannerService;

    @RequestMapping(value = "/list",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public LayUiResult<Banner> getBnnerList(LayUiAuToReq layUiAuToReq){
        log.info("-----查看轮播图列表--------");
        layUiAuToReq.tableSet(SysTable.YSY_BABBER,SysTable.BANNER_ID,SysTable.CREAT_TIME,SysTable.TASK_TITAL,SysTable.BANNER_ID);
        LayUiResult<Banner> result = new LayUiResult();
        bannerService.getBannerList(layUiAuToReq,result);
        for(Banner b:result.getData()){
            b.setImgUrl(webUrl+b.getImgUrl());
        }
        log.info("查看轮播图列表--------》"+result);
        return result;
    }

    @RequestMapping(value = "/upFile",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public LayUiResult addBnner(@RequestParam MultipartFile file){
        LayUiResult result = new LayUiResult();
        log.info("-----增加轮播图--------");
        if (file.isEmpty()){
            result.setCode(Constants.PAGE_ERROR_CODE);
            result.setMsg(Constants.DATA_NULL);
            return result;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为：" + fileName);
        String format = fileName.split("\\.")[1];
        if("jpg".equalsIgnoreCase(format)||"png".equalsIgnoreCase(format)||"bmp".equalsIgnoreCase(format)){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            fileName = formatter.format(new Date());
            String fileRelPath = filePath +fileName+"."+format;
            log.info("上传的fileRelPath为：" + fileRelPath);
            File dest = new File(fileRelPath);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);//文件上传保存成功
            } catch (Exception e) {
                e.printStackTrace();
                result.setCode(Constants.PAGE_ERROR_CODE);
                result.setMsg(Constants.FILE_MSG);
            }
            result.setMsg(webUrl+fileName+"."+format);
        }else {
            result.setCode(Constants.PAGE_ERROR_CODE);
            result.setMsg(Constants.UP_FORMAT_ERR);
        }
        return result;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult addBnnert(Banner banner){
        WebResult result = new WebResult();
        log.info("增加轮播图--------"+banner);
        String[] ss = banner.getImgUrl().split("/");
        banner.setImgUrl(ss[ss.length-1]);//仅仅为文件名
        bannerService.addBanner(banner,result);
        return result;
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public WebResult delBnnert(Integer bannerId){
        WebResult result = new WebResult();
        log.info("删除轮播图--------"+bannerId);
        if(bannerId==null){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.PARAM_ERROR);
        }else {
            bannerService.deleBanner(bannerId,result);
        }
        return result;
    }


}
