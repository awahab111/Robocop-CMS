package CMS.FIR;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import DBHandler.FIRHandler;

public class FIR {

    private int FIR_ID;
    private String date;
    private String time;
    private String location;
    private String description;
    private Boolean status;
    private String evidence;
    private int crime_id;
    private String crime_desc;
    private String report;

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getCrime_desc() {
        return crime_desc;
    }

    public void setCrime_desc(String crime_desc) {
        this.crime_desc = crime_desc;
    }
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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


    public void addFIR(String location, String description, String evidence, String crime, int user_id){

        CrimeDescription cd = new CrimeDescription();
        int crime_id = cd.getCrimeDescription_ID(crime);

        java.util.Date currentDate = new java.util.Date();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(currentDate);
        java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);

        // Create a time variable with the current time
        java.sql.Time sqlTime = new java.sql.Time(currentDate.getTime());
        firHandler.insertFIR(sqlDate, sqlTime, location, description, evidence, crime_id, user_id);
    }

}

