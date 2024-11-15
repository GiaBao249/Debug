public class Main {
    public static void main(String[] args) {
        IOStream sc = new IOStream();
        StaffList staffList = new StaffList();
        ListProducts productsList = new ListProducts();
        Transaction transaction = new Transaction() {
            @Override
            public double ApplyPromotion() {
                return 1;
            }
        };
        //ListTong = new List();
        // Menu
        int choice;
        do{
            System.out.println("\n-----------------------Trung Tam-----------------------------");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("1. Thao tac voi danh sach nhan vien");
            System.out.println("2. Thao tac voi danh sach san pham");
            System.out.println("3. Mua hang");
            System.out.print("Ban chon..."); choice = sc.nextInt();
            switch(choice){
                case 0:                   break;
                case 1: staffList.menu(); break;
                case 2: productsList.menu(); break;
                case 3:
                    if(productsList.getSumProductOnStore() >= 1){
                        transaction.menuBuy();
                    }else{
                        System.out.println("Hien khong co san pham !");
                    }
                    break;
                default:
                    System.out.println("Gia tri nhap khong hop le!!!. Vui long nhap lai.");
                    break;
            }
        }while(choice!=0);
        System.out.println("Da ket thuc chuong trinh!!!");
    }
}