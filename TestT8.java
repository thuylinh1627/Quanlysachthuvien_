import java.util.ArrayList;
public class TestT8 {
    public static void main(String[] args) {
        ArrayList<SachT8> danhSachSach = new ArrayList<>();
        SachT8 sach1 = new SachT8("S001", "Lap trinh Java",
                "Nguyen Van A", 2022, 10);
        SachT8 sach2 = new SachT8("S002", "Lap trinh C++",
                "Tran Van B", 2023, 15);
        SachT8 sach3 = new SachT8("S003", "Co so du lieu",
                "Le Van C", 2024, 20);
        danhSachSach.add(sach1);
        danhSachSach.add(sach2);
        danhSachSach.add(sach3);
        sach1.setSoLuong(25);
        sach2.setNamXuatBan(2025);
        System.out.println("===== DANH SACH SACH =====");
        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.println("\nThong tin sach thu " + (i + 1));
            danhSachSach.get(i).hienThiThongTin();
        }
        System.out.println("\n===== KIEM TRA GETTER =====");
        System.out.println("Ma sach: " + sach1.getMaSach());
        System.out.println("Tieu de: " + sach1.getTieuDe());
        System.out.println("Tac gia: " + sach1.getTacGia());
        System.out.println("Nam xuat ban: " + sach1.getNamXuatBan());
        System.out.println("So luong: " + sach1.getSoLuong());
    }
}