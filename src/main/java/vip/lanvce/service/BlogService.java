package vip.lanvce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vip.lanvce.po.Blog;
import vip.lanvce.vo.BlogQuery;

import java.util.List;
import java.util.Map;

/**
 * @author: lanvce$
 * @date: 2020/2/22$ 下午2:27$
 * Description:
 **/
public interface BlogService {
    Blog getBlog(Long id);

    //markdown转html要用到的方法
    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId,Pageable pageable);

    Page<Blog> listBlog(String query, Pageable pageable);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id ,Blog blog);

    void deleteBlog(Long id);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String,List<Blog>> archiveBlog();

    Long countBlog();

    List<String> listDescript(Pageable pageable);



}
