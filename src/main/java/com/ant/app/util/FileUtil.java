package com.ant.app.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sfb_liuchunlei on 2017/10/19 0019.
 */
public class FileUtil {

    public static List<String> readTxt(String filePath){
        File file = new File(filePath);
        List<String> merInfos=new ArrayList();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String merInfo;
            while((merInfo = br.readLine())!=null){//使用readLine方法，一次读一行
                byte[] merInfoBytes=merInfo.getBytes("UTF-8");
                merInfos.add(new String(merInfoBytes));
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
            //throw new FileException("解析商户信息文件失败");
        }
        return merInfos;
    }

    public static void contentToTxt(String filePath,String content) throws IOException {
        File f = new File(filePath);
        if (f.exists()) {
            System.out.println("文件存在");
            f.delete();
        } else {
            System.out.println("文件不存在");
        }
        f.createNewFile();// 不存在则创建
        BufferedWriter output = new BufferedWriter(new FileWriter(f));
        output.write(content);
        output.close();
    }

    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        //创建目录
        if (dir.mkdirs()) {
            System.out.println("创建目录" + destDirName + "成功！");
            return true;
        } else {
            System.out.println("创建目录" + destDirName + "失败！");
            return false;
        }
    }

    //删除文件夹
//param folderPath 文件夹完整绝对路径

    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除指定文件夹下所有文件
//param path 文件夹完整绝对路径
    private static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }
}
