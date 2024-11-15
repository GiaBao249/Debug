public abstract class Staff {
    private String name, idCitizen, id, address, hometown, phone, email;
    private Ngay birthday, startDate;
    private GioiTinh gender;
    private String position;
    private double salary_bonus, salary_fine;
    IOStream sc = new IOStream();

    public Staff() {
        setName();
        setIdCitizen();
        setAddress();
        setHometown();
        setPhone();
        setEmail();
        setBirthday();
        setStartDate();
        setGender();
        setPosition();
        setSalary_bonus();
        setSalary_fine();
    }
    // GET
    public String getName() {
        return name;
    }
    public String getIdCitizen() {
        return idCitizen;
    }
    public String getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getHometown() {
        return hometown;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getBirthday() {
        return birthday.getNgay();
    }
    public String getStartDate() {
        return startDate.getNgay();
    }
    public String getGender() {
        return gender.getGender();
    }
    public double getSalary_bonus() {
        return salary_bonus;
    }
    public double getSalary_fine() {
        return salary_fine;
    }
    public String getPosition() {
        return position;
    }

    // SET
    public void setName() {
        System.out.print("Nhap ho va ten: ");
        this.name = sc.nextLine();
    }

    public void setIdCitizen() {
        System.out.print("Nhap can cuoc cong dan: ");
        this.idCitizen = sc.nextLine();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress() {
        System.out.print("Nhap dia chi: ");
        this.address = sc.nextLine();
    }

    public void setHometown() {
        System.out.print("Nhap que quan: ");
        this.hometown = sc.nextLine();
    }

    public void setPhone() {
        System.out.print("Nhap so dien thoai: ");
        this.phone = sc.nextLine();
    }

    public void setEmail() {
        System.out.print("Nhap email: ");
        this.email = sc.nextLine();
    }

    public void setBirthday() {
        System.out.println("Nhap thong tin ngay sinh: ");
        birthday = new Ngay();
    }

    public void setStartDate() {
        System.out.println("Nhap thong tin ngay bat dau: ");
        startDate = new Ngay();
    }

    public void setGender() {
        gender = new GioiTinh();
    }
    //--------------------------------------------------------Chinh lai-----------------------------------------------------------------------------------------------------------------
    public void setPosition() {
        System.out.print("Nhap chuc vu: ");
        this.position = sc.nextLine();
    }
    public void setSalary_bonus() {
        System.out.print("Nhap luong thuong: ");
        salary_bonus = sc.nextDouble();
        while(salary_bonus < 0){
            System.out.print("Nhap lai gia tri khong am: ");
            salary_bonus = sc.nextDouble();
        }

    }
    public void setSalary_fine() {
        System.out.print("Nhap luong phat: ");
        salary_fine = sc.nextDouble();
        while(salary_fine < 0){
            System.out.print("Nhap lai gia tri khong am: ");
            salary_fine = sc.nextDouble();
        }
    }

    public void xuat(){
        System.out.printf("%-10s%-20s%-15s%-10s%-15s%-20.2f%-15s%s\n",id,name,getBirthday(),getGender(),position,tinhTongLuong(),phone,email);
    }
    /////////////////////////////////////////
    public void displayDetail(){
        System.out.println("Thong tin chi tiet cua nhan vien");
        System.out.println("Ho va ten: " + getName());
        System.out.println("CCCD: " + getIdCitizen());
        System.out.println("Ma nhan vien: " + getId());
        System.out.println("Dia chi: " + getAddress());
        System.out.println("Que quan: " + getHometown());
        System.out.println("So dien thoai: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Ngay sinh: " + getBirthday());
        System.out.println("Ngay bat dau: " + getStartDate());
        System.out.println("Gioi tinh: " + getGender());
        System.out.println("Chuc vu: " + getPosition());
        System.out.printf("Luong thuong: %.2f\n",getSalary_bonus());
        System.out.printf("Luong phat: %.2f\n",getSalary_fine());
    }
    public abstract double tinhTongLuong();
}
