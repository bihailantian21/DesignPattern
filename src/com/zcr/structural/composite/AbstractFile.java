package com.zcr.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcr
 * @date 2019/7/14-9:33
 *
 * 使用组合模式，模拟杀毒软件架构设计
 * 文件夹怎么处理、视频软件、图片怎么处理
 */

//抽象组件
public interface AbstractFile {
    void killVirus();
}

//叶子组件 图像、视频、文本组件都是叶子节点
class ImageFile implements AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---图像文件：" + name + "，进来查杀！");
    }
}

class VideoFile implements AbstractFile {
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---视频文件：" + name + "，进来查杀！");
    }
}

class TextFile implements AbstractFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---文本文件：" + name + "，进来查杀！");
    }
}


//容器组件 文件夹是一个容器组件 这个容器就用来存子节点
class Folder implements AbstractFile {
    private String name;

    private List<AbstractFile> list = new ArrayList<AbstractFile>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        list.add(file);
    }

    public void remove(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile getChild(int index) {
        return list.get(index);
    }


    //这里有一个天然的递归：如果文件夹里面还有文件夹
    @Override
    public void killVirus() {
        System.out.println("---文件夹：" + name + "，进行查杀！");

        for (AbstractFile file : list) {
            file.killVirus();
        }
    }
}