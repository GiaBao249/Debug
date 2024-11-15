public class GioiTinh {
    String gender;
    IOStream sc = new IOStream();
    //////////////////////
    public  GioiTinh() {
        setGender();
    }
    ////////////////////////
    public  String getGender() {
        return gender;
    }
    ////////////////////////
    public  void setGender() {
        System.out.println("Moi chon gioi tinh: ");
        System.out.println("Nhap 1 neu ban la nam: ");
        System.out.println("Nhap 2 neu ban la nu: ");
        System.out.print("Ban chon... ");
        int num = sc.nextInt();
        while(num!=1 && num!=2) {
            System.out.print("Moi ban nhap lai...");
            num = sc.nextInt();
        }
        if(num==1) gender = "Nam";
        else gender = "Nu";
    }
}
