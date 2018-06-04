package Bean;

/**
 * 电影类
 *
 */

public class Film {
    private String filmID;          //电影编号
    private String filmName;        //电影名称
    private String publishYear;     //发行年份
    private String publishFirm;     //发行公司
    private String firmID;          //发行公司ID
    private String length;          //电影时长
    private String[] category;      //电影类别
    private Person[] director;      //导演
    private Person[] actor;         //演员
    private Person[] voice;         //旁白
    private String plot;            //电影情节


    public Film(String filmID, String filmName, String publishYear, String publishFirm, String length, String[] category, Person[] director,
                Person[] actor, Person[] voice, String plot){
        this.filmID = filmID;
        this.filmName = filmName;
        this.publishYear = publishYear;
        this.publishFirm = publishFirm;
        this.length = length;
        this.category = category;
        this.director = director;
        this.actor = actor;
        this.voice = voice;
        this.plot = plot;
    }

    public String getFlimID() {
        return filmID;
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
