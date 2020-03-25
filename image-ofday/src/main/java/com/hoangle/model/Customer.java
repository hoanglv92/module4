package com.hoangle.model;

import javax.persistence.*;
import java.time.LocalTime;

@Table(name = "khachhang")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String comment;
    private long like;
    private int evaluete;
    private String localTime;


    public Customer() {
    }
    public Customer(String name ,String comment,String localTime){
        this.name=name;
        this.comment=comment;
        this.localTime=localTime;
    }

    public Customer(long id, long like, int evaluete,
                    String name ,String comment,String localTime) {
        this.id = id;
        this.name=name;
        this.comment=comment;
        this.like = like;
        this.evaluete = evaluete;
        this.localTime=localTime;
    }

    public void setComment(String comment){
        this.comment=comment;
    }
    public String getComment(){
        return comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLike() {
        return like;
    }

    public void setLike(long like) {
        this.like = like;
    }

    public int getEvaluete() {
        return evaluete;
    }

    public void setEvaluete(int evaluete) {
        this.evaluete = evaluete;
    }
    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }
}
