package vo.organVo;

public class Attendmeeting {
    private Integer meet_id;
    private Integer conf_id;

    public Attendmeeting() {
    }

    public Attendmeeting(Integer meet_id, Integer conf_id) {
        this.meet_id = meet_id;
        this.conf_id = conf_id;
    }

    public Integer getMeet_id() {
        return meet_id;
    }

    public void setMeet_id(Integer meet_id) {
        this.meet_id = meet_id;
    }

    public Integer getConf_id() {
        return conf_id;
    }

    public void setConf_id(Integer conf_id) {
        this.conf_id = conf_id;
    }
}
