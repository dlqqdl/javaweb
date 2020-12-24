package vo.driverVo;

import java.sql.Timestamp;
import java.util.Date;

public class Pick {
//    conf_id              int not null,
//    driver_id            int not null,
//    pick_time            datetime,
//    leave_time           datetime,
//    description          varchar(255),
//    driver_confirm       tinyint,
//    conferee_confirm     tinyint,
    private int conf_id;
    private int driver_id;
    private String pick_time;
    private String leave_time;
    private String description;
    private boolean driver_confirm;
    private boolean conferee_confirm;

    public Pick() {
    }

    public int getConf_id() {
        return conf_id;
    }

    public void setConf_id(int conf_id) {
        this.conf_id = conf_id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getPick_time() {
        return pick_time;
    }

    public void setPick_time(String pick_time) {
        this.pick_time = pick_time;
    }

    public String getLeave_time() {
        return leave_time;
    }

    public void setLeave_time(String leave_time) {
        this.leave_time = leave_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDriver_confirm() {
        return driver_confirm;
    }

    public void setDriver_confirm(boolean driver_confirm) {
        this.driver_confirm = driver_confirm;
    }

    public boolean isConferee_confirm() {
        return conferee_confirm;
    }

    public void setConferee_confirm(boolean conferee_confirm) {
        this.conferee_confirm = conferee_confirm;
    }
}
