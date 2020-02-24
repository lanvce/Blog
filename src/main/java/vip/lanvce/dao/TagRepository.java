package vip.lanvce.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vip.lanvce.po.Tag;
import vip.lanvce.po.Type;

import java.util.List;

/**
 * @author: lanvce$
 * @date: 2020/2/22$ 上午1:00$
 * Description:
 **/
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);

}
