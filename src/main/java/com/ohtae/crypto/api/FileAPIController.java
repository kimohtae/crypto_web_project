package com.ohtae.crypto.api;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileAPIController {
    @Value("${spring.servlet.multipart.location}") String path;    

    @PostMapping("/image/{type}")
    public Map<String, Object> postUserImageUpload(@PathVariable String type, @RequestPart MultipartFile file){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String[] splitFileName = fileName.split("\\.");
        String ext = splitFileName[splitFileName.length-1];
        if(
            !ext.equalsIgnoreCase("jpg") &&
            !ext.equalsIgnoreCase("jpeg") &&
            !ext.equalsIgnoreCase("png") &&
            !ext.equalsIgnoreCase("gif")
        ){
            resultMap.put("status", false);
            resultMap.put("message", "프로필 사진은 jpg,jpeg,png,gif 형식만 등록 가능합니다.");
            return resultMap;
        }

        Path folderLocation = Paths.get(path+"/"+type);
        String saveFileName = Calendar.getInstance().getTimeInMillis()+"."+ext;
        Path target = folderLocation.resolve(saveFileName);

        try{
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            resultMap.put("status", false);
            resultMap.put("message", e.getMessage());
            return resultMap;
        }

        resultMap.put("status", true);
        resultMap.put("message", "파일 업로드 완료");
        resultMap.put("image", saveFileName);

        return resultMap;
    }
}
