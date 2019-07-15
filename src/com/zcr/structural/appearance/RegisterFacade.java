package com.zcr.structural.appearance;

/**
 * @author zcr
 * @date 2019/7/14-10:56
 */
public class RegisterFacade {

    public void register() {
        工商局 a = new 海淀区工商局();
        a.checkName();
        税务局 b= new 海淀区税务局();
        b.taxCertificate();
        银行 c = new 中国工商银行();
        c.openAccount();
    }
}
