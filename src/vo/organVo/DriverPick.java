package vo.organVo;

import java.sql.Date;

/**
 * @Author ExilePluto
 * @Date 2020/12/22
 */
public class DriverPick {
//    conferee.conf_id,conferee.`name`,conferee.tel,conferee.sex,pick.driver_id,pick.pick_time,pick.leave_time
    private int conf_id;
    private String name;
    private int tel;
    private String sex;
    private int id;
    private Date ptime;
    private Date ltime;

    public DriverPick(int conf_id, String name, int tel, String sex, int id, Date ptime, Date ltime) {
        this.conf_id = conf_id;
        this.name = name;
        this.tel = tel;
        this.sex = sex;
        this.id = id;
        this.ptime = ptime;
        this.ltime = ltime;
    }

    public int getConf_id() {
        return conf_id;
    }

    public void setConf_id(int conf_id) {
        this.conf_id = conf_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public Date getLtime() {
        return ltime;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }
}
