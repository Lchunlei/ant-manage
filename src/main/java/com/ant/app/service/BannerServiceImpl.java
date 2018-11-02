package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.BannerList;
import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.BannerMapper;
import com.ant.app.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/6
 */
@Service
public class BannerServiceImpl {
    @Value("${banner.img.save.path}")
    private String filePath;

    @Autowired
    BannerMapper bannerMapper;

    public void updaBanner(Banner banner,WebResult result){
        int i = bannerMapper.updateBanner(banner);
        if(i!=1){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }
    }

    public void deleBanner(Integer bannerId,WebResult result){
        Banner banner = bannerMapper.selectById(bannerId);
        if(banner==null){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.DATA_NULL);
        }else {
            int i = bannerMapper.deleteBanner(bannerId);
            if(i!=1){
                result.setCode(Constants.ERROR_CODE);
                result.setMessage(Constants.FILE_MSG);
            }else {
                //删除指定静态文件
                File file=new File(filePath+banner.getImgUrl());
                if(file.exists()&&file.isFile())
                    file.delete();
            }
        }
    }

    public void addBanner(Banner banner,WebResult result){
        int i = bannerMapper.insertBanner(banner);
        if(i!=1){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }
    }

    public void getBannerList(LayUiAuToReq layUiAuToReq, LayUiResult<Banner> result){
        layUiAuToReq.setStartNum((layUiAuToReq.getPage()-1)*10);
        Integer totallNumAll = bannerMapper.selectTotallNum(layUiAuToReq);
        if(totallNumAll>0){
            result.setData(bannerMapper.selectByPage(layUiAuToReq));
            result.setCount(totallNumAll);
            result.setMsg(Constants.SUCCESS_MSG);
            result.setCode(Constants.PAGE_OK_CODE);
        }else{
            result.setMsg(Constants.NOT_MORE_INFO);
            result.setCode(Constants.PAGE_ERROR_CODE);
        }
    }


}
