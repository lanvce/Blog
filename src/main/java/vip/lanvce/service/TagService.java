package vip.lanvce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vip.lanvce.po.Tag;

import java.util.List;

/**
 * @author: lanvce$
 * @date: 2020/2/22$ 上午1:01$
 * Description:
 **/
public interface TagService {
    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTagTop(Integer size);

     List<Tag> listTag(String ids);

    Tag updateTag(Long id,Tag tag);

    void deleteTag(Long id);
}
