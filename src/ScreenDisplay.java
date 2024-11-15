public class ScreenDisplay {
    int chieuDai , chieuRong;
    IOStream sc = new IOStream();
    public void setChieuDai() {
        this.chieuDai = sc.nextInt();
    }

    public void setChieuRong() {
        this.chieuRong = sc.nextInt();
    }

    public int getChieuDai() {
        return chieuDai;
    }

    public int getChieuRong() {
        return chieuRong;
    }
}
