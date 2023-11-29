package CMS.FIR;

import java.sql.Date;
import java.sql.Time;

import CMS.DBHandler.FIRHandler;

public class FIR {

    private int FIR_ID;
    private String date;
    private String time;
    private String location;
    private String description;
    private String status;
    private String evidence;
    private int crime_id;

    FIRHandler firHandler = new FIRHandler();

    public int getFIR_ID() {
        return FIR_ID;
    }

    public void setFIR_ID(int FIR_ID) {
        this.FIR_ID = FIR_ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public int getCrime_id() {
        return crime_id;
    }

    public void setCrime_id(int crime_id) {
        this.crime_id = crime_id;
    }


    public void addFIR(Date sqlDate, Time time, String location, String description, String evidence, int crime_id, int user_id){
        firHandler.insertFIR(sqlDate, time, location, description, evidence, crime_id, user_id);
    }

    // public void addFIR(Date sqlDate, String crime, String tfloc, String desc, String tfstat, String evidence2,int crime_id2) {
        
    // }
}

