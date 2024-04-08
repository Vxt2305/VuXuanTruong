package qlpt11;

import java.util.Scanner;

public class PGD extends PhongTro {

    private double TienDieuHoa;
    private double TienBanCong;
    private double TienVeSinh;
    private double tienTroCoDinh;
    Scanner sc = new Scanner(System.in);

    public PGD() {
    }

    public PGD(double tienDieuHoa, double tienBanCong, double tienVeSinh, double tienTroCoDinh) {
        TienDieuHoa = tienDieuHoa;
        TienBanCong = tienBanCong;
        TienVeSinh = tienVeSinh;
        this.tienTroCoDinh = tienTroCoDinh;
    }

    public double getTienDieuHoa() {
        return TienDieuHoa;
    }

    public double getTienBanCong() {
        return TienBanCong;
    }

    public double getTienVeSinh() {
        return TienVeSinh;
    }

    public double getTienTroCoDinh() {
        return tienTroCoDinh;
    }

    public void setTienDieuHoa(double TienDieuHoa) {
        this.TienDieuHoa = TienDieuHoa;
    }

    public void setTienBanCong(double TienBanCong) {
        this.TienBanCong = TienBanCong;
    }

    public void setTienVeSinh(double TienVeSinh) {
        this.TienVeSinh = TienVeSinh;
    }

    public void setTienTroCoDinh(double tienTroCoDinh) {
        this.tienTroCoDinh = tienTroCoDinh;
    }

    public PGD(int soPhong, String tenChuPhong, double soDienDaDung, double soNuocDaDung, double tienWifi, double tienChiPhiPhong, double tienDieuHoa, double tienBanCong, double tienVeSinh, double tienTroCoDinh) {
        super(soPhong, tenChuPhong, soDienDaDung, soNuocDaDung, tienWifi, tienChiPhiPhong);
        TienDieuHoa = tienDieuHoa;
        TienBanCong = tienBanCong;
        TienVeSinh = tienVeSinh;
        this.tienTroCoDinh = tienTroCoDinh;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.print("Moi nhap so tien dieu hoa: ");
        while (!sc.hasNextDouble() && TienDieuHoa <= 0) {
            System.out.print("Moi nhap so tien dieu hoa la mot so thuc:  ");
            sc.next();
        }
        TienDieuHoa = sc.nextDouble();
        System.out.print("Moi nhap so tien ban cong: ");
        while (!sc.hasNextDouble() && TienBanCong <= 0) {
            System.out.print("Moi nhap so tien ban cong la mot so thuc:  ");
            sc.next();
        }
        TienBanCong = sc.nextDouble();
        System.out.print("Moi nhap so tien ve sinh: ");
        while (!sc.hasNextDouble() && TienVeSinh <= 0) {
            System.out.print("Moi nhap so tien ve sinh la mot so thuc:  ");
            sc.next();
        }
        TienVeSinh = sc.nextDouble();
        System.out.print("Moi nhap so tien tro co dinh: ");
        while (!sc.hasNextDouble() && tienTroCoDinh <= 0) {
            System.out.print("Moi nhap so tien tro la mot so thuc:  ");
            sc.next();
        }
        tienTroCoDinh = sc.nextDouble();
    }

    @Override
    public double getTienChiPhiPhong() {
        return getSoDienDaDung() + getSoNuocDaDung() + getTienWifi() + getTienDieuHoa() + getTienBanCong() + getTienVeSinh();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("Tien dieu hoa la : " + getTienDieuHoa() + "      Tien ve sinh la : " + getTienVeSinh() + "     Tien ban cong la : " + getTienBanCong() + "     Tong tien chi phi phong la: " + getTienChiPhiPhong() + "        Tong tien tro phai dong la: " + tinhTienTro());
    }

    @Override
    public double tinhTienTro() {
        return getTienChiPhiPhong() + getTienTroCoDinh();
    }
}
