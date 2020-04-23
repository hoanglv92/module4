package com.thuvien.model;



import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String motangan;
    @Column(length = 3000)
    private String motachitiet;
    private String img;
    private String tinhtrang;
    private Long soluong;
    private String tacgia;
    private Long luotmuon;
    private String trangthai;
    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "kindofbook_id")
    private Kindofbook kindofbook;

    public Book() {
    }

    public Book(Long id, String name, String motangan, String motachitiet, String img, String tinhtrang, Long soluong, String tacgia, Long luotmuon, String trangthai, Kindofbook kindofbook) {
        this.id = id;
        this.name = name;
        this.motangan = motangan;
        this.motachitiet = motachitiet;
        this.img = img;
        this.tinhtrang = tinhtrang;
        this.soluong = soluong;
        this.tacgia = tacgia;
        this.luotmuon = luotmuon;
        this.trangthai = trangthai;
        this.kindofbook = kindofbook;
    }

    public Book(String name, String motangan, String motachitiet, String img, String tinhtrang, Long soluong, String tacgia, Long luotmuon, String trangthai, Kindofbook kindofbook) {
        this.name = name;
        this.motangan = motangan;
        this.motachitiet = motachitiet;
        this.img = img;
        this.tinhtrang = tinhtrang;
        this.soluong = soluong;
        this.tacgia = tacgia;
        this.luotmuon = luotmuon;
        this.trangthai = trangthai;
        this.kindofbook = kindofbook;
    }
    public Book(Long id,String trangthai,String name, String motangan, String motachitiet, String img, String tinhtrang, Long soluong, String tacgia, Kindofbook kindofbook) {
        this.id=id;
        this.name = name;
        this.motangan = motangan;
        this.motachitiet = motachitiet;
        this.img = img;
        this.tinhtrang = tinhtrang;
        this.soluong = soluong;
        this.tacgia = tacgia;
        this.kindofbook = kindofbook;
        this.trangthai=trangthai;
    }

    public Book(String trangthai,String name, String motangan, String motachitiet, String img, String tinhtrang, Long soluong, String tacgia, Kindofbook kindofbook) {
        this.name = name;
        this.motangan = motangan;
        this.motachitiet = motachitiet;
        this.img = img;
        this.tinhtrang = tinhtrang;
        this.soluong = soluong;
        this.tacgia = tacgia;
        this.kindofbook = kindofbook;
        this.trangthai=trangthai;
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

    public String getMotangan() {
        return motangan;
    }

    public void setMotangan(String motangan) {
        this.motangan = motangan;
    }

    public String getMotachitiet() {
        return motachitiet;
    }

    public void setMotachitiet(String motachitiet) {
        this.motachitiet = motachitiet;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public Long getSoluong() {
        return soluong;
    }

    public void setSoluong(Long soluong) {
        this.soluong = soluong;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public Long getLuotmuon() {
        return luotmuon;
    }

    public void setLuotmuon(Long luotmuon) {
        this.luotmuon = luotmuon;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }



    public Kindofbook getKindofbook() {
        return kindofbook;
    }

    public void setKindofbook(Kindofbook kindofbook) {
        this.kindofbook = kindofbook;
    }
}
