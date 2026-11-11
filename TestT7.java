import java.util.ArrayList;
public class TestT7 {
    public static void main(String[] args) {
        ArrayList<SachT7> danhSachSach = new ArrayList<>();
        SachT7 sach1 = new SachT7("S001", "Lap trinh Java",
                "Nguyen Van A", 2022, 10);
        SachT7 sach2 = new SachT7("S002", "Lap trinh C++",
                "Tran Van B", 2023, 15);
        SachT7 sach3 = new SachT7("S003", "Co so du lieu",
                "Le Van C", 2024, 20);
        danhSachSach.add(sach1);
        danhSachSach.add(sach2);
        danhSachSach.add(sach3);
        System.out.println("===== DANH SACH SACH =====");
        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.println("\nThong tin sach thu " + (i + 1));
            danhSachSach.get(i).hienThiThongTin();
        }
    }
}