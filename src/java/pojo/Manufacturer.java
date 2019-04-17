package pojo;
// Generated 15-Apr-2019 5:00:11 PM by Hibernate Tools 4.3.1



/**
 * Manufacturer generated by hbm2java
 */
public class Manufacturer  implements java.io.Serializable {


     private int manufacturerId;
     private String name;
     private String addressline1;
     private String addressline2;
     private String city;
     private String state;
     private String zip;
     private String phone;
     private String fax;
     private String email;
     private String rep;

    public Manufacturer() {
    }

	
    public Manufacturer(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
    public Manufacturer(int manufacturerId, String name, String addressline1, String addressline2, String city, String state, String zip, String phone, String fax, String email, String rep) {
       this.manufacturerId = manufacturerId;
       this.name = name;
       this.addressline1 = addressline1;
       this.addressline2 = addressline2;
       this.city = city;
       this.state = state;
       this.zip = zip;
       this.phone = phone;
       this.fax = fax;
       this.email = email;
       this.rep = rep;
    }
   
    public int getManufacturerId() {
        return this.manufacturerId;
    }
    
    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getAddressline1() {
        return this.addressline1;
    }
    
    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }
    public String getAddressline2() {
        return this.addressline2;
    }
    
    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return this.zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRep() {
        return this.rep;
    }
    
    public void setRep(String rep) {
        this.rep = rep;
    }




}

