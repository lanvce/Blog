package vip.lanvce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.lanvce.po.User;

/**
 * @author: lanvce$
 * @date: 2020/2/20$ 下午11:44$
 * Description:
 **/
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);
}
