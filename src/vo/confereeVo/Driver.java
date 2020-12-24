package vo.confereeVo;

import java.util.Date;

public class Driver {
    private int driver_id;
    private int telephone;
    private String name;

    private Date pick_time;
    private Date leave_time;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Date getPick_time() {
        return pick_time;
    }

    public void setPick_time(Date pick_time) {
        this.pick_time = pick_time;
    }

    public Date getLeave_time() {
        return leave_time;
    }

    public void setLeave_time(Date leave_time) {
        this.leave_time = leave_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDirver_id() {
        return driver_id;
    }

    public void setDirver_id(int dirver_id) {
        this.driver_id = dirver_id;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
