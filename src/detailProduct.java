public class detailProduct{
    private String modal;
    private String diskSize;
    private String batteryCapacity;
    private ScreenDisplay display;
    private String screenQuality;
    IOStream sc;
    public detailProduct(){
        sc = new IOStream();
    }
    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity() {
        System.out.print ("Nhap dung luong pin cua san pham (W) : ");
        batteryCapacity = sc.nextLine();
    }

    public String getModal() {
        return modal;
    }

    public void setModal() {
        System.out.print("Nhap modal cua san pham : ");
        modal = sc.nextLine();
    }

    public String getDiskSize() {
        return diskSize;
    }

    public void setDiskSize() {
        System.out.print("Nhap dung luong o cung (don vi Gb) : ");
        diskSize = sc.nextLine();
    }

    public String getDisplay() {
        return display.getChieuDai() + "x" + display.getChieuRong();
    }

    public void setDisplay() {
        display = new ScreenDisplay();
        while(true){
            System.out.print("Nhap chieu dai cua san pham : ");
            display.setChieuDai();
            System.out.print("Nhap chieu rong cua san pham : ");
            display.setChieuRong();
            if(display.getChieuDai() >= display.getChieuRong()){
                break;
            }else{
                System.out.println("Vui long nhap chieu dai > chieu rong");
            }
        }
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality() {
        System.out.print("Nhap chat luong man hinh (don vi HD) : ");
        screenQuality = sc.nextLine();
    }

    public void table() {
        System.out.printf("%-25s%-25s%-25s%-25s%-25s", "Modal san pham", "Dung luong o cung(Gb)" , "Dung luong pin(W)" , "Do phan giai man hinh" , "Chat luong hinh anh(HD)");
    }

    public void displayThongTinBenTrongSanPham() {
        table();
        System.out.println();
        System.out.printf("%-25s%-25s%-25s%-25s%-25s", modal, diskSize, batteryCapacity, getDisplay(), screenQuality);
        System.out.println();
    }
}
