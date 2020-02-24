package vip.lanvce.service;

import vip.lanvce.po.User;

/**
 * @author: lanvce$
 * @date: 2020/2/20$ 下午11:41$
 * Description:
 **/
public interface UserService {

    User checkUser(String username,String password);

}
