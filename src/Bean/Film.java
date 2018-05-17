package Bean;

/**
 * 电影类
 *
 */

public class Film {
    private String flimID;          //电影编号
    private String filmName;        //电影名称
    private String publishYear;     //发行年份
    private String publishFirm;     //发行公司
    private String length;          //电影时长
    private String[] category;      //电影类别
    private Person[] director;      //导演
    private Person[] actor;         //演员
    private Person[] voice;         //旁白
    private String plot;            //电影情节

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
