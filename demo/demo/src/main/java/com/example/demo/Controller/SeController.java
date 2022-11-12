package com.example.demo.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/selenium")
public class SeController {
    String url=ClassLoader.getSystemResource("")+"File";

    @RequestMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    @GetMapping("/{id}")
    public byte[] getSwiperPic(@PathVariable String id) throws IOException {
        File file=new File(url+"/"+id);
        FileInputStream fileInputStream=new FileInputStream(file);
        byte[] bytes=new byte[fileInputStream.available()];
        fileInputStream.read(bytes,0,fileInputStream.available());
        return bytes;
    }

}
