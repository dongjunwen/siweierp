package com.fangxin.siwei.fangzhi.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Date:2017/11/15 0015 16:49
 * @Author lu.dong
 * @Description：
 **/
public class FileUtil {
    public static void saveFile(String savePath,InputStream importFile){

        byte[] data=new byte[1024];
        int len=0;

        FileOutputStream fileOutputStream=null;
        try {

            fileOutputStream=new FileOutputStream(savePath);
            while((len=importFile.read(data))!=-1){
                fileOutputStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (importFile!=null) {
                try {
                    importFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void delFile(String saveFileName) {
        File f=new File(saveFileName);
        if (f.exists() ) f.delete();
    }
}

