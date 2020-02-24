package vip.lanvce.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: lanvce$
 * @date: 2020/2/18$ 下午6:50$
 * Description:
 **/
@Entity()
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private  String email;
    private String avatat;//头象
    private Integer type;//

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs=new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatat='" + avatat + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatat() {
        return avatat;
    }

    public void setAvatat(String avatat) {
        this.avatat = avatat;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public User() {
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
}
