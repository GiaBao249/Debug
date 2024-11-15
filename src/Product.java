import java.util.Arrays;

public class Product extends Transaction{
    protected String id , name , brand ;
    TypeProduct typeProduct;
    protected double price;
    private int quantity;
    private int warrantyTime;
    protected RatingProduct[] ratingProducts;
    private double reduce;
    detailProduct detail;
    Accessory accessory;
    IOStream sc;
    public Product(){
        detail = new detailProduct();
        accessory = new Accessory();
        sc = new IOStream();
        ratingProducts = new RatingProduct[0];
    }

    //----------------------------Set-----------------------------------

    public void setId(String id){
        this.id = id;
    }

    public void setBrand() {
        System.out.print("Nhap hang cua san pham : ");
        brand = sc.nextLine();
        while(brand == null){
            System.out.println("Error! K dc de trong");
            brand = sc.nextLine();
        }
    }

    public void setName() {
        System.out.print("Nhap ten san pham : ");
        name = sc.nextLine();
        while(name == null){
            System.out.println("Error! K dc de trong");
            name = sc.nextLine();
        }
    }

    public void setPrice() {
        System.out.print("Nhap gia san pham : ");
        double tmpPrice = sc.nextDouble();
        while(tmpPrice < 0){
            System.out.print("Vui long nhap gia tien > 0 : ");
            tmpPrice = sc.nextDouble();
        }
        price = tmpPrice;
    }

    public void setQuantity() {
        System.out.print("Nhap so luong san pham : ");
        int tmpQuantity = sc.nextInt();
        while(tmpQuantity < 0){
            System.out.println("Vui long nhap so luong san pham > 0");
            tmpQuantity = sc.nextInt();
        }
        quantity = tmpQuantity;
    }

    public void setTypeProduct() {
        typeProduct = new TypeProduct();
        typeProduct.setType();
    }

    public void setWarrantyTime() {
        System.out.print("Moi ban nhap thoi gian bao hanh (don vi thang): ");
        int tmp = sc.nextInt();
        while(tmp < 0){
            System.out.println("Vui long nhap thoi gian bao hanh > 0 (don vi la thang)");
            tmp = sc.nextInt();
        }
        warrantyTime = tmp;
    }

    public void setReduce() {
        System.out.println("San pham nay co uu dai hay khong?: ");
        System.out.println("1. Co");
        System.out.println("2. Khong");
        System.out.print("Nhap lua chon : ");
        int choice = sc.nextInt();
        if(choice == 1){
            System.out.printf("Moi nhap uu dai cua san pham %s:" , getName());
            this.reduce = sc.nextDouble();
        }else{
            this.reduce = 1;
        }
    }

    //-------------------------Get--------------------------------------

    public boolean checkQuantityProduct(){
        return quantity > 0;
    }

    public String getTypeProduct() {
        return typeProduct.getType();
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWarrantyTime() {
        return warrantyTime;
    }

    public String getName() {
        return name;
    }

    public double getReduce() {
        return reduce;
    }

    //----------------------------ProductList------------------------------------

    public void table(){
        System.out.printf("%-25s%-25s%-25s%-25s%-25s%-25s%-25s", "Ma san pham", "Ten san pham" , "Hang cua san pham" , "Loai san pham"
        , "Gia san pham" , "So luong san pham" , "Thoi gian bao hanh");
    }

    public void displayThongTinBenNgoaiSanPham(){
        table();
        System.out.println();
        System.out.printf("%-25s%-25s%-25s%-25s%-25s%-25d%-25d", id, name, brand, typeProduct.getType() , convertMoney(price) , quantity , warrantyTime);
        System.out.println();
    }

    public String convertMoney(double price){
        long roundedPrice = Math.round(price);
        String s = Double.toString(price);
        int cnt = 0;
        String reverse = "";
        for(int i = s.length() - 1; i >= 0; i--){
            reverse += s.charAt(i);
            cnt++;
            if(cnt % 3 == 0 && i != 0){
                reverse += '.';
            }
        }
        String ans = "";
        for(int i = reverse.length() - 1 ; i >= 0 ; i--){
            ans += reverse.charAt(i);
        }
        return ans + "đ";
    }

    public void displayProduct(){
        System.out.println("Id san pham : " + getId());
        System.out.println("Ten san pham : " + getName());
        System.out.println("Hang san pham : " + getBrand());
        System.out.println("Loai san pham : " + getTypeProduct());
        System.out.println("Gia san pham : " + convertMoney(getPrice()));
        System.out.println("So luong san pham : " + getQuantity());
        System.out.println(("Thoi gian bao hanh : " + getWarrantyTime() + " thang"));
    }


    public void displayInsideProduct(){
        System.out.println("Modal san pham : " + detail.getModal());
        System.out.println("Dung luong san pham : " + detail.getDiskSize() + "Gb");
        System.out.println("Dung luong pin san pham : " + detail.getBatteryCapacity() + "W");
        System.out.println("Chat luong man hinh : " + detail.getScreenQuality() + "HD");
        System.out.println("Do phan giai man hinh : " + detail.getDisplay());
    }

    //---------------------------------Rating-------------------------------------------

    public boolean CheckName(String name){
        int n = ratingProducts.length;
        for(int i = 0 ; i < n; i++){
            if(ratingProducts[i].getNameProduct().equals((name))){
                return false;
            }
        }
        return true;
    }

    public String setNameRating() {
        String s = sc.nextLine();
        while(!CheckName(s)){
            System.out.println("Ten nay da co nguoi nhap roi vui long chon ten khac : ");
            s = sc.nextLine();
        }
        return s;
    }

    public void writeComment(){
        RatingProduct x = new RatingProduct();
        System.out.print("Ten khach hang danh gia san pham : ");
        x.setNameProduct(setNameRating());
        x.day = new Ngay();
        System.out.print("Danh gia so sao cho san pham : ");
        x.setSao();
        System.out.print("Ghi comment cho san pham : ");
        x.setComment();
        ratingProducts = Arrays.copyOf(ratingProducts , ratingProducts.length + 1);
        ratingProducts[ratingProducts.length - 1] = x;
    }

    public void showRating(){
        boolean ok = false;
        System.out.printf("Cac danh gia cua san pham %s\n" , name);
        for(RatingProduct x : ratingProducts){
            x.displayRating();
            System.out.println();
            ok = true;
        }
        if(!ok){
            System.out.println("San pham hien khong co danh gia!");
        }
    }

    //----------------------------------Accessory----------------------------------------

    public void ShowAccessory() {
        if(accessory.charger && accessory.earPhone){
            System.out.println("Phu kien di kem : Tai nghe + Cuc sac");
        }else if(accessory.earPhone){
            System.out.println("Phu kien di kem : Tai nghe");
        }else if(accessory.charger){
            System.out.println("Phu kien di kem : Cuc sac");
        } else{
            System.out.println("San pham khong co phu kien di kem!");
        }
        System.out.println();
    }
    //----------------------------------ApplyPromotion----------------------------------------
    @Override
    public double ApplyPromotion() {
        return getReduce();
    }
}
