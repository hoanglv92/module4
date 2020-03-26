package cg.wbd.grandemonstration.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Customer implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cname")
    private String name;
    @Column(name = "ccomment")
    private String comment;
    @Column(name = "clike")
    private long like;
    private int danhgia;
    @Column(name = "clocaltime")
    private String localtime;

    public Customer() {
    }

    public Customer(String name, String comment, String localtime) {
        this.name = name;
        this.comment = comment;
        this.localtime = localtime;
    }

    public Customer(Long id, String name, String comment, String localtime) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.localtime = localtime;
    }

    public long getLike() {
        return like;
    }

    public void setLike(long like) {
        this.like = like;
    }

    public int getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(int danhgia) {
        this.danhgia = danhgia;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String email) {
        this.comment = email;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String address) {
        this.localtime = address;
    }

    @Override
    public Customer clone() {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setComment(comment);
        customer.setLocaltime(localtime);
        return customer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + comment + '\'' +
                ", address='" + localtime + '\'' +
                '}';
    }
}
