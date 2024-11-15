import java.util.Arrays;

public class StaffList {
    private Staff []staffs = new Staff[0];
    IOStream sc = new IOStream();

    //-----------------------CONSTRUCTOR---------------------------------------
    public StaffList() {
//        System.out.print("Nhap so luong nhan vien: ");
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            System.out.printf("Nhap thong tin nhan vien %d: \n", i + 1);
//            add();
//        }
    }

    //----------------------MENU----------------------------------
    public void menu(){
        int choice;
        do{
            System.out.println("\n-----------------------Nhan vien-----------------------------");
            System.out.println("0. Thoat");
            System.out.println("1. Them");
            System.out.println("2. Xoa");
            System.out.println("3. Sap xep");
            System.out.println("4. Tim kiem");
            System.out.println("5. Sua");
            System.out.println("6. Xuat");
            System.out.print("Ban chon..."); choice = sc.nextInt();
            switch (choice){
                case 0:            break;
                case 1: add();     break;
                case 2: delete();  break;
                case 3: sort();    break;
                case 4: filter();    break;
                case 5: fix();     break;
                case 6: display(); break;
                default:
                    System.out.println("Gia tri nhap khong hop le!!!. Vui long nhap lai.");
                    break;
            }
        }while(choice!=0);
    }

    //-----------------------ADD---------------------------------------
    public void add(){
        System.out.println("Nhap 1 de chon loai nhan vien ban thoi gian");
        System.out.println("Nhap 2 de chon loai nhan vien toan thoi gian");
        System.out.print("Ban chon...");
        int num = sc.nextInt();
        while (num != 1 && num != 2) {
            System.out.println("So nhap vao khong hop le!!!");
            System.out.print("Moi nhap lai...");
            num = sc.nextInt();
        }
        String id = fixId();
        staffs = Arrays.copyOf(staffs, staffs.length + 1);
        switch (num){
            case 1:
                staffs[staffs.length-1] = new PartTime();
                break;
            case 2:
                staffs[staffs.length-1] = new FullTime();
                break;
        }
        staffs[staffs.length-1].setId(id);
    }

    public boolean isSame(String id) {
        for(int i = 0; i < staffs.length; i++){
            if(id.compareTo(staffs[i].getId()) == 0){
                return true;
            }
        }
        return false;
    }
    //--------------------------DELETE-------------------------------------
    public void delete(){
        System.out.print("Nhap ma nhan vien can xoa: "); String id = sc.nextLine();
        int n = staffs.length;
        boolean found = false;
        for(int i = 0; i < n; i++){
            if(id.compareTo(staffs[i].getId()) == 0){
                found = true;
                for(int j = i; j < n - 1; j++)
                    staffs[j] = staffs[j+1];
            }
        }

        if(found){
            staffs = Arrays.copyOf(staffs, n - 1);
            System.out.println("Xoa nhan vien thanh cong!!!");
        }
        else System.out.println("Khong tim thay ma nhan vien!!!");
    }
    // -------------------------SORT--------------------------------------
    public void sort(){
        int choice;
        do{
            System.out.println("\n-----------------------Sap xep nhan vien-----------------------------");
            System.out.println("0. Thoat ham sap xep");
            System.out.println("1. Sap xep theo ten tu A -> Z");
            System.out.println("2. Sap xep theo ten tu Z -> A");
            System.out.print("Ban chon..."); choice = sc.nextInt();
            boolean success = false;
            switch (choice){
                case 0:                                break;
                case 1: sortByNameInc(); success=true; break;
                case 2: sortByNameDec(); success=true; break;
                default:
                    System.out.println("Gia tri nhap khong hop le!!!. Vui long nhap lai.");
                    break;
            }
            if(success) System.out.println("Sap xep thanh cong!!!");
        }while (choice==0);
    }
    public void sortByNameInc(){
        int n = staffs.length;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(staffs[i].getName().compareTo(staffs[j].getName()) > 0){
                    Staff temp = staffs[i];
                    staffs[i] = staffs[j];
                    staffs[j] = temp;
                }
            }
        }
    }
    public void sortByNameDec(){
        int n = staffs.length;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(staffs[i].getName().compareTo(staffs[j].getName()) < 0){
                    Staff temp = staffs[i];
                    staffs[i] = staffs[j];
                    staffs[j] = temp;
                }
            }
        }
    }
    // --------------------------FILTER-----------------------------
    public void filter(){
        int choice;
        do{
            System.out.println("\n-----------------------Tim kiem nhan vien-----------------------------");
            System.out.println("0. Thoat ham tim kiem");
            System.out.println("1. Tim kiem nhan vien theo ten");
            System.out.println("2. Tim kiem nhan vien theo ma");
            System.out.print("Ban chon..."); choice = sc.nextInt();
            switch (choice){
                case 0:               break;
                case 1: findByName(); break;
                case 2: findById();   break;
                default:
                    System.out.println("Gia tri nhap khong hop le!!!. Vui long nhap lai.");
                    break;
            }
        }while (choice==0);
    }
    public void findByName(){
        boolean found = false;
        System.out.print("Nhap ten can tim: "); String name = sc.nextLine();
        for(int i = 0; i < staffs.length; i++){
            if(staffs[i].getName().contains(name)){
                if(!found){
                    found = true;
                    table();
                }
                staffs[i].xuat();
            }
        }
        if(!found){
            System.out.println("Khong tim thay ten phu hop!!!");
        }
    }
    public void findById(){
        System.out.print("Nhap ma nhan vien can tim: "); String id = sc.nextLine();
        Staff tmp = find(id);
        if(tmp != null){
            table();
            tmp.xuat();
        }
        else System.out.println("Khong tim thay ma nhan vien phu hop!!!");
    }
    //----------------------------FIND----------------------------------
    public Staff find(String id){
        for(int i=0; i<staffs.length; i++)
            if(id.compareTo(staffs[i].getId()) == 0)
                return staffs[i];
        return null;
    }
    //----------------------------FIX-------------------------------------
    public void fix(){
        System.out.print("Nhap ma nhan vien can thay doi: "); String id = sc.nextLine();
        Staff tmp = find(id);
        if(tmp != null){
            int choice;
            do {
                System.out.println("\n-----------------------Sua thong tin nhan vien-----------------------------");
                System.out.println("0.  Thoat ham sua thong tin");
                System.out.println("1.  Thay doi ma nhan vien");
                System.out.println("2.  Thay doi ten nhan vien");
                System.out.println("3.  Thay doi can cuoc cong dan");
                System.out.println("4.  Thay doi dia chi");
                System.out.println("5.  Thay doi que quan");
                System.out.println("6.  Thay doi so dien thoai");
                System.out.println("7.  Thay doi email");
                System.out.println("8.  Thay doi ngay sinh");
                System.out.println("9.  Thay doi ngay bat dau");
                System.out.println("10. Thay doi gioi tinh");
                System.out.println("11. Thay doi chuc vu");
                System.out.println("12. Thay doi luong thuong");
                System.out.println("13. Thay doi luong phat");
                System.out.print("Ban chon..."); choice = sc.nextInt();
                switch (choice) {
                    case 0:                               break;
                    case 1:  tmp.setId(fixId());    break;
                    case 2:  tmp.setName();         break;
                    case 3:  tmp.setIdCitizen();    break;
                    case 4:  tmp.setAddress();      break;
                    case 5:  tmp.setHometown();     break;
                    case 6:  tmp.setPhone();        break;
                    case 7:  tmp.setEmail();        break;
                    case 8:  tmp.setBirthday();     break;
                    case 9:  tmp.setStartDate();    break;
                    case 10: tmp.setGender();       break;
                    case 11: tmp.setPosition();     break;
                    case 12: tmp.setSalary_bonus(); break;
                    case 13: tmp.setSalary_fine();  break;
                    default:
                        System.out.println("Gia tri nhap khong hop le!!!. Vui long nhap lai.");
                        break;
                }
            } while (choice != 0);
        }
        else System.out.println("Khong tim thay ma nhan vien phu hop!!!");
        for(int i = 0; i < staffs.length; i++){
            if(staffs[i].getId().contains(id)){

                return;
            }
        }

    }

    public String fixId(){
        System.out.print("Nhap ma nhan vien: ");
        String id = sc.nextLine();
        while (true) {
            if (id.isEmpty()) {
                System.out.println("Chua nhap ma nhan vien!!!");
                System.out.print("Nhap ma nhan vien: ");
                id = sc.nextLine();
            }
            else if(isSame(id)){
                System.out.println("Ma nhan vien bi trung!!!");
                System.out.print("Nhap lai ma nhan vien: ");
                id = sc.nextLine();
            }
            else break;
        }
        return id;
    }
    //---------------------------DISPLAY-------------------------------------
    public void table(){
        System.out.printf("%-10s%-20s%-15s%-10s%-15s%-20s%-15s%s\n","Ma so","Ho va ten","Ngay sinh","Gioi tinh","Chuc vu","Luong","So dien thoai","Email");
    }
    public void display(){
        int choice;
        do{
            System.out.println("\n-----------------------Xuat nhan vien-----------------------------");
            System.out.println("0. Thoat ham xuat");
            System.out.println("1. Xuat thong tin chi tiet nhan vien");
            System.out.println("2. Xuat danh sach nhan vien");
            System.out.print("Ban chon..."); choice = sc.nextInt();
            switch (choice){
                case 0:               break;
                case 1: displayDetail(); break;
                case 2: displayFull();   break;
                default:
                    System.out.println("Gia tri nhap khong hop le!!!. Vui long nhap lai.");
                    break;
            }
        }while (choice==0);
    }

    public void displayDetail(){
        System.out.print("Moi nhap ma so nhan vien...");
        String id = sc.nextLine();
        for(int i=0; i < staffs.length; i++){
            if(id.compareTo(staffs[i].getId()) == 0){
                staffs[i].displayDetail();
                return;
            }
        }
        System.out.println("Khong tim thay ma nhan vien trong danh sach!!!");
    }

    public void displayFull(){
        if(staffs.length == 0){
            System.out.println("Khong co thong tin nhan vien trong danh sach!!!");
            return;
        }
        table();
        for(int i=0; i < staffs.length; i++){
            staffs[i].xuat();
        }
    }
}
