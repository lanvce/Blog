package vip.lanvce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import vip.lanvce.po.Type;

import java.util.List;

/**
 * @author: lanvce$
 * @date: 2020/2/21$ 下午9:24$
 * Description:
 **/

public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findByName(String name);


    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);

}
