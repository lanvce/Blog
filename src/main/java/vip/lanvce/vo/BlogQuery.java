package vip.lanvce.vo;

/**
 * @author: lanvce$
 * @date: 2020/2/22$ 下午3:51$
 * Description:
 **///将博客查询页面要的参数封装到这来
public class BlogQuery {
    private  String title;
    private Long typeId;
    private boolean recommend;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public BlogQuery() {
    }
}
