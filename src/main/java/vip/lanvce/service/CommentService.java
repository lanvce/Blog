package vip.lanvce.service;

import vip.lanvce.po.Comment;

import java.util.List;

/**
 * @author: lanvce$
 * @date: 2020/2/22$ 下午2:06$
 * Description:
 **/
public interface CommentService  {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);


}
