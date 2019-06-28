package com.xiazhe.controller.file;


import com.xiazhe.bean.file.FileResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@RequestMapping()
@Controller
public class FileUploadController {


    /**
     * @author: Draven
     * @date: 2019/6/28
     * @description: 文件上传, 包含接收到的图片等
     * @param: file 前端接收到的文件, uploadFile 前端接收的图片文件
     * @return: 返回一个文件上传信息的json数据
     */

    @RequestMapping("*/upload")
    @ResponseBody
    public FileResult fileUpload(MultipartFile file, MultipartFile uploadFile) throws IOException {
        FileResult fileResult = new FileResult();

        if (file != null) {
            String fileParentPath = "F:" + File.separator + "upload" + File.separator;
            File filePath = new File(fileParentPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            File upLoadFile = new File(fileParentPath, file.getOriginalFilename());
            file.transferTo(upLoadFile);
            fileResult.setUrl(fileParentPath + file.getOriginalFilename());
        } else {
            String fileParentPath = "F:" + File.separator + "upload" + File.separator + "pic" + File.separator;
            File filePath = new File(fileParentPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            File upLoadFile = new File(fileParentPath, uploadFile.getOriginalFilename());
            uploadFile.transferTo(upLoadFile);
            fileResult.setUrl(fileParentPath + uploadFile.getOriginalFilename());
        }
        fileResult.setError(0);
        return fileResult;
    }
}