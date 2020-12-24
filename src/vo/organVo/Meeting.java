package vo.organVo;

import java.sql.Date;
import java.time.LocalDateTime;

public class Meeting {
    private Integer meet_id;
    private Integer organ_id;
    private String topic;
    private Integer num_att;
//    private LocalDateTime start_time;
//    private LocalDateTime end_time;
    private Date start_time;
    private Date end_time;
    private String address;

    public Meeting() {
    }

    public Meeting(Integer meet_id, Integer organ_id, String topic, Integer num_att, Date start_time, Date end_time, String address) {
        this.meet_id = meet_id;
        this.organ_id = organ_id;
        this.topic = topic;
        this.num_att = num_att;
        this.start_time = start_time;
        this.end_time = end_time;
        this.address = address;
    }


    public Integer getMeet_id() {
        return meet_id;
    }

    public void setMeet_id(Integer meet_id) {
        this.meet_id = meet_id;
    }

    public Integer getOrgan_id() {
        return organ_id;
    }

    public void setOrgan_id(Integer organ_id) {
        this.organ_id = organ_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getNum_att() {
        return num_att;
    }

    public void setNum_att(Integer num_att) {
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
