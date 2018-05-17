package Bean;

public class Film {
    private String flimID;
    private String filmName;
    private String publishYear;
    private String publishFirm;
    private String length;
    private String[] category;
    private Person[] director;
    private Person[] actor;
    private Person[] voice;
    private String plot;

    public String getFlimID() {
        return flimID;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public String getPublishFirm() {
        return publishFirm;
    }

    public String getLength() {
        return length;
    }

    public String[] getCategory() {
        return category;
    }

    public Person[] getDirector() {
        return director;
    }

    public Person[] getActor() {
        return actor;
    }

    public Person[] getVoice() {
        return voice;
    }

    public String getPlot() {
        return plot;
    }
}
