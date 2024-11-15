public class Accessory {
    protected boolean earPhone , charger;

    IOStream sc = new IOStream();

    public void setCharger() {
        while(true) {
            System.out.println("San pham nay co cuc sac khong?: ");
            System.out.println("1. Co");
            System.out.println("2. Khong");
            System.out.print("Nhap lua chon: ");
            int choice = sc.nextInt();
            if (choice == 1){
                this.charger = true;
                break;
            }
            else if (choice == 2){
                this.charger = false;
                break;
            }
            else {
                System.out.println("Erorr!!!");
            }
        }
    }

    public void setEarPhone() {
        while(true) {
            System.out.println("San pham nay co tai nghe khong?: ");
            System.out.println("1. Co");
            System.out.println("2. Khong");
            System.out.print("Nhap lua chon: ");
            int choice = sc.nextInt();
            if (choice == 1){
                this.earPhone = true;
                break;
            }
            else if (choice == 2){
                this.earPhone = false;
                break;
            }
            else {
                System.out.println("Erorr!!!");
            }
        }
    }

    public boolean isCharger(){
        return charger;
    }

    public boolean isEarPhone(){
        return earPhone;
    }
}
