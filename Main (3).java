import java.util.Scanner;

interface MienGiam {
    long tinhGiam(long hocPhi);
}

class ConChinhSach implements MienGiam {
    @Override
    public long tinhGiam(long hocPhi) {
        return (long) (hocPhi * 0.5);
    }
}

class HoNgheo implements MienGiam {
    @Override
    public long tinhGiam(long hocPhi) {
        return (long) (hocPhi * 0.7);
    }
}

class HocBong implements MienGiam {
    @Override
    public long tinhGiam(long hocPhi) {
        return Math.min(hocPhi, 3000000L);
    }
}

abstract class SinhVien {
    protected String maSV;
    protected String maHe;
    protected int soTinChi;
    protected MienGiam chinhSach;

    public SinhVien(String maSV, String maHe, int soTinChi) {
        this.maSV = maSV;
        this.maHe = maHe;
        this.soTinChi = soTinChi;
        this.chinhSach = null;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getMaHe() {
        return maHe;
    }

    public void setChinhSach(MienGiam chinhSach) {
        this.chinhSach = chinhSach;
    }

    public abstract long hocPhi();

    public long tienGiam() {
        if (chinhSach == null) {
            return 0;
        }
        return chinhSach.tinhGiam(hocPhi());
    }

    public long phaiNop() {
        return hocPhi() - tienGiam();
    }

    @Override
    public String toString() {
        return maSV + " " + maHe + " " + hocPhi() + " " + tienGiam() + " " + phaiNop();
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

        int m = sc.nextInt();
        for (int i = 1; i <= m; i++) {
            String maSV = sc.next();
            String maCS = sc.next();

            SinhVien found = null;
            for (int j = 1; j <= n; j++) {
                if (ds[j].getMaSV().equals(maSV)) {
                    found = ds[j];
                    break;
                }
            }

            if (found == null) {
                System.out.println("NOT FOUND " + maSV);
            } else {
                if (maCS.equals("CS")) {
                    found.setChinhSach(new ConChinhSach());
                } else if (maCS.equals("HN")) {
                    found.setChinhSach(new HoNgheo());
                } else if (maCS.equals("HB")) {
                    found.setChinhSach(new HocBong());
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(ds[i]);
        }

        String[] heDaoTao = {"CQ", "CLC", "LT"};
        for (int h = 0; h < heDaoTao.length; h++) {
            String he = heDaoTao[h];
            int count = 0;
            long tongPhaiNop = 0;

            for (int i = 1; i <= n; i++) {
                if (ds[i].getMaHe().equals(he)) {
                    count++;
                    tongPhaiNop += ds[i].phaiNop();
                }
            }

            if (count > 0) {
                System.out.println(he + " " + count + " " + tongPhaiNop);
            }
        }

        sc.close();
    }
}