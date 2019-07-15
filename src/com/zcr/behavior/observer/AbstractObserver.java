package com.zcr.behavior.observer;

import javax.security.auth.Subject;

/**
 * @author zcr
 * @date 2019/7/14-22:03
 */
public interface AbstractObserver {

    void update(AbstractSubject subject);
}
