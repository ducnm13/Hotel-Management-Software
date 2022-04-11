package com.team3.Model;
public class Model_NhanVien {
    private String maNV;
    private String matKhau;
    private String ho;
    private String ten;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private boolean gioiTinh;
    private String hinh;
    private int vaiTro;
    @Override
    public String toString() {
        return this.ten;
    }
    
    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public String getHo() {
        return ho;
    }
    public void setHo(String Ho) {
        this.ho = Ho;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String Ten) {
        this.ten = Ten;
    }
    public int getVaiTro() {
        return vaiTro;
    }
    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }
    public boolean getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String Email){
        this.email = Email;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String DiaChi) {
        this.diaChi = DiaChi;
    }
    public void setSDT(String SoDienThoai){
        this.soDienThoai = SoDienThoai;
    }
    public String getSDT() {
        return this.soDienThoai;
    }
    public String getHinh() {
        return this.hinh;
    }
    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
    public Model_NhanVien(String maNV, String matKhau, String ho, String ten, String email, String SDT, String diaChi, boolean gioiTinh, int vaitro, String hinh) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.ho = ho;
        this.ten = ten;
        this.vaiTro = vaitro;
        this.hinh = hinh;
    }  
    public Model_NhanVien() {
    }  
    
    
}
