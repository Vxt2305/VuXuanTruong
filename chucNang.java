package qlpt11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class chucNang {
    ArrayList<PhongTro> dspt = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void nhapThongTinPhongTro() {
        int k;
        do {
            System.out.println("1: Phong sinh vien!");
            System.out.println("2: Phong gia dinh!");
            System.out.println("3: Phong vip!");
            System.out.println("Ban chon loai phong nao trong cac phong duoi day:  ");
            int n = sc.nextInt();

            if (n == 1) {
                PSV psv = new PSV();
                psv.Nhap();
                dspt.add(psv);
            } else if (n == 2) {
                PGD pgd = new PGD();
                pgd.Nhap();
                dspt.add(pgd);
            } else if (n == 3) {
                PVIP vip = new PVIP();
                vip.Nhap();
                dspt.add(vip);
            }
            System.out.println("Ban co muon nhap them phong tro hay khong ");
            System.out.println("Neu muon chon 1 ");
            System.out.println("Neu khong chon khac 1 de thoat ");
            k = sc.nextInt();
            sc.nextLine();
        } while (k == 1);
    }

    public void xuatThongTin() {
        if (dspt.size()>0) {
            for (PhongTro xuat : dspt) {
                xuat.Xuat();
            }
        }else {
            System.out.println("Danh sach trong!");
        }
    }

    public void timKiemTheoSoPhong() {
        int m;
        if (dspt.size()>0) {
            System.out.print("Nhap vao so phong ban muon tim trong danh sach: ");
            m = sc.nextInt();
            for (PhongTro tk : dspt) {
                if (m == tk.getSoPhong()) {
                    System.out.println("Thong tin phong tro ban muon tim la: ");
                    tk.Xuat();
                    break;
                } else {
                    System.out.println("Khong co so phong ban muon tim trong danh sach");
                }
            }
        }else {
            System.out.println("Danh sach trong");
        }
    }

    public void xoaTheoSoPhong() {
        int ma;
        if (dspt.size() > 0) {
             System.out.print("Nhap vao so phong ban muon xoa: ");
                ma = sc.nextInt();
            for (PhongTro xoa : dspt) {
                if (ma == xoa.getSoPhong()) {
                    dspt.remove(xoa);
                    break;
                } else {
                    System.out.println("Khong co ma so phong ma ban muon xoa trong danh sach!");
                }
            }
            xuatThongTin();
        } else {
            System.out.println("Danh sach trong");
        }

    }

    public void capNhatThongTinPhong() {
        int n;
        if (dspt.size()>0) {
            System.out.print("Nhap vao so phong ma ban muon cap nhat: ");
            n = sc.nextInt();
            for (PhongTro cp : dspt) {
                if (n == cp.getSoPhong()) {
                    cp.Nhap();
                }
            }
            xuatThongTin();
        }else {
            System.out.println("Danh sach trong!");
        }
    }

    public void sapXepTheoTienTro() {
        if (dspt.size()>0) {
            Comparator<PhongTro> cop = new Comparator<PhongTro>() {
                @Override
                public int compare(PhongTro o1, PhongTro o2) {
                    if (o1.tinhTienTro() < o2.tinhTienTro()) {
                        return 1;
                    }
                    return -1;
                }
            };
            Collections.sort(dspt, cop);
            xuatThongTin();
        }else{
            System.out.println("Danh sach trong!");
        }
    }

    public void namPhongCoTienTroCaoNhat() {
        if (dspt.size()>0) {
            Comparator<PhongTro> cop = new Comparator<PhongTro>() {
                @Override
                public int compare(PhongTro o1, PhongTro o2) {
                    if (o1.tinhTienTro() < o2.tinhTienTro()) {
                        return 1;
                    }
                    return -1;
                }
            };
            Collections.sort(dspt, cop);
            System.out.println("5 phong tro co tien tro phai dong cao nhat la : ");

            if (dspt.size() <= 5) {
                for (int i = 0; i < dspt.size(); i++) {
                    dspt.get(i).Xuat();
                }
            } else {
                for (int i = 0; i > 5; i++) {
                    dspt.get(i).Xuat();
                }
            }
        }else {
            System.out.println("Danh sach trong!");
        }
    }

    public void phongCoTienTroItNhat(){
        if (dspt.size()>0) {
             Comparator<PhongTro> cop = new Comparator<PhongTro>() {
                @Override
                public int compare(PhongTro o1, PhongTro o2) {
                    if (o1.tinhTienTro() < o2.tinhTienTro()) {
                        return 1;
                    }
                    return -1;
                }
            };
            Collections.sort(dspt, cop);
            System.out.println("Phong co tien tro it nhat la: ");
            
            for (int i = 1; i < dspt.size(); i++) {
                dspt.get(1).Xuat();
                break;
            }
        }else{
            System.out.println("Danh sach trong!");
        }
    }

    public void phongCoTienTroCaoNhat(){
        if (dspt.size()>0) {
            Comparator<PhongTro> cop = new Comparator<PhongTro>() {
                @Override
                public int compare(PhongTro o1, PhongTro o2) {
                    if (o1.tinhTienTro() > o2.tinhTienTro()) {
                        return 1;
                    }
                    return -1;
                }
            };
            Collections.sort(dspt, cop);
            System.out.println("Phong co tien tro cao nhat la: ");
            for (int i=1; i<dspt.size(); i++){
                dspt.get(1).Xuat();
                break;
            }
        }else{
            System.out.println("Danh sach trong!");
        }
    }

    public void timPhongTrongKhoangTienDaDong(){
        if (dspt.size()>0) {
            int min;
            int max;
            System.out.print("Nhap khoang tien bat dau :  ");
            min = sc.nextInt();
            System.out.println("Nhap khoang tien ket thuc:  ");
            max = sc.nextInt();
            for (PhongTro tim : dspt) {
                if (tim.tinhTienTro() > min && tim.tinhTienTro() < max) {
                    tim.Xuat();
                }else{
                    System.out.println("Khong co phong tro nam trong khoang tien can tim");
                }
            }
        }else{
            System.out.println("Danh sach trong!");
        }
    }

}
