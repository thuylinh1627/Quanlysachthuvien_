import java.util.ArrayList;
import java.util.Scanner;
class Sach 
{
    String maSach;
    String tenSach;
    int soLuong;
    double giaTien;
    public Sach(String maSach, String tenSach, int soLuong, double giaTien)
     {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }
}
public class BTTuan6
{
    public static void xuLyBai1(Scanner scanner)
     {
        System.out.println("\n=== BÀI 1: MẢNG SỐ LƯỢNG 5 CUỐN SÁCH ===");
        int[] soLuong = new int[5];
        int tongSoLuong = 0;
        int maxSoLuong = Integer.MIN_VALUE;
        System.out.println("Nhập số lượng cho 5 cuốn sách:");
        for (int i = 0; i < 5; i++) {
            System.out.print("  - Sách thứ " + (i + 1) + ": ");
            soLuong[i] = scanner.nextInt();
            tongSoLuong += soLuong[i];
            if (soLuong[i] > maxSoLuong) {
                maxSoLuong = soLuong[i];
            }
        }
        System.out.println("\n--- KẾT QUẢ BÀI 1 ---");
        System.out.print("Danh sách số lượng: ");
        for (int i = 0; i < 5; i++)
        {
            System.out.print(soLuong[i] + " ");
        }
        System.out.println("\nTổng số lượng 5 cuốn: " + tongSoLuong);
        System.out.println("Số lượng lớn nhất: " + maxSoLuong + "\n");
    }
    public static void xuLyBai2(ArrayList<String> dsMaSach, Scanner scanner) 
    {
        int chon;
        do 
        {
            System.out.println("\n=== BÀI 2: QUẢN LÝ MÃ SÁCH (ArrayList<String>) ===");
            System.out.println("1. Thêm mã sách");
            System.out.println("2. Hiển thị danh sách mã sách");
            System.out.println("3. Tìm mã sách");
            System.out.println("4. Xóa mã sách");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng bài 2: ");
            chon = scanner.nextInt();
            scanner.nextLine();
            switch (chon) 
            {
                case 1:
                    System.out.print("Nhập mã sách cần thêm: ");
                    String maMoi = scanner.nextLine();
                    dsMaSach.add(maMoi);
                    System.out.println("-> Đã thêm thành công!");
                    break;
                case 2:
                    System.out.println("Danh sách mã sách: " + dsMaSach);
                    break;
                case 3:
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTim = scanner.nextLine();
                    if (dsMaSach.contains(maTim)) 
                    {
                        System.out.println("-> Tìm thấy mã '" + maTim + "' trong danh sách.");
                    } else {
                        System.out.println("-> Không tìm thấy mã này!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = scanner.nextLine();
                    if (dsMaSach.remove(maXoa)) 
                    {
                        System.out.println("-> Đã xóa thành công!");
                    } else 
                    {
                        System.out.println("-> Không tìm thấy mã để xóa!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
    public static void themSach(ArrayList<Sach> danhSachSach, Scanner scanner)
     {
        System.out.println("\n--- THÊM SÁCH MỚI ---");
        System.out.print("Nhập mã sách: ");
        String ma = scanner.nextLine();
        System.out.print("Nhập tên sách: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        int sl = scanner.nextInt();
        System.out.print("Nhập giá tiền: ");
        double gia = scanner.nextDouble();
        scanner.nextLine();
        danhSachSach.add(new Sach(ma, ten, sl, gia));
        System.out.println("-> Đã thêm sách thành công!\n");
    }
    public static void hienThiSach(ArrayList<Sach> danhSachSach) 
    {
        if (danhSachSach.isEmpty())
         {
            System.out.println("\nThư viện hiện chưa có sách nào!\n");
            return;
        }
        System.out.println("\n--- DANH SÁCH THƯ VIỆN ---");
        System.out.printf("%-15s %-30s %-12s %-15s\n", "Mã Sách", "Tên Sách", "Số Lượng", "Giá Tiền");
        System.out.println("------------------------------------------------------------------------");
        for (Sach s : danhSachSach) 
        {
            System.out.printf("%-15s %-30s %-12d %-15.2f\n", s.maSach, s.tenSach, s.soLuong, s.giaTien);
        }
        System.out.println();
    }
    public static void timSach(ArrayList<Sach> danhSachSach, Scanner scanner)
     {
        if (danhSachSach.isEmpty())
         {
            System.out.println("\nThư viện trống!\n");
            return;
        }
        System.out.print("\nNhập mã sách cần tìm: ");
        String ma = scanner.nextLine();
        boolean found = false;
        for (Sach s : danhSachSach)
     {
            if (s.maSach.equalsIgnoreCase(ma)) {
                System.out.println("-> Tìm thấy: Mã: " + s.maSach + " | Tên: " + s.tenSach + " | SL: " + s.soLuong + " | Giá: " + s.giaTien);
                found = true;
                break;
            }
        }
        if (!found)
         {
            System.out.println("-> Không tìm thấy sách có mã: " + ma);
        }
        System.out.println();
    }
    public static void xoaSach(ArrayList<Sach> danhSachSach, Scanner scanner) 
    {
        if (danhSachSach.isEmpty()) 
        {
            System.out.println("\nThư viện trống!\n");
            return;
        }
        System.out.print("\nNhập mã sách cần xóa: ");
        String ma = scanner.nextLine();
        boolean removed = false;
        for (int i = 0; i < danhSachSach.size(); i++) 
        {
            if (danhSachSach.get(i).maSach.equalsIgnoreCase(ma)) 
            {
                danhSachSach.remove(i);
                removed = true;
                System.out.println("-> Đã xóa sách thành công!\n");
                break;
            }
        }
        if (!removed) 
        {
            System.out.println("-> Không tìm thấy mã sách cần xóa!\n");
        }
    }
    public static void suaSach(ArrayList<Sach> danhSachSach, Scanner scanner) 
    {
        if (danhSachSach.isEmpty()) 
        {
            System.out.println("\nThư viện trống!\n");
            return;
        }
        System.out.print("\nNhập mã sách cần sửa: ");
        String ma = scanner.nextLine();
        boolean updated = false;
        for (Sach s : danhSachSach) 
        {
            if (s.maSach.equalsIgnoreCase(ma)) {
                System.out.print("Nhập tên mới: ");
                s.tenSach = scanner.nextLine();
                System.out.print("Nhập số lượng mới: ");
                s.soLuong = scanner.nextInt();
                System.out.print("Nhập giá tiền mới: ");
                s.giaTien = scanner.nextDouble();
                scanner.nextLine();
                updated = true;
                System.out.println("-> Cập nhật thông tin sách thành công!\n");
                break;
            }
        }
        if (!updated) 
        {
            System.out.println("-> Không tìm thấy mã sách để sửa!\n");
        }
    }
    public static void tinhTongSoLuong(ArrayList<Sach> danhSachSach) 
    {
        int tongSL = 0;
        for (Sach s : danhSachSach) 
        {
            tongSL += s.soLuong;
        }
        System.out.println("\n-> Tổng số lượng tất cả các sách trong thư viện: " + tongSL + "\n");
    }
    public static void tinhTongGiaTri(ArrayList<Sach> danhSachSach) 
    {
        double tongGT = 0;
        for (Sach s : danhSachSach) 
        {
            tongGT += (s.soLuong * s.giaTien);
        }
        System.out.printf("\n-> Tổng giá trị tài sản sách trong thư viện: %.2f VNĐ\n\n", tongGT);
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        ArrayList<String> dsMaSach = new ArrayList<>(); // Cho Bài 2
        int choice;
        do 
        {
            System.out.println("================== MENU QUẢN LÝ THƯ VIỆN ==================");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Bài tập bổ sung (Bài 1 & Bài 2)");
            System.out.println("0. Thoát chương trình");
            System.out.println("==========================================================");
            System.out.print("Nhập lựa chọn của bạn (0-8): ");
            while (!scanner.hasNextInt()) 
            {
                System.out.println("Vui lòng nhập một số hợp lệ!");
                scanner.next();
                System.out.print("Nhập lại lựa chọn: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) 
            {
                case 1:
                    themSach(danhSachSach, scanner);
                    break;
                case 2:
                    hienThiSach(danhSachSach);
                    break;
                case 3:
                    timSach(danhSachSach, scanner);
                    break;
                case 4:
                    xoaSach(danhSachSach, scanner);
                    break;
                case 5:
                    suaSach(danhSachSach, scanner);
                    break;
                case 6:
                    tinhTongSoLuong(danhSachSach);
                    break;
                case 7:
                    tinhTongGiaTri(danhSachSach);
                    break;
                case 8:
                    System.out.println("\n--- CHỌN PHẦN BÀI TẬP BỔ SUNG ---");
                    System.out.println("1. Chạy Bài 1 (Mảng số lượng 5 cuốn sách)");
                    System.out.println("2. Chạy Bài 2 (ArrayList<String> mã sách)");
                    System.out.print("Lựa chọn của bạn: ");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (subChoice == 1) 
                    {
                        xuLyBai1(scanner);
                    } else if (subChoice == 2) 
                    {
                        xuLyBai2(dsMaSach, scanner);
                    }
                    break;
                case 0:
                    System.out.println("\nCảm ơn bạn đã sử dụng chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("\nLựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 8.\n");
            }
        } while (choice != 0);
        scanner.close();
    }
}
