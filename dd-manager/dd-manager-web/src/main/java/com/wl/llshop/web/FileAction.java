package com.wl.llshop.web;

import com.wl.llshop.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/11/17
 * Time: 15:32
 * Version:V1.0
 */
@Controller
public class FileAction {

    @Autowired
    private FileService fileService;

    @ResponseBody
    @RequestMapping(value="/file/upload",method = RequestMethod.GET)
    public void config(HttpServletRequest request,HttpServletResponse response)throws  Exception{
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
            String action = request.getParameter("action");
        if("config".equals(action)){
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.json");
            PrintWriter out = response.getWriter();
            IOUtils.copy(in,out,"UTF-8");
        }

    }

    @ResponseBody
    @RequestMapping(value="/file/upload",method = RequestMethod.POST)
    public Map<String,Object> upload( MultipartFile upfile){
        System.out.println(upfile.getName());
        return fileService.upload(upfile);
    }

}
