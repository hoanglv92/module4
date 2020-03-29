package com.hoanglv.blog.model;
import javax.persistence.*;
@Entity
@Table(name = "bloguser")
public class BlogUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "bname")
    private String name;
    private String title;
    private String noidung;
    @Column(name = "btime")
    private String time;

    public BlogUser() {
    }
    public BlogUser(String name,String title, String noidung,String time){
        this.name=name;
        this.title=title;
        this.noidung=noidung;
        this.time=time;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
