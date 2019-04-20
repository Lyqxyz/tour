package com.tour.app.untils;


import com.tour.app.config.FileUploadException;
//import net.coobird.thumbnailator.Thumbnails;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Component
public final class FileUploadUtil {

    @Value("${file.uploadFolder}")
    private  String uploadFolder;

    @Value("${file.staticAccessPath}")
    private  String staticAccessPath;

    @Value("${file.types}")
    private List<String> types;

//    private String USERIMAGE="userImage";
//
//    private String GOODSIMAGE="goodsImage";
//
//    private String BOOKIMAGE="bookImage";

    private String imagePath;

//    private String videoPath;

//    private String staticVideoPath;

    private String staticImagePath;

    private String accessPath="/upload/";

    private long maxSize=1024*1024*300*10000; //500kb

    private long minSize=1;  //50kb

    /**
     * 校验类型
     * @param type
     * @return
     */
    public boolean checkType(String type){

        if ("".equals(type)||type==null){

            return false;
        }
        return this.types.contains(type);
    }

    /**
     * 校验大小 (kb)
     * @param size
     * @return
     */
    public boolean checkSize(long size){

        if(size>=minSize&&size<=maxSize){

            return true;
        }
        return false;
    }

    /**
     * 文件夹名(example image/20190103 /video)
     * @return
     * @throws IOException
     */
    public void createFilePath() throws IOException{

        String basePath=this.uploadFolder;

        DateTimeFormatter yyyYmmdd = DateTimeFormatter.ofPattern("YYYYMMdd");

        String format = yyyYmmdd.format(LocalDateTime.now());

        String imagePath = basePath+"/"+format+"/image";

//        String videoPath = basePath+"/"+format+"/video";

        File file = new File(imagePath);

        if(!file.exists()){

            FileUtils.forceMkdir(file);
        }

//        File file1= new File(videoPath);
//
//        if(!file1.exists()){
//
//            FileUtils.forceMkdir(file1);
//        }

        this.imagePath=imagePath;
//        this.videoPath=videoPath;
        this.staticImagePath=accessPath+format+"/image";
//        this.staticVideoPath=accessPath+format+"/video";

    }

    public String upload(MultipartFile file) throws IOException {

        if(file==null){

            throw new FileUploadException("图片上传失败");
        }
        if(file.isEmpty()){

            throw new FileUploadException("图片不能为空");
        }

        String contentType = file.getContentType();

        long size = file.getSize();

        boolean b = this.checkSize(size);

        boolean b1 = this.checkType(contentType);

        if(!b){
            throw new FileUploadException("图片超出大小");
        }

        if(!b1){

            throw new FileUploadException("图片格式不正确");
        }

        createFilePath();

        String s = uploadUserImage(file);

        return s;

    }

    public  List<List<String>> upload(MultipartFile[] multipartFiles) throws IOException{


        if (multipartFiles==null){

            throw  new FileUploadException("图片上传失败");
        }
        if(multipartFiles.length==0){

            throw  new FileUploadException("至少上传一张照片");
        }

        createFilePath();

        for (MultipartFile multipartFile : multipartFiles){

            String contentType = multipartFile.getContentType();

            long size = multipartFile.getSize();

            boolean b = this.checkSize(size);

            boolean b1 = this.checkType(contentType);

            if(!b){
                throw new FileUploadException("图片超出大小");
            }

            if(!b1){

                throw new FileUploadException("图片格式不正确");
            }

        }

        List<List<String>> paths = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles){

            List<String> strings = uploadGoodsImage(multipartFile);

            paths.add(strings);
        }

        return paths;

    }

    /**
     *
     * 电脑的地址 example E:\\uploadFiles\\20190107\\image\\userImage\
     *                          1546864496790269\\15468644967902695050.png
     *
     * 可访问的地址 /upload/20190107/image/userImage/1546864496790269/15468644967902695050.png
     * @param file
     * @return  /upload/20190107/image/userImage/1546864496790269/15468644967902695050.png
     * @throws IOException
     */

    public String uploadUserImage(MultipartFile file) throws IOException {

        String originalFilename = file.getOriginalFilename();

        String s = this.randomName();

        String suffix = this.getSuffix(originalFilename);

        //新的名字
        String newName =s+suffix ;

        //电脑磁盘位置
        String uploadPath = this.imagePath+"/"+s+"/";

        File file1 = new File(uploadPath);

        if(!file1.exists()){

            FileUtils.forceMkdir(file1);
        }

        //电脑磁盘上传地址
        String uploadFile= uploadPath+newName;

        File file2 = new File(uploadFile);

        //上传图片
        file.transferTo(file2);


        //图片处理后地址
        String size =uploadPath+s+"5050"+suffix;

        //图片处理
//        Thumbnails.of(file2).size(50,50).toFile(size);

        return this.staticImagePath+"/"+s+"/"+s+suffix;
    }

    public List<String> uploadGoodsImage(MultipartFile file)  throws IOException{


//        String t="";
//        if(GOODSIMAGE.equals(type)){
//
//            t=GOODSIMAGE;
//
//        }else if(BOOKIMAGE.equals(type)){
//
//            t=BOOKIMAGE;
//        }else {
//
//            throw new FileUploadException("上传失败");
//
//        }

        String originalFilename = file.getOriginalFilename();

        String s = this.randomName();

        String suffix = this.getSuffix(originalFilename);

        //新的名字
        String newName =s+suffix ;

        //电脑磁盘位置
        String uploadPath = this.imagePath+"/"+s+"/";

        File file1 = new File(uploadPath);

        if(!file1.exists()){

            FileUtils.forceMkdir(file1);
        }

        //电脑磁盘上传地址
        String uploadFile= uploadPath+newName;

        File file2 = new File(uploadFile);

        //上传图片
        file.transferTo(file2);
//
//        //图片处理后地址
//        String sizexm =uploadPath+s+"5050"+suffix;
//
//        String sizemd =uploadPath+s+"100200"+suffix;
//
//        String sizelg =uploadPath+s+"300500"+suffix;

//        //图片处理
//        Thumbnails.of(file2).size(50,50).toFile(sizexm);
//
//        Thumbnails.of(file2).size(100,200).toFile(sizemd);
//
//        Thumbnails.of(file2).size(300,500).toFile(sizelg);

            List<String> paths = new ArrayList<>();

          paths.add(this.staticImagePath+"/"+s+"/"+newName);
//        paths.add(this.staticImagePath+"/"+t+"/"+s+"/"+s+"5050"+suffix);
//        paths.add(this.staticImagePath+"/"+t+"/"+s+"/"+s+"100200"+suffix);
//        paths.add(this.staticImagePath+"/"+t+"/"+s+"/"+s+"300500"+suffix);

            return paths;

    }



    /**
     * 随机生成的名字
     * @return example 1546864496790269
     */
    public String randomName(){

        Instant now = Instant.now();

        long epochSecond = now.getEpochSecond();

        System.out.println(epochSecond);

        int v =(int) (Math.random() * 1000000);

        System.out.println(v);

        String name = epochSecond+""+v;

        return  name;

    }


    /**
     * 获取文件后缀
     * @param oName
     * @return .txt .png
     */
    public String getSuffix(String oName){

        int i = oName.lastIndexOf(".");

        String substring = oName.substring(i);

        return  substring;

    }


}
