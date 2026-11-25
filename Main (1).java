import java.util.Scanner;

abstract class SinhVien {
    protected String maSV;
    protected String maHe;
    protected int soTinChi;

    public SinhVien(String maSV, String maHe, int soTinChi) {
        this.maSV = maSV;
        this.maHe = maHe;
        this.soTinChi = soTinChi;
    }

    public abstract long hocPhi();

    @Override
    public String toString() {
        return maSV + " " + maHe + " " + hocPhi();
    }
}

class SinhVienCQ extends SinhVien {
    public SinhVienCQ(String maSV, String maHe, int soTinChi) {
        super(maSV, maHe, soTinChi);
    }

    @Override
    public long hocPhi() {
        return soTinChi * 450000L;
    }
}

class SinhVienCLC extends SinhVien {
    public SinhVienCLC(String maSV, String maHe, int soTinChi) {
        super(maSV, maHe, soTinChi);
    }

    @Override
    public long hocPhi() {
        return (long) (soTinChi * 450000L * 1.5);
    }
}

class SinhVienLT extends SinhVien {
    public SinhVienLT(String maSV, String maHe, int soTinChi) {
        super(maSV, maHe, soTinChi);
    }

    @Override
    public long hocPhi() {
        return soTinChi * 450000L + 2000000L;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SinhVien[] ds = new SinhVien[n + 1];

        for (int i = 1; i <= n; i++) {
            String maHe = sc.next();
            String maSV = sc.next();
            int soTinChi = sc.nextInt();

            if (maHe.equals("CQ")) {
                ds[i] = new SinhVienCQ(maSV, maHe, soTinChi);
            } else if (maHe.equals("CLC")) {
                ds[i] = new SinhVienCLC(maSV, maHe, soTinChi);
            } else {
                ds[i] = new SinhVienLT(maSV, maHe, soTinChi);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(ds[i]);
        }
        sc.close();
    }
}