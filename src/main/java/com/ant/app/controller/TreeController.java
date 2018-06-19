package com.ant.app.controller;

import com.ant.app.Constants;
import com.ant.app.entity.req.AppUserForRegist;
import com.ant.app.entity.resp.AppResult;
import com.ant.app.entity.tree.Tree;
import com.ant.app.entity.tree.TreeChild;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Api(value = "功能树",description = "功能树")
@RestController
@RequestMapping("/ant/manage/tree")
public class TreeController {

    @ApiOperation(value = "加载树", notes = "加载树",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/info",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Tree> regApp(HttpSession session){
        List tree=new ArrayList();
        List treechild1=new ArrayList();
        List treechild2=new ArrayList();
        List treechild3=new ArrayList();
        List treechild4=new ArrayList();
        List treechild5=new ArrayList();

        treechild1.add(new TreeChild(1,"平台管理员","icon-edit",true));

        treechild2.add(new TreeChild(2,"平台用户","icon-edit",true));

        treechild3.add(new TreeChild(4,"资讯信息","icon-edit",true));
        treechild3.add(new TreeChild(5,"音频管理","icon-edit",true));

        treechild4.add(new TreeChild(6,"账务报表","icon-edit",true));

        treechild5.add(new TreeChild(7,"用户开销","icon-edit",true));
        treechild5.add(new TreeChild(8,"平台支出","icon-edit",true));
        treechild5.add(new TreeChild(9,"订单明细","icon-edit",true));

        String role = (String)session.getAttribute(Constants.USER_TOLE);
        System.out.println("是否是超级管理员");
        if("admin".equals(role)){
            tree.add(new Tree(11,"超级管理员","icon-lock",treechild1));
            tree.add(new Tree(12,"用户管理","icon-large-clipart",treechild2));
            tree.add(new Tree(13,"资讯管理","icon-large-smartart",treechild3));
            tree.add(new Tree(14,"平台账务","icon-tip",treechild4));
            tree.add(new Tree(15,"统计结算","icon-man",treechild5));
        }else if("general".equals(role)){
            tree.add(new Tree(12,"用户管理","icon-large-clipart",treechild2));
            tree.add(new Tree(13,"资讯管理","icon-large-smartart",treechild3));
            tree.add(new Tree(14,"平台账务","icon-tip",treechild4));
            tree.add(new Tree(15,"统计结算","icon-man",treechild5));
        }else{
            tree.clear();
        }

        return tree;
    }

}
