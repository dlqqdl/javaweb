package vo;

import java.util.Date;

/**
 * 会议实体
 */
public class Meeting {
    private int meet_id;//会议id
    private int organizer_id;//组织者id
    private String topic;//会议主题
    private int attend_num;//参会人数
    private Date start_time;//会议开始时间
    private Date end_time;//会议结束时间
    private String address;//会址

    public Meeting() {
    }
    public Meeting(int meet_id, int organizer_id, String topic, int attend_num,
                   String start_time, String end_time, String address) {
        this.meet_id = meet_id;
        this.organizer_id = organizer_id;
        this.topic = topic;
        this.attend_num = attend_num;
        this.start_time = new Date(start_time);
        this.end_time = new Date(end_time);
        this.address = address;
    }
    public Meeting(int meet_id, int organizer_id, String topic, int attend_num,
                   Date start_time, Date end_time, String address) {
        this.meet_id = meet_id;
        this.organizer_id = organizer_id;
        this.topic = topic;
        this.attend_num = attend_num;
        this.start_time = start_time;
        this.end_time = end_time;
        this.address = address;
    }

    public int getMeet_id() {
        return meet_id;
    }

    public void setMeet_id(int meet_id) {
        this.meet_id = meet_id;
    }

    public int getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(int organizer_id) {
        this.organizer_id = organizer_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getAttend_num() {
        return attend_num;
    }

    public void setAttend_num(int attend_num) {
        this.attend_num = attend_num;
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
