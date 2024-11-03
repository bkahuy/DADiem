/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;

/**
 *
 * @author buikh
 */
public class Hocvien {
    private String mahv, hoten, lop;
    private int diem;

    public String getMahv() {
        return mahv;
    }

    public String getHoten() {
        return hoten;
    }

    public String getLop() {
        return lop;
    }

    public int getDiem() {
        return diem;
    }

    public void setMahv(String mahv) {
        this.mahv = mahv;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Hocvien(String mahv, String hoten, String lop, int diem) {
        this.mahv = mahv;
        this.hoten = hoten;
        this.lop = lop;
        this.diem = diem;
    }

    public Hocvien() {
        this.mahv = "";
        this.hoten = "";
        this.lop = "";
        this.diem = 0;
    }
    
    public String Ketqua(int diem){
        String kq = "";
        if(diem >= 25){
            kq = "dat";
        }
        else {
            kq = "khong dat";
        }
        return kq;
    }
    
}
