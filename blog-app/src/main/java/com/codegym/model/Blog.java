package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(length = 2000)
    private String content;
    private String title;
    private String time;


    public Blog() {

    }
    @Override
    public String toString() {
        return String.format("Blog[id=%d, name='%s'," +
                " content='%s' ,title='%s',time='%s']", id, name, content,title,time);
    }


    public  Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}