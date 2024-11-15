public class FullTime extends Staff {
    private int luongCoBan;
    private int luongTangCa;
    private int soNgayLam;
    // INIT
    IOStream sc = new IOStream();
    public FullTime() {
        setLuongCoBan();
        setLuongTangCa();
        setSoNgayLam();
    }
    // GET
    public int getLuongCoBan() {
        return luongCoBan;
    }
    public int getLuongTangCa() {
        return luongTangCa;
    }
    public int getSoNgayLam() {
        return soNgayLam;
    }
    // SET
    public void setLuongCoBan() {
        System.out.print("Nhap luong co ban: "); this.luongCoBan = sc.nextInt();
        while (this.luongCoBan <= 0) {
            System.out.print("Moi ban nhap lai gia tri > 0: ");
            this.luongCoBan = sc.nextInt();
        }
    }
    public void setLuongTangCa() {
        System.out.print("Nhap luong tang ca: "); this.luongTangCa = sc.nextInt();
        while (this.luongTangCa < 0) {
            System.out.print("Moi ban nhap lai gia tri >= 0: ");
            this.luongTangCa = sc.nextInt();
        }
    }
    public void setSoNgayLam() {
        System.out.print("Nhap so ngay lam: "); this.soNgayLam = sc.nextInt();
        while (this.soNgayLam < 0) {
            System.out.print("Moi ban nhap lai gia tri >= 0: ");
            this.soNgayLam = sc.nextInt();
        }
    }
    /////////////////////////
    @Override
    public void displayDetail() {
        super.displayDetail();
        System.out.println("Luong co ban: " + getLuongCoBan());
        System.out.println("Luong tang ca: " + getLuongTangCa());
        System.out.println("So ngay lam: " + getSoNgayLam());
        System.out.printf("Tong luong: %.2f\n",tinhTongLuong());
    }

    @Override
    public double tinhTongLuong() {
        return getSalary_bonus() - getSalary_fine() + luongCoBan*soNgayLam - luongTangCa;
    }
}
