#include <iostream>
#include <vector>
#include <string>
#include <iomanip>
using namespace std;
struct Sach {
    string maSach;
    string tenSach;
    int soLuong;
    double giaTien;
};
void nhapDanhSach(vector<Sach>& ds) {
    int n;
    cout << "\n--- BÀI 1: NHẬP DANH SÁCH SÁCH ---\n";
    cout << "Nhập số lượng sách cần thêm (n): ";
    cin >> n;
    cin.ignore();
    for (int i = 0; i < n; ++i)
     {
        Sach s;
        cout << "\nNhập thông tin cuốn sách thứ " << i + 1 << ":\n";
        cout << "  - Mã sách: ";
        getline(cin, s.maSach);
        cout << "  - Tên sách: ";
        getline(cin, s.tenSach);
        cout << "  - Số lượng: ";
        cin >> s.soLuong;
        cout << "  - Giá tiền (VNĐ): ";
        cin >> s.giaTien;
        cin.ignore(); 
        ds.push_back(s);
    }
    cout << "-> Đã nhập thành công " << n << " cuốn sách!\n";
}
void tinhTong(const vector<Sach>& ds) 
{
    if (ds.empty()) {
        cout << "\n--- BÀI 2: THỐNG KÊ ---\n";
        cout << "Thư viện hiện chưa có sách nào!\n";
        return;
    }
    int tongSoLuong = 0;
    double tongGiaTri = 0;
    for (const auto& s : ds) 
    {
        tongSoLuong += s.soLuong;
        tongGiaTri += (s.soLuong * s.giaTien);
    }
    cout << "\n--- BÀI 2: THỐNG KÊ KẾT QUẢ ---\n";
    cout << "Tổng số lượng tất cả các cuốn sách: " << tongSoLuong << endl;
    cout << "Tổng giá trị tài sản sách trong thư viện: " << fixed << setprecision(2) << tongGiaTri << " VNĐ\n";
}
void hienThiDanhSach(const vector<Sach>& ds) 
{
    if (ds.empty()) {
        cout << "\nDanh sách thư viện trống!\n";
        return;
    }
    cout << "\n--- DANH SÁCH SÁCH TRONG THƯ VIỆN ---\n";
    cout << left << setw(15) << "Mã Sách" << setw(30) << "Tên Sách" << setw(12) << "Số Lượng" << setw(15) << "Giá Tiền" << endl;
    cout << string(72, '-') << endl;
    for (const auto& s : ds) 
    {
        cout << left << setw(15) << s.maSach 
             << setw(30) << s.tenSach 
             << setw(12) << s.soLuong 
             << setw(15) << fixed << setprecision(2) << s.giaTien << endl;
    }
}
void timKiemSach(const vector<Sach>& ds) 
{
    if (ds.empty()) {
        cout << "\n--- BÀI 4: TÌM KIẾM SÁCH ---\n";
        cout << "Thư viện chưa có dữ liệu để tìm kiếm!\n";
        return;
    }
    string maCanTim;
    cout << "\n--- BÀI 4: TÌM KIẾM SÁCH THEO Mã ---\n";
    cout << "Nhập mã sách cần tìm: ";
    cin.ignore();
    getline(cin, maCanTim);
    bool found = false;
    for (const auto& s : ds) 
    {
        if (s.maSach == maCanTim) {
            cout << "\nĐã tìm thấy sách:\n";
            cout << "  - Mã sách: " << s.maSach << "\n";
            cout << "  - Tên sách: " << s.tenSach << "\n";
            cout << "  - Số lượng: " << s.soLuong << "\n";
            cout << "  - Giá tiền: " << fixed << setprecision(2) << s.giaTien << " VNĐ\n";
            found = true;
            break;
        }
    }
    if (!found) {
        cout << "Không tìm thấy cuốn sách nào có mã: " << maCanTim << endl;
    }
}
int main()
{
    vector<Sach> dsSach;
    int choice;
    do 
    {
        cout << "\n================ QUẢN LÝ THƯ VIỆN ================\n";
        cout << "1. Nhập danh sách sách (Bài 1)\n";
        cout << "2. Hiển thị danh sách sách\n";
        cout << "3. Tính tổng số lượng và tổng giá trị sách (Bài 2)\n";
        cout << "4. Tìm kiếm sách theo mã (Bài 4)\n";
        cout << "0. Thoát chương trình (Bài 3)\n";
        cout << "=================================================\n";
        cout << "Nhập lựa chọn của bạn (0-4): ";
        cin >> choice;
        switch (choice) {
            case 1:
                nhapDanhSach(dsSach);
                break;
            case 2:
                hienThiDanhSach(dsSach);
                break;
            case 3:
                tinhTong(dsSach);
                break;
            case 4:
                timKiemSach(dsSach);
                break;
            case 0:
                cout << "\nCảm ơn bạn đã sử dụng chương trình. Tạm biệt!\n";
                break;
            default:
                cout << "\nLựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 4.\n";
        }
    } while (choice != 0);
    return 0;
}