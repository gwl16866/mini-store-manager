package com.hy.ministoremanager.controller.upload;



import com.hy.ministoremanager.bean.ResUpload;
import com.hy.ministoremanager.service.upload.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author licheng
 * @date 2020/6/11 21:42
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadImage")
    public ResUpload uploadImage(MultipartFile file){
        String url = uploadService.uploadImage(file);
        return new ResUpload("上传成功",url);
    }
}
