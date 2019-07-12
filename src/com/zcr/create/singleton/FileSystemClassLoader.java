package com.zcr.create.singleton;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义文件系统加载器
 * @author zcr
 * @date 2019/7/12-20:01
 */
public class FileSystemClassLoader extends ClassLoader{

    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir =rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class<?> c = findLoadedClass(name);

        //应该要先查询有没有加载过这个类。如果已经加载则直接返回加载好的类，如果没有，则加载新的类
        if (c != null) {
            return c;
        } else {
            byte[] classData = getClassData(name);
            if (classData == null) {
                throw new ClassNotFoundException();
            } else {
                c = defineClass(name,classData,0,classData.length);
            }
        }
        return c;
    }

    private byte[] getClassData(String classname) {
        String path = rootDir + "/" + classname.replace('.','/')+".class";
        //将流中的数据转成字节数组
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            is = new FileInputStream(path);

            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp = is.read(buffer)) != -1) {
                baos.write(buffer,0,temp);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }
}
