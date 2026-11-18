import java.time.LocalDate;
public abstract class SachT9 {
    private String maSach;
    private LocalDate ngayNhap;
    private double donGia;
    private int soLuong;
    private String nhaXuatBan;
    public SachT9(String maSach, LocalDate ngayNhap, double donGia,
                  int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }
    public String getMaSach() {
        return maSach;
    }
    public LocalDate getNgayNhap() {
        return ngayNhap;
    }
    public double getDonGia() {
        return donGia;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
    public abstract double tinhThanhTien();
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Nha xuat ban: " + nhaXuatBan);
    }
}