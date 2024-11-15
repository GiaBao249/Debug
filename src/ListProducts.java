import java.util.Arrays;

public class ListProducts {
    private static ListProducts instance;
    Product[] products = new Product[0];
    int quantityProduct = 0;
    IOStream sc;
    ListProducts(){
        //listID = new String[0];
        sc = new IOStream();
    }

    //Singleton
    public static ListProducts getInstance() {
        if (instance == null) {
            instance = new ListProducts();
        }
        return instance;
    }

    //--------------------------CheckID && FixID-------------------------------------
    public void menu(){
        System.out.println("\nMENU:");
        System.out.println("1. Them san pham");
        System.out.println("2. Xoa san pham theo ID");
        System.out.println("3. Sap xep");
        System.out.println("4. Loc san pham theo ten");
        System.out.println("5. Tim san pham theo ID");
        System.out.println("6. Tim san pham theo ten");
        System.out.println("7. Sua san pham");
        System.out.println("8. Dua ra so luong mat hang co trong cua hang");
        System.out.println("9. Hien thi tat ca san pham");
        System.out.println("10. Hien thi thong tin ben trong san pham");
        System.out.println("11. Them danh gia cho san pham");
        System.out.println("12. Xem thong tin danh gia cua san pham");
        System.out.println("13. In ra san pham co danh gia cao");
        System.out.println("14. Cap nhat danh gia");
        System.out.println("15. Xoa danh gia");
        System.out.print("Chon mot chuc nang: ");
        int choice = sc.nextInt();
        String id , name;
        switch (choice){
            case 1:
                add();
                break;
            case 2:
                System.out.print("Moi ban nhap id san pham de xoa: ");
                id = sc.nextLine();
                Delete(id);
                break;
            case 3:
                sortType();
                break;
            case 4:
                System.out.print("Moi ban nhap thong tin can loc: ");
                id = sc.nextLine();
                filter(id);
                break;
            case 5:
                System.out.print("Moi ban nhap id san pham de tim kiem: ");
                id = sc.nextLine();
                findProductById(id).displayProduct();
                break;
            case 6:
                System.out.print("Moi ban nhap name san pham de tim kiem: ");
                name = sc.nextLine();
                findProductByName(name).displayProduct();
                break;
            case 7 :
                System.out.print("Moi ban nhap id san pham de sua: ");
                id = sc.nextLine();
                fix(id);
                break;
            case 8:
                System.out.printf("Co tong cong %d mat hang trong cua hang" , getSumProductOnStore());
                break;
            case 9:
                display();
                break;
            case 10:
                System.out.print("Moi ban nhap id san pham de truy xuat du lieu: ");
                id = sc.nextLine();
                DisplayDetailProduct(findProductById(id));
                break;
            case 11:
                System.out.print("Moi ban nhap id san pham muon danh gia: ");
                id = sc.nextLine();
                Product x = findProductById(id);
                x.writeComment();
                break;
            case 12:
                System.out.print("Nhap id san pham can xem danh gia: ");
                name = sc.nextLine();
                Product y = findProductById(name);
                if(y == null){
                    System.out.println("San pham hien chua co danh gia!");
                }else
                    y.showRating();
                break;
            case 13:
                RecommendProductHighRating();
                break;
            case 14:
                System.out.print("Moi ban nhap ten san pham da danh gia: ");
                id = sc.nextLine();
                System.out.print("Ten khach hang da danh gia san pham la: ");
                name = sc.nextLine();
                updateRating(id , name);
                break;
            case 15:
                System.out.print("Moi ban nhap ten san pham da danh gia: ");
                id = sc.nextLine();
                System.out.print("Ten khach hang da danh gia san pham la: ");
                name = sc.nextLine();
                deleteRating(id , name);
                break;
            default:
                System.out.println("Nhap khong dung yeu cau vui long thu lai!!");
        }
    }

    public void sortType(){
        System.out.println("\nSap xep san pham:");
        System.out.println("0. Quay lai");
        System.out.println("1. Sap xep san pham theo gia giam dan");
        System.out.println("2. Sap xep san pham theo gia tang dan");
        System.out.println("3. Sap xep san pham theo ten A-Z");
        System.out.println("4. Sap xep san pham theo ten Z-A");
        System.out.print("Moi ban nhap lua chon : ");
        int choice = sc.nextInt();
        switch (choice){
            case 0 :
                break;
            case 1:
                sortByPriceDec();
                break;
            case 2:
                sortByPriceInc();
                break;
            case 3:
                sortByNameInc();
                break;
            case 4:
                sortByNameDec();
                break;
            default:
                System.out.println("Erorr! loi du lieu dau vao vui long kiem tra lai");
        }
    }


    //--------------------------CheckID && FixID-------------------------------------
    boolean CheckId(String s){
        if ((s.charAt(0) < 'A' || s.charAt(0) > 'Z')) {
            return false;
        }
        int cnt = 0;
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                cnt++;
            }else{
                return false;
            }
        }
        return cnt == s.length() - 1;
    }

    boolean checkSameId(String s){
        for(Product x : products){
            if(x.id.compareTo(s) == 0){
                return false;
            }
        }
        return true;
    }

    String fixId(){
        String idTmp;
        while(true){
            System.out.print("Nhap id san pham : ");
            idTmp = sc.nextLine();
            if(checkSameId(idTmp) && CheckId(idTmp)){
                return idTmp;
            }
            if(!CheckId(idTmp)){
                System.out.println("Moi ban nhap id san pham voi ki tu dau la chu hoa , con lai la so");
            }
            if(!checkSameId(idTmp)){
                System.out.println("Id nay da bi trung vui long nhap lai id khac");
            }
        }
    }

    //--------------------------FixProduct-------------------------------------

    public void fix(String id) {
        Product x = findProductById(id);
        System.out.println("1. Sua doi id san pham");
        System.out.println("2. Sua doi ten san pham");
        System.out.println("3. Sua doi hang san pham");
        System.out.println("4. Sua doi so luong san pham");
        System.out.println("5. Sua doi loai san pham");
        System.out.println("6. Sua doi loai san pham");
        System.out.println("7. Sua doi thoi gian bao hanh cua san pham");
        System.out.println("8. Sua doi seri san pham");
        System.out.println("9. Sua doi dung luong o cung cua san pham");
        System.out.println("10. Sua doi dung luong pin cua san pham");
        System.out.println("11. Sua doi chat luong hinh anh cua san pham");
        System.out.println("12. Sua doi do phan giai man hinh cua san pham");
        System.out.print("Moi ban nhap lua chon : ");
        int choice = sc.nextInt();
        switch (choice){
            case 0:
                System.out.println("Thoat chuong trinh");
                break;
            case 1:
                String rs = fixId();
                x.setId(rs);
                break;
            case 2:
                x.setName();
                break;
            case 3:
                x.setBrand();
                break;
            case 4:
                x.setQuantity();
                break;
            case 5:
                x.setTypeProduct();
                break;
            case 6:
                x.setPrice();
                break;
            case 7 :
                x.setWarrantyTime();
                break;
            case 8 :
                x.detail.setModal();
                break;
            case 9:
                x.detail.setDiskSize();
                break;
            case 10:
                x.detail.setBatteryCapacity();
                break;
            case 11:
                x.detail.setScreenQuality();
                break;
            case 12:
                x.detail.setDisplay();
                break;
        }
        System.out.println("Da sua thanh cong !!!");
    }

    //--------------------------AddProduct-------------------------------------
    public void add(){
        String idTmp = fixId();
        Product newProduct = new Product();
        newProduct.setId(idTmp);
        newProduct.setName();
        newProduct.setBrand();
        newProduct.setQuantity();
        newProduct.setTypeProduct();
        newProduct.setPrice();
        newProduct.setWarrantyTime();
        newProduct.detail.setModal();
        newProduct.detail.setDiskSize();
        newProduct.detail.setBatteryCapacity();
        newProduct.detail.setScreenQuality();
        newProduct.detail.setDisplay();
        newProduct.setReduce();
        newProduct.accessory.setCharger();
        newProduct.accessory.setEarPhone();
        products = Arrays.copyOf(products , products.length + 1);
        products[products.length - 1] = newProduct;
        quantityProduct++;
        System.out.println("San pham da dc them vao thanh cong!");
    }

    //--------------------------Delete-----------------------------------------

    public void Delete(String id){
        boolean ok = false;
        for(int i = 0 ; i < products.length ; i++){
            if(products[i].getId().equals(id)){
                while(i < products.length - 1){
                    products[i] = products[i + 1];
                    i++;
                }
                ok = true;
                break;
            }
        }
        if(ok){
            products = Arrays.copyOf(products , products.length - 1);
            System.out.println("Da xoa thanh cong san pham!");
            quantityProduct--;
        }
        else System.out.println("Khong xoa dc san pham!");
    }

    //--------------------------Sort-------------------------------------
    public void sortByPriceDec(){
        int n = products.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(products[i].price > products[j].price){
                    Product tmp = products[i];
                    products[i] = products[j];
                    products[j] = tmp;
                }
            }
        }
        System.out.println("Da sort theo gia ban theo thu tu giam dan !");
    }

    public void sortByPriceInc(){
        int n = products.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(products[i].price < products[j].price){
                    Product tmp = products[i];
                    products[i] = products[j];
                    products[j] = tmp;
                }
            }
        }
        System.out.println("Da sort theo gia ban theo thu tu tang dan !");
    }

    public void sortByNameInc(){
        int n = products.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(products[i].name.compareTo(products[j].name) > 0){
                    Product tmp = products[i];
                    products[i] = products[j];
                    products[j] = tmp;
                }
            }
        }
        System.out.println("Da sort ten theo thu tu A-Z!");
    }
    public void sortByNameDec(){
        int n = products.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(products[i].name.compareTo(products[j].name) < 0){
                    Product tmp = products[i];
                    products[i] = products[j];
                    products[j] = tmp;
                }
            }
        }
        System.out.println("Da sort ten theo thu tu Z-A!");
    }

    //--------------------------Filter & Find-------------------------------------

    public void filter(String name){
        name = name.toLowerCase();
        int n = products.length;
        boolean ok = false;
        for(int i = 0 ; i < n ;i++) {
            if (products[i].name.toLowerCase().contains(name)) {
                products[i].displayThongTinBenNgoaiSanPham();
            }
        }
        System.out.println("Da loc ra nhung san pham nhu ban yeu cau!");
    }
    public Product findProductById(String id){
        int n = products.length;
        int idx = -1;
        for(int i = 0 ; i < n ; i++){
            if(products[i].id.equals(id)){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            System.out.println("Khong tim thay san pham co id theo yeu cau!");
            return null;
        }
        return products[idx];
    }

    public Product findProductByName(String name){
        int idx = -1;
        int n = products.length;
        for(int i = 0 ; i < n; i++){
            if(products[i].getName().compareTo(name) == 0){
                idx = i;
                break;
            }
        }
        if(idx != -1){
            return products[idx];
        }
        System.out.println("Khong tim thay san pham!");
        return null;
    }


    //--------------------------GetProductOnStore-------------------------------------

    int getSumProductOnStore(){
        return quantityProduct;
    }
    //--------------------------Display-----------------------------------------------

    public void display(){
        for(int i = 0 ; i < products.length ; i++){
            System.out.printf("Thong tin san pham thu %d :" , i + 1);
            System.out.println();
            products[i].displayThongTinBenNgoaiSanPham();
        }
    }

    //--------------------------DisplayDetailProduct----------------------------------
    public void DisplayDetailProduct(Product p){
        p.detail.displayThongTinBenTrongSanPham();
    }
    //--------------------------RecommendProductHighRating----------------------------------
    public void RecommendProductHighRating(){
        int idx = -1;
        int mx = 0;
        for(int i = 0 ; i < products.length ; i++){
            int cnt = 0;
            for(int j = 0 ; j < products[i].ratingProducts.length ; j++){
                if(products[i].ratingProducts[j].getSao() >= 4){
                   cnt++;
                }
            }
            if(cnt > mx){
                mx = cnt;
                idx = i;
            }
        }
        products[idx].displayProduct();
    }

    //--------------------------UpdateRating----------------------------------
    public void updateRating(String nameProduct , String nameCustomer){
        Product x = findProductByName(nameProduct);
        if(x != null) {
            for (int i = 0; i < x.ratingProducts.length; i++) {
                if (x.ratingProducts[i].getNameProduct().equals(nameCustomer)) {
                    for(int j = i ; j < x.ratingProducts.length ; j++){
                        if(j + 1 < x.ratingProducts.length){
                            x.ratingProducts[i] = x.ratingProducts[j + 1];
                        }
                    }
                    x.ratingProducts = Arrays.copyOf(x.ratingProducts , x.ratingProducts.length - 1);
                    x.writeComment();
                    System.out.println("Da sua thanh cong!");
                    return;
                }
            }
        }
        System.out.println("Sua khong thanh cong!");
    }

    //--------------------------DeleteRating----------------------------------
    public void deleteRating(String nameProduct , String nameCustomer){
        Product x = findProductByName(nameProduct);
        for(int i = 0 ; i < x.ratingProducts.length ; i++){
            if(x.ratingProducts[i].getNameProduct().equals(nameCustomer)){
                for(int j = i ; j < x.ratingProducts.length ; j++){
                    if(j + 1 < x.ratingProducts.length){
                        x.ratingProducts[i] = x.ratingProducts[j + 1];
                    }
                }
                x.ratingProducts = Arrays.copyOf(x.ratingProducts , x.ratingProducts.length - 1);
                System.out.println("Da xoa thanh cong!");
                return;
            }
        }
        System.out.println("Khong xoa duoc san pham!");
    }
}
