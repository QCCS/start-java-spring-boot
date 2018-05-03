package com.example.demo1.learn.file.io;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
public class FileOperationTest {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation();
        //获取文件路径
        String path = fileOperation.getThisFilderPath();
        //在指定目录创建文件夹
        fileOperation.ceateFilder("test", path);
        fileOperation.ceateFilder("test1", path + "/test");

        //创建文件
        fileOperation.ceateFile("test.md", path + "/test/test1");
        fileOperation.ceateFile("test1.md", path + "/test/test1");

        //删除文件
        //fileOperation.deleteFile("test.md",path+"/test/test1");
        //修改文件名
        //fileOperation.updateFile("test1.md",path+"/test/test1","testRename.md");
        //获取目录下所有文件名称
        String[] fileList = fileOperation.getFile("test1", path + "/test");
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
        //当前目录下所有文件名称
        String[] fileList1 = fileOperation.getFile("", path);
        for (String fileName : fileList1) {
            System.out.println(fileName);
        }

        //文件操作
        String filePath = path + "/test/test1/test1.md";
        String content = "这是文件内容1\n";
        String content2 = "这是文件内容2\n";
        String content3 = "这是文件内容3\n";
        //创建文件
        fileOperation.createFile(filePath);
        fileOperation.writeFile(filePath, content);
        fileOperation.writeFile(filePath, content2);
        fileOperation.writeFileByFileWriter(filePath, content3);
        String fileContent = fileOperation.readFile(filePath);
        System.out.println("-");
        System.out.println(fileContent);
    }
}
