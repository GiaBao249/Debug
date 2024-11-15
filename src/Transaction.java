import java.util.Arrays;

public abstract class Transaction{
    Product[] transactionProduct = new Product[0];
    private Ngay productBuyDay;
    ListProducts list = ListProducts.getInstance();
    IOStream sc;
    Transaction(){
        sc = new IOStream();
    }

    public Product findProductInTransactionById(String productId) {
        for (Product p : transactionProduct) {
            if (p.getId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    public void AddProductBuy(String productId) {
        Product p = list.findProductById(productId);
        if (p != null) {
            transactionProduct = Arrays.copyOf(transactionProduct, transactionProduct.length + 1);
            transactionProduct[transactionProduct.length - 1] = p;
            System.out.println("Da them san pham " + p.getName() + " vao gio hang.");
        }else{
            System.out.println("Khong tim thay san pham!");
        }
    }

    public void DeleteProductBuy(String productId) {
        Product p = findProductInTransactionById(productId);
        if (p != null) {
            for (int i = 0; i < transactionProduct.length; i++) {
                if (transactionProduct[i].getId().equals(productId)) {
                    for (int j = i; j < transactionProduct.length - 1; j++) {
                        transactionProduct[j] = transactionProduct[j + 1];
                    }
                    transactionProduct = Arrays.copyOf(transactionProduct, transactionProduct.length - 1);
                    System.out.println("Da xoa san pham " + p.getName() + " khoi gio hang.");
                    return;
                }
            }
        }
    }

    public double GetPriceProduct(){
        double ans = 0;
        for (int i = 0 ; i < transactionProduct.length ; i++){
            ans += (transactionProduct[i].getPrice() * transactionProduct[i].getQuantity() * ApplyPromotion());
        }
        return ans;
    }

    public abstract double ApplyPromotion();

    //----------------------------------Day----------------------------------------

    public void setProductBuyDay(){
        productBuyDay = new Ngay();
    }

    public void getProductBuyDay(){
        productBuyDay.getNgay();
    }

    public String EndWarrantyTime(Product p){
        int end_dd = productBuyDay.getDd();
        int end_mm = productBuyDay.getMm();
        int end_yy = productBuyDay.getYyyy();
        int n = p.getWarrantyTime();
        int cnt = 0;
        while(n > 12){
            n -= 12;
            cnt++;
        }
        if(n > 0){
            end_mm += n;
            if(end_mm > 12){
                end_mm -= 12;
                cnt++;
            }
        }
        end_yy += cnt;
        return String.format("%02d/%02d/%d", end_dd, end_mm, end_yy);
    }
    //----------------------------------Thao tac mua hang----------------------------------------
    public void menuBuy(){
        System.out.println("1. Mua san pham");
        System.out.println("2. Hoan tac san pham");
        System.out.println("3. Xem chi tiet san pham");
        System.out.println("4. Thanh toan");
        System.out.println("5. Ket thuc");
        System.out.print("Moi ban nhap lua chon: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1 :
                System.out.print("Moi ban nhap id de lua chon san pham: ");
                String id_2 = sc.nextLine();
                AddProductBuy(id_2);
                break;
            case 2:
                System.out.println("Hien tai ban dang nhung san pham nay trong gio hang!");
                for(int i = 0 ; i < transactionProduct.length; i++){
                    transactionProduct[i].displayThongTinBenNgoaiSanPham();
                }
                System.out.print("Vui long chon id hoac name de hoan tac san pham: ");
                String id = sc.nextLine();
                DeleteProductBuy(id);
                break;
            case 3:
                System.out.println("Day la nhung san pham ban co y dinh mua!");
                for(int i = 0 ; i < transactionProduct.length; i++){
                    transactionProduct[i].displayThongTinBenNgoaiSanPham();
                }
                System.out.println("Ban co muon show them thong tin ben trong cua san pham nao khong ?");
                System.out.println("1. Co.");
                System.out.println("2. Khong.");
                System.out.print("Nhap lua chon: ");
                int c = sc.nextInt();
                if(c == 1){
                    System.out.println("Nhap id hien dang co trong gio hang");
                    String id_1 = sc.nextLine();
                    Product x = findProductInTransactionById(id_1);
                    if(x == null){
                        System.out.println("Khong co id nao nhu ban nhap!");
                        return;
                    }else{
                        x.displayInsideProduct();
                    }
                }else{
                    return;
                }
            case 4:
                System.out.println("Tong gia tri san pham cua ban la: " + GetPriceProduct());
                break;
            default:
                System.out.println("Thoat");
                break;
        }
    }
}
