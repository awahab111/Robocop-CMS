package CMS.FIR;

import CMS.DBHandler.CrimeDescriptionHandler;

public class CrimeDescription {
    private int crimeDescription_ID;
    private String crimetype;
    private String punishment;

    CrimeDescriptionHandler crimeDescription_h = new CrimeDescriptionHandler();

    public int getCrimeDescription_ID() {
        return crimeDescription_ID;
    }

    public void setCrimeDescription_ID(int crimeDescription_ID) {
        this.crimeDescription_ID = crimeDescription_ID;
    }

    public String getCrimetype() {
        return crimetype;
    }

    public void setCrimetype(String crimetype) {
        this.crimetype = crimetype;
    }

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }

    public int getCrimeDescription_ID(String crimeDescription) {

        return crimeDescription_h.getCrimeID(crimeDescription);
    }
}