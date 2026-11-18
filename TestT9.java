import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class TestT9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SachgiaokhoaT9> dsGiaoKhoa = new ArrayList<>();
        ArrayList<SachthamkhaoT9> dsThamKhao = new ArrayList<>();
        DateTimeFormatter dinhDang =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Nhap so luong sach giao khoa: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap sach giao khoa thu " + (i + 1));
            System.out.print("Ma sach: ");
            String maSach = sc.nextLine();
            System.out.print("Ngay nhap (dd/MM/yyyy): ");
            LocalDate ngayNhap =
                    LocalDate.parse(sc.nextLine(), dinhDang);
            System.out.print("Don gia: ");
            double donGia = Double.parseDouble(sc.nextLine());
            System.out.print("So luong: ");
            int soLuong = Integer.parseInt(sc.nextLine());
            System.out.print("Nha xuat ban: ");
            String nhaXuatBan = sc.nextLine();
            System.out.print("Tinh trang (moi/cu): ");
            String tinhTrang = sc.nextLine();
            SachgiaokhoaT9 sach = new SachgiaokhoaT9(
                    maSach, ngayNhap, donGia,
                    soLuong, nhaXuatBan, tinhTrang
            );
            dsGiaoKhoa.add(sach);
        }
        System.out.print("\nNhap so luong sach tham khao: ");
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            System.out.println("\nNhap sach tham khao thu " + (i + 1));
            System.out.print("Ma sach: ");
            String maSach = sc.nextLine();
            System.out.print("Ngay nhap (dd/MM/yyyy): ");
            LocalDate ngayNhap =
                    LocalDate.parse(sc.nextLine(), dinhDang);
            System.out.print("Don gia: ");
            double donGia = Double.parseDouble(sc.nextLine());
            System.out.print("So luong: ");
            int soLuong = Integer.parseInt(sc.nextLine());
            System.out.print("Nha xuat ban: ");
            String nhaXuatBan = sc.nextLine();
            System.out.print("Thue: ");
            double thue = Double.parseDouble(sc.nextLine());
            SachthamkhaoT9 sach = new SachthamkhaoT9(
                    maSach, ngayNhap, donGia,
                    soLuong, nhaXuatBan, thue
            );
            dsThamKhao.add(sach);
        }
        System.out.println("\n===== DANH SACH SACH GIAO KHOA =====");
        double tongGiaoKhoa = 0;
        for (int i = 0; i < dsGiaoKhoa.size(); i++) {
            System.out.println("\nSach giao khoa thu " + (i + 1));
            dsGiaoKhoa.get(i).hienThiThongTin();
            tongGiaoKhoa += dsGiaoKhoa.get(i).tinhThanhTien();
        }
        System.out.println("Tong thanh tien sach giao khoa: "
                + tongGiaoKhoa);
        System.out.println("\n===== DANH SACH SACH THAM KHAO =====");
        double tongThamKhao = 0;
        double tongDonGia = 0;
        for (int i = 0; i < dsThamKhao.size(); i++) {
            System.out.println("\nSach tham khao thu " + (i + 1));
            dsThamKhao.get(i).hienThiThongTin();
            tongThamKhao += dsThamKhao.get(i).tinhThanhTien();
            tongDonGia += dsThamKhao.get(i).getDonGia();
        }
        System.out.println("Tong thanh tien sach tham khao: "
                + tongThamKhao);
        if (dsThamKhao.size() > 0) {
            double trungBinh = tongDonGia / dsThamKhao.size();
            System.out.println("Trung binh cong don gia sach tham khao: "
                    + trungBinh);
        } else {
            System.out.println("Khong co sach tham khao!");
        }
        System.out.println("\n===== SACH GIAO KHOA CUA NHA XUAT BAN X =====");
        boolean timThay = false;
        for (int i = 0; i < dsGiaoKhoa.size(); i++) {
            if (dsGiaoKhoa.get(i).getNhaXuatBan()
                    .equalsIgnoreCase("X")) {
                dsGiaoKhoa.get(i).hienThiThongTin();
                System.out.println("-----------------------");
                timThay = true;
            }
        }
        if (timThay == false) {
            System.out.println("Khong tim thay sach cua nha xuat ban X!");
        }
        sc.close();
    }
}