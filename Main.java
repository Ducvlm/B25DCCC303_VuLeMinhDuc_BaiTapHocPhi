import java.util.Scanner;

class SinhVien {
    private String maSV;
    private String hoTen;
    private String ngaySinh;

    public SinhVien(String maSV, String hoTen, String ngaySinh) {
        this.maSV = maSV.trim();
        this.hoTen = chuanHoaTen(hoTen);
        this.ngaySinh = chuanHoaNgaySinh(ngaySinh);
    }

    private String chuanHoaTen(String s) {
        String[] words = s.trim().toLowerCase().split("\\s+");
        String res = "";
        for (int i = 0; i < words.length; i++) {
            res += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
            if (i < words.length - 1) {
                res += " ";
            }
        }
        return res;
    }

    private String chuanHoaNgaySinh(String s) {
        String[] parts = s.trim().split("/");
        String d = parts[0].length() == 1 ? "0" + parts[0] : parts[0];
        String m = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
        String y = parts[2];
        return d + "/" + m + "/" + y;
    }

    @Override
    public String toString() {
        return maSV + " " + hoTen + " " + ngaySinh;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        SinhVien[] ds = new SinhVien[n + 1];

        for (int i = 1; i <= n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String ns = sc.nextLine();
            ds[i] = new SinhVien(ma, ten, ns);
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(ds[i]);
        }
        sc.close();
    }
}