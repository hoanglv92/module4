package com.thuvien.model.noentity;

import com.thuvien.model.Kindofbook;
import org.springframework.web.multipart.MultipartFile;


public class BookFrom {
    private Long id;
    private String name;
    private String motangan;
    private String motachitiet;
    private MultipartFile img;
    private String tinhtrang;
    private Long soluong;
    private String tacgia;
    private Long luotmuon;
    private String trangthai;
    private Kindofbook kindofbook;

    public BookFrom() {
    }

    public BookFrom(String name, String motangan, String motachitiet, MultipartFile img, String tinhtrang, Long soluong, String tacgia, String trangthai, Kindofbook kindofbook) {
        this.name = name;
        this.motangan = motangan;
        this.motachitiet = motachitiet;
        this.img = img;
        this.tinhtrang = tinhtrang;
        this.soluong = soluong;
        this.tacgia = tacgia;
        this.trangthai = trangthai;
        this.kindofbook = kindofbook;
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

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
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
