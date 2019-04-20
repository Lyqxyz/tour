package com.tour.app.config;

/**
 *
 * 文件上传异常
 * @author lyq
 */
public class FileUploadException extends RuntimeException {

    public FileUploadException(String msg){
        super(msg);
    }
}
