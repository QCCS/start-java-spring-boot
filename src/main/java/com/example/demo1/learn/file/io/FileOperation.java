package com.example.demo1.learn.file.io;

import java.io.*;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
public class FileOperation {

    //获取当前目录的路径
    public String getThisFilderPath() {
        System.out.println(System.getProperty("user.dir"));
        return System.getProperty("user.dir");
    }

    //创建文件夹
    public void ceateFilder(String name, String path) {
        System.out.println("创建目录");
        File file = new File(path, name);
        boolean b1 = file.mkdir();
        if (b1) {
            System.out.println("创建目录success");
        } else {
            System.out.println("已有目录，创建目录failed");
        }
    }

    //创建文件
    public void ceateFile(String name, String path) {
        System.out.println("创建文件");
        File file = new File(path, name);
        try {
            boolean b3 = file.createNewFile();
            if (b3) {
                System.out.println("创建文件success");
            } else {
                System.out.println("创建文件failed");
            }
        } catch (Exception e) {
            System.out.println("创建文件error");
        }
    }

    //删除文件
    public void deleteFile(String name, String path) {
        File file = new File(path, name);
        boolean b = file.delete();
        if (b) {
            System.out.println("删除文件success");
        } else {
            System.out.println("删除文件failed");
        }
    }

    //修改文件名
    public void updateFile(String name, String path, String newName) {
        File file = new File(path, name);
        boolean b = file.renameTo(new File(path, newName));
        if (b) {
            System.out.println("修改文件名success");
        } else {
            System.out.println("修改文件名failed");
        }
    }
    //查询目录下所有文件
    public String[] getFile(String name, String path) {
        File file = new File(path, name);
        String[] s = file.list();
        return s;
    }



    //按行读取文件
    public static String readFile(String filePath) {
        File file = new File(filePath);
        BufferedReader reader = null;
        String tempString = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                System.out.println("输出文件内容");
                System.out.println(temp);
                tempString += temp;
                tempString += "\n";
            }
            reader.close();
            System.out.println("关闭文件流1");
            return tempString;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println("关闭文件流2");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return tempString;
    }

    //以追加方式写文件（BufferedWriter）
    public static void writeFile(String filePath, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true)));
            out.write(conent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    System.out.println("关闭文件流3");
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //创建文件
    public static void createFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("文件已存在");
        } else {
            try {
                File fileParent = file.getParentFile();
                if (fileParent != null) {
                    if (!fileParent.exists()) {
                        fileParent.mkdirs();
                    }
                }
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //以追加方式写文件（FileWriter），效率低
    public static void writeFileByFileWriter(String filePath, String content) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(filePath), true);
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    System.out.println("关闭文件流");
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    //复制文件
    public String copyFile(String name, String path) {
        String content = "";

        return content;
    }

    //移动文件
    public void moveFile(String name, String path) {

    }

}
