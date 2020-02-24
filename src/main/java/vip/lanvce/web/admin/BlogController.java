package vip.lanvce.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vip.lanvce.po.Blog;
import vip.lanvce.po.User;
import vip.lanvce.service.BlogService;
import vip.lanvce.service.TagService;
import vip.lanvce.service.TypeService;
import vip.lanvce.util.Isfuhao;
import vip.lanvce.vo.BlogQuery;

import javax.servlet.http.HttpSession;


/**
 * @author: lanvce$
 * @date: 2020/2/22$ 下午3:14$
 * Description:
 **/
@Controller
@RequestMapping("/admin")
public class BlogController {

    private static  final String INPUT= "admin/blogs-input";
    private static  final String LIST= "admin/blogs";
    private static  final String REDIRECT_LIST= "redirect:/admin/blogs";


    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 10,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        Model model, BlogQuery blog){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listBlog(pageable,blog));

        return LIST;
    }

    //只刷新博客列表 不刷新上面内容
    @PostMapping("/blogs/search")
    public String blogsSearch(@PageableDefault(size = 2,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                              Model model, BlogQuery blog){
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "admin/blogs ::blogList";
    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("blog",new Blog());
        return INPUT;
    }

    //修改博客
    private  void setTypeAndTag(Model model){
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());
    }

    @GetMapping("/blogs/{id}/input")
    public String editinput(@PathVariable Long id,Model model){
        setTypeAndTag(model);
        Blog b = blogService.getBlog(id);
        b.init();
        model.addAttribute("blog",b);

        return INPUT;
    }

    //新增
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes,HttpSession session) {
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));
        Blog b ;

//        &&! blog.getContent().substring(0,80).equals(blog.getDescription())

        if (blog.getContent().length()>100){
             String content1=blog.getContent();
//             int i=Isfuhao.call(content1);
//            blog.setDescription(blog.getContent().substring(i+1,100));
           // blog.setDescription(blog.getContent().substring(0,100));

            int i=Isfuhao.call(content1);
            blog.setDescription(blog.getContent().substring(i,i+80));

        }










        if ("".equals(blog.getFirstPicture())){
            String url="lanvce.vip/images/yanlingji4.jpeg";
            blog.setFirstPicture(url);
        }

        if (blog.getId()==null){
            b=blogService.saveBlog(blog);
        }else {
            b=blogService.updateBlog(blog.getId(),blog);
        }


        if (b == null) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }

        return REDIRECT_LIST;

    }

    @GetMapping("blogs/{id}/delete")
    public String delete(@PathVariable Long id ,RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message", "删除成功！");

        return REDIRECT_LIST;
    }
}
