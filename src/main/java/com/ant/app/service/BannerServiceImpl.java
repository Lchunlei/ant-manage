package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.BannerList;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.BannerMapper;
import com.ant.app.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/6
 */
@Service
public class BannerServiceImpl {

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
        int i = bannerMapper.deleteBanner(bannerId);
        if(i!=1){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }else {
            //删除指定静态文件

        }
    }

    public void addBanner(Banner banner,WebResult result){
        int i = bannerMapper.insertBanner(banner);
        if(i!=1){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }else {
            //增加指定静态文件

        }
    }

    public void getBannerList(BannerList bannerList,WebResult<List<Banner>> result){
        int startNum = (bannerList.getPageNum()-1)*bannerList.getPageSize();
        List<Banner> banners = bannerMapper.selectBypage(startNum,bannerList.getPageSize());
        if(banners.size()>0){
            result.setWebData(banners);
            result.setTotal(bannerMapper.selecttotallNum());
        }else {
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }
    }


}
