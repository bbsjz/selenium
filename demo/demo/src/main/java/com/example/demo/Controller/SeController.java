package com.example.demo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Api("硒施用户端")
@RestController
@RequestMapping("/selenium")
public class SeController {
    String url=ClassLoader.getSystemResource("")+"File";

    @ApiOperation("获取开屏大图，传入参数为图片id，共三张，分别为1，2，3")
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getSwiperPic(@PathVariable String id) throws IOException {
        File file=new File(url+"/"+id+".jpg");
        FileInputStream fileInputStream=new FileInputStream(file);
        byte[] bytes=new byte[fileInputStream.available()];
        fileInputStream.read(bytes,0,fileInputStream.available());
        final HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(bytes,headers, HttpStatus.OK);
    }

}
