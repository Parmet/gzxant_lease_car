package com.gzxant.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.constant.Setting;
import com.gzxant.shiro.GzxantSysUser;
import com.gzxant.util.DateUtils;
import com.gzxant.util.FileUtils;
import com.gzxant.util.PathUtils;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping(value = "/file")
public class FileController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "查看上传的图片", notes = "查看上传的图片")
    @GetMapping(value = "/image")
    @ResponseBody
    public void getImageByPath(@RequestParam("path") String path,
    		HttpServletRequest request, HttpServletResponse response) throws IOException {
    	if (StringUtils.isEmpty(path)) {
    		return ;
    	}
    	
    	if (path.contains("|")) {
    		path = path.replace("|", File.separator);
    	}
    	
    	File file = new File(path);
    	
    	FileInputStream inputStream = new FileInputStream(file);
        byte[] data = new byte[(int)file.length()];
        int length = inputStream.read(data);
        inputStream.close();
        
        response.setContentType(getFileType(path));
        OutputStream stream = response.getOutputStream();
        
        stream.write(data);
        stream.flush();
        stream.close();
    }

    public String getUploadPath() {
		return null;
    }
    
    @ApiOperation(value = "后台删除文件", notes = "后台删除文件")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("name") String name) throws IOException {
        Boolean b = FileUtils.deleteFile(name);
        if (b) {
            return ReturnDTOUtil.success();
        } else {
            return ReturnDTOUtil.error();
        }
    }

    /**
     * 后台用户头像上传（图片）
     *
     * @param file     上传的文件
     * @param path     文件上传指定根目录下的目录
     * @param response
     * @param request
     * @throws IOException
     */
    @ApiOperation(value = "后台上传文件", notes = "后台上传文件")
    @PostMapping(value = "/upload/{type}")
    @ResponseBody
    public ReturnDTO uploadTransImg(@PathVariable("type") String type, @RequestParam("file") MultipartFile file,
                                    @RequestParam(value = "path", defaultValue = "") String path,
                                    HttpServletResponse response, HttpServletRequest request) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        List<Map<String, String> > rt=new ArrayList<>();

        rt.add( upload( type, path, file));

        return ReturnDTOUtil.success(rt);
    }

    private Map upload(String type, String path, MultipartFile file){
        String uuid = FileUtils.createFileName();//创建文件名称

        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();//扩展名

        String fileName = PathUtils.getUploadPath();
        if (StringUtils.isNotBlank(path)) {
        	fileName = fileName.replace("/", File.separator);
        	fileName = fileName.replace("\\", File.separator);
            fileName = fileName + File.separator + path;
        }
        
        String savePath = fileName + File.separator + type + File.separator + GzxantSysUser.id() + File.separator + uuid + "." + fileExt;//附件路径+类型（头像、附件等）+名称+扩展名
        File localFile = FileUtils.saveFileToDisk(file, savePath); //保存到磁盘

        String thumbnailName = "";
        if (FileUtils.getImageFormat(fileExt)) {
            //创建缩略图
            thumbnailName = fileName + File.separator + type + File.separator + GzxantSysUser.id() + File.separator + "s" + File.separator + uuid + "." + fileExt;//附件路径+类型（头像、附件等）+s(文件夹)+名称+扩展名
            FileUtils.createThumbnail(localFile, thumbnailName);
        }

        Map<String, String> rt = new HashMap<String, String>();

        rt.put("uuid", uuid);
        rt.put("path", Setting.BASEFLODER);
        rt.put("ext", fileExt);
        rt.put("url", savePath);
        rt.put("s_url", thumbnailName);
        rt.put("date", DateUtils.getCurDateTime());

        logger.info("上传的文件地址为 fileName={}", savePath);
        return rt;
    }

    private String getFileType(String filePath) {
    	Path path = Paths.get(filePath);  
        String contentType = null;  
        try {  
            contentType = Files.probeContentType(path);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        
        return contentType;
    }
    
}
