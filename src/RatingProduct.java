public class RatingProduct {
    IOStream sc = new IOStream();
    String name;
    double sao;
    String comment;
    Ngay day = null;

    public void setSao() {
        double x = sc.nextDouble();
        while(x < 1 || x > 5){
            System.out.println("Vui long nhap so sao >= 1 va <= 5 : ");
            x = sc.nextDouble();
        }
        sao = x;
    }

    public double getSao() {
        return sao;
    }

    public String getComment() {
        return comment;
    }

    public void setComment() {
        this.comment = sc.nextLine();
    }

    public void setNameProduct(String name) {this.name = name;}

    public String getNameProduct() {return name;}

    public void displayRating() {
        System.out.println("Khach hang " + getNameProduct() + " da binh luan vao ngay : " + day.getNgay());
        System.out.printf("%-25s%-25s\n", "So sao", "Binh luan");
        System.out.printf("%-25.2f%-25s\n", sao, comment);
    }
}
