package com.wl.llshop.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/11/17
 * Time: 19:06
 * Version:V1.0
 */
public interface FileService {

    Map<String,Object> upload(MultipartFile upfile);
}
