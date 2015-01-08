package com.foundation.Web.sys;

import com.foundation.Web.BaseController;
import com.foundation.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by joey on 15-1-7.
 */
@Controller
@RequestMapping(value = "/user/")
public class SysUserController extends BaseController {
    @Autowired(required = false)
    SysUserService sysUserService;

    @RequestMapping(value ="getUser",method = {RequestMethod.GET,RequestMethod.POST})
    public String getUser(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String id=request.getParameter("id");
        request.setAttribute("userName",sysUserService.queryById(Long.valueOf(id)).getUserName());
        return "hello";
    }

}
