package vip.lanvce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.lanvce.dao.UserRepository;
import vip.lanvce.po.User;

/**
 * @author: lanvce$
 * @date: 2020/2/20$ 下午11:43$
 * Description:
 **/
@Service
public class UserServiceimpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    //检查用户名密码是否正确
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }
}
