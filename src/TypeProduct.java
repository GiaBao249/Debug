import java.util.Scanner;

public class TypeProduct {
    String type;
    IOStream sc = new IOStream();
    public TypeProduct(){
    }

    public void setType() {
        System.out.println("Moi ban nhap loai san pham ?");
        System.out.println("1. IOS");
        System.out.println("2. ANDROID");
        System.out.print("Moi ban nhap lua chon : ");
        int choice = sc.nextInt();
        while(true) {
            if (choice == 1) {
                type = "IOS";
                break;
            } else if (choice == 2) {
                type = "ANDROID";
                break;
            } else {
                System.out.println("ERROR! Vui long nhap dung san pham loai 1 hoac 2");
                choice = sc.nextInt();
            }
        }
    }
    public String getType(){
        return type;
    }
}
