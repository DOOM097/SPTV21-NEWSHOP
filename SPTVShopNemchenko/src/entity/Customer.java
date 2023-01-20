package entity;



public class Customer {
    private String name;
    private String lastName;
    private String phone;
//    ---------------------------------------------

    public Customer() {
        
    }

    public Customer(String name, String lastName, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" 
                + "name=" + name 
                + ", lastName=" + lastName 
                + ", phone=" + phone 
                + '}';
    }
    
    
}
