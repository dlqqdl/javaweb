package vo.confereeVo;

import java.util.Date;

public class Meeting {
    private int meet_id;
    private int organ_id;
    private String topic;
    private int num_att;
    private Date start_time;
    private Date end_time;
    private String address;

    public int getMeet_id() {
        return meet_id;
    }

    public void setMeet_id(int meet_id) {
        this.meet_id = meet_id;
    }

    public int getOrgan_id() {
        return organ_id;
    }

    public void setOrgan_id(int organ_id) {
        this.organ_id = organ_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getNum_att() {
        return num_att;
    }

    public void setNum_att(int num_att) {
        this.num_att = num_att;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
