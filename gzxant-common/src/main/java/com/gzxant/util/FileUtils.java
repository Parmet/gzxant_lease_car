package com.gzxant.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Created by chen on 2017/9/26.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:  文件工具
 */
public class FileUtils {

    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);
    
    /**
     * 获取附件名称 13位时间戳+5位随机数
     *
     * @return
     */
    public static String createFileName() {
        return System.currentTimeMillis() + "" + (int) (Math.random() * 100000);
    }


    /**
     * 判断文件的扩展名
     *
     * @param suffix
     * @return
     */
    public static Boolean getImageFormat(String suffix) {
        return "TFF".equalsIgnoreCase(suffix) || "TIFF".equalsIgnoreCase(suffix) || "PNG".equalsIgnoreCase(suffix) || "GIF".equalsIgnoreCase(suffix) || "JPG".equalsIgnoreCase(suffix) || "JPEG".equalsIgnoreCase(suffix);
    }


    /**
     * 保存文件到磁盘
     *
     * @param file
     * @param savePath
     */
    public static File saveFileToDisk(MultipartFile file, String savePath) {
        File localFile = new File(savePath);
        if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
        }
        try {
            Files.copy(file.getInputStream(), Paths.get(savePath));
            return localFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存文件到磁盘
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void saveFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 删除文件
     * @param fileName
     * @return
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                logger.error("删除单个文件-> {}成功！",fileName);
                return true;
            } else {
                logger.error("删除单个文件-> {}失败！",fileName);
                return false;
            }
        } else {
            logger.info("删除单个文件失败-> {}不存在！",fileName);
            return false;
        }
    }

    /**
     * 生成缩略图
     * @param localFile
     * @param savePath
     * @return
     */
    public static Boolean createThumbnail(File localFile, String savePath) {

        File thumbnailFile = new File(savePath);
        if (!thumbnailFile.getParentFile().exists()) {
            thumbnailFile.getParentFile().mkdirs();
        }

        //生成缩略图
        if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
        }

        try {

            Thumbnails.of(localFile).size(256, 256).outputQuality(1.0f).toFile(savePath.toString());
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
	 * 
	 * @param al
	 * @param file
	 */
	public static void writeContent2Txt(List<String> al, String file) {
		File f = new File(file);
        BufferedWriter bw = null;
        
		try {
			bw = new BufferedWriter(new FileWriter(f));
	        for (int i = 0 ; i < al.size() ; i++) {
				bw.write(al.get(i));
				bw.newLine();
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * 通过响应输出流实现文件下载
     *
     * @param response     响应的请求
     * @param fileLocal    文件的绝对路径 请用/斜杠表示路径
     * @param downloadName 自定义的文件名 ( 不要后缀),如果此值为空则使用时间日期做为默认的文件名
     * @param deleFile     下载完成后是否删除文件（true: 删除 , false：不删除）
     */
    public static void downLoadFile(HttpServletResponse response, String fileLocal, String downloadName, boolean deleFile){
        InputStream in=null;
        OutputStream out=null;
        try{
            if(!"".equals(downloadName)){
                downloadName=downloadName+fileLocal.substring(fileLocal.lastIndexOf("."));
            }else{
                downloadName=fileLocal.substring(fileLocal.lastIndexOf("/")+1);
            }
            
            response.setHeader("content-disposition","attachment;filename=" + new String(downloadName.getBytes("gbk"),"iso-8859-1"));//URLEncoder.encode(downloadName, "UTF-8")
            response.setCharacterEncoding("UTF-8"); 
            in=new FileInputStream(fileLocal);
            int len=0;
            byte buffer[]=new byte[1024];
            out=response.getOutputStream();
            while((len=in.read(buffer))>0){
                out.write(buffer,0,len);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(in!=null){
                try{
                    //
                    in.close();
                    if(deleFile){
                        Thread.sleep(1000L);
                        File file=new File(fileLocal);
                        file.delete();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

	public static List<File> getFiles(String path) {
		return getFiles(path, "");
	}
	
	public static List<File> getFiles(String path, String suffix) {
		// 目标集合fileList
		List<File> fileList = new ArrayList<File>();
		File file = new File(path);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File fileIndex : files) {
				// 如果这个文件是目录，则进行递归搜索
				if (fileIndex.isDirectory()) {
					getFiles(fileIndex.getPath());
				} else {
					// 如果文件是普通文件，则将文件句柄放入集合中
					if (StringUtils.isNotBlank(suffix) 
						&& fileIndex.getName().endsWith(suffix)) {
						fileList.add(fileIndex);
					} else {
						fileList.add(fileIndex);
					}
				}
			}
		}
		return fileList;
	}

	public static List<String> readFileTxt(File file) {
		if(file == null || !file.exists()){
			return new ArrayList<>();
		}
		
		List<String> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine()) != null){//使用readLine方法，一次读一行
            	list.add(s);
            }
            
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        
		return list;
	}
}
