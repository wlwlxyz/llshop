package com.wl.llshop.service.impl;

import com.wl.llshop.common.util.FtpUtils;
import com.wl.llshop.common.util.IDUtils;
import com.wl.llshop.common.util.PropKit;
import com.wl.llshop.service.FileService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/11/17
 * Time: 19:11
 * Version:V1.0
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public Map<String, Object> uploadImage(MultipartFile multipartFile) {
        Map<String, Object> map = new HashMap<String, Object>();
        //读取FTP配置文件信息
        String name = "ftp.properties";
        String host = PropKit.use(name).get("ftp.address");
        int port = PropKit.use(name).getInt("ftp.port");
        String username = PropKit.use(name).get("ftp.username");
        String password = PropKit.use(name).get("ftp.password");
        String basePath = PropKit.use(name).get("ftp.basePath");
        //创建文件路径：基础路径+文件路径+文件名+扩展名
        String filePath = new DateTime().toString("/yyyy/MM/dd");
        //获取原有的文件名，包含扩展名
        String originalFilename = multipartFile.getOriginalFilename();
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newName = IDUtils.genImageName() + fileType;
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //执行上传操作，返回布尔值
        boolean bool = FtpUtils.uploadFile(host, port, username, password, basePath, filePath, newName, inputStream);
        System.out.println( bool);
        System.out.println(host);
        System.out.println(port);
        System.out.println(username);
        System.out.println(password);
        System.out.println(basePath);
        System.out.println(filePath);
        System.out.println(newName);
        System.out.println(inputStream);
        if (bool) {
            map.put("state", "SUCCESS");
            map.put("title", newName);
            map.put("original", originalFilename);
            map.put("type", fileType);
            map.put("url",  filePath + "/" + newName);
            map.put("size", multipartFile.getSize());
        }
        return map;
    }



   /*     @Override
    public Map<String, Object> upload(MultipartFile upfile) {
        //读取ftp.properties信息
        String name="ftp.properties";
        String host = PropKit.use(name).get("ftp.address");
        int port = PropKit.use(name).getInt("ftp.port");
        String username = PropKit.use(name).get("ftp.username");
        String password = PropKit.use(name).get("ftp.password");
        String basePath = PropKit.use(name).get("ftp.basePath");
        String originalFilename = upfile.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String s = IDUtils.genImageName();
        String filename=s+substring;
        String filePath = new DateTime().toString("yyyy/MM/dd");
            InputStream inputStream = null;
            try {
                inputStream = upfile.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

        Map<String,Object> map=new HashMap<String,Object>();
        boolean b = FtpUtils.uploadFile(host, port, username, password, basePath, filePath, filename, inputStream);
        System.out.println("~~~~~~~~~~~~~~"+b);
        String s1 =filePath + "/" + filename;
        System.out.println(s1);
        System.out.println(filename);
        System.out.println(originalFilename);
        System.out.println(substring);
        System.out.println(upfile.getSize());
        if (b){
            map.clear();
            map.put("states","SUCCESS");
            map.put("title",filename);
            map.put("original",originalFilename);
            map.put("type",substring);
            map.put("url",s1);
            map.put("size",upfile.getSize());
        }
        return map;
    }*/
}
