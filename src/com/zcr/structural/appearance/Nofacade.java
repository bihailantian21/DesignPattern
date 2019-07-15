package com.zcr.structural.appearance;

/**
 * @author zcr
 * @date 2019/7/14-10:46
 */
public class Nofacade {
}

interface 工商局 {
    void checkName();
}

class 海淀区工商局 implements 工商局 {

    @Override
    public void checkName() {
        System.out.println("在海淀工商局检查名字是否有冲突");
    }
}


interface 税务局 {
    void taxCertificate();
}

class 海淀区税务局 implements 税务局 {

    @Override
    public void taxCertificate() {
        System.out.println("在海淀税务局办理税务登记证");
    }
}



interface 银行 {
    void openAccount();
}

class 中国工商银行 implements 银行 {

    @Override
    public void openAccount() {
        System.out.println("在中国工商银行开户");
    }
}
