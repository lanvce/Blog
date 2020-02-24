package vip.lanvce.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import vip.lanvce.po.Comment;

import java.util.List;

/**
 * @author: lanvce$
 * @date: 2020/2/22$ 下午2:02$
 * Description:
 **/
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);

}
