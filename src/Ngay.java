public class Ngay {
    private int dd;
    private int mm;
    private int yyyy;
    // INIT
    IOStream sc = new IOStream();
    public Ngay() {
        setDd();
        setMm();
        setYyyy();
    }

    public Ngay(int dd, int mm, int yyyy) {
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
    }
    // GET
    public int getDd() {
        return dd;
    }
    public int getMm() {
        return mm;
    }
    public int getYyyy() {
        return yyyy;
    }
    // SET
    public void setDd() {
        System.out.print("Moi nhap ngay: "); this.dd = sc.nextInt();
        while (this.dd <= 0 || this.dd > 31) {
            System.out.print("Moi lai gia tri > 0 va < 32: ");
            this.dd = sc.nextInt();
        }
    }
    public void setMm() {
        System.out.print("Moi nhap thang: "); this.mm = sc.nextInt();
        while (this.mm <= 0 || this.mm > 12) {
            System.out.print("Moi lai gia tri > 0 va < 13: ");
            this.mm = sc.nextInt();
        }
    }
    public void setYyyy() {
        System.out.print("Moi nhap nam: "); this.yyyy = sc.nextInt();
    }
    // --------------------
    public String getNgay() {
        return String.format("%02d/%02d/%d", dd, mm, yyyy);
    }
}