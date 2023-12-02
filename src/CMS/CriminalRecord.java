package CMS;

import java.util.ArrayList;

public class CriminalRecord {
    private int criminal_id;
    private String name;
    private String fatherName;
    private String birthplace;
    private String address;
    private String cnic;

    ArrayList<String> crimes = new ArrayList<String>();

    public int getCriminal_id() {
        return criminal_id;
    }

    public void setCriminal_id(int criminal_id) {
        this.criminal_id = criminal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    
    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public ArrayList<String> getCrimes() {
        return crimes;
    }

    public void setCrimes(ArrayList<String> crimes) {
        this.crimes = crimes;
    }

    public void setCrimes(String text) {
        this.crimes.add(text);
    }

    public void insertCriminalRecord() {
        
    }
}