public class PartTime extends Staff {
    private int soCaLam;
    private int soTienTheoGio;
    // INIT
    IOStream sc = new IOStream();
    public PartTime() {
        setSoCaLam();
        setSoTienTheoGio();
    }
    // GET
    public int getSoCaLam() {
        return soCaLam;
    }
    public int soTienTheoGio() {
        return soTienTheoGio;
    }
    // SET
    public void setSoCaLam() {
        System.out.print("Nhap so ca lam: "); this.soCaLam = sc.nextInt();
        while(this.soCaLam < 0){
            System.out.print("Moi ban nhap lai gia tri >= 0: ");
            this.soCaLam = sc.nextInt();
        }
    }
    public void setSoTienTheoGio() {
        System.out.print("Nhap so tien theo gio: "); this.soTienTheoGio = sc.nextInt();
        while(this.soTienTheoGio <= 0){
            System.out.print("Moi ban nhap lai gio > 0: ");
            this.soTienTheoGio = sc.nextInt();
        }
    }

    @Override
    public void displayDetail() {
        super.displayDetail();
        System.out.println("So ca lam: " + soCaLam);
        System.out.println("So tien theo gio: " + soTienTheoGio);
        System.out.printf("Tong luong: %.2f\n",tinhTongLuong());
    }

    @Override
    public double tinhTongLuong() {
        return getSalary_bonus() - getSalary_fine() + soCaLam * soTienTheoGio;
    }
}
