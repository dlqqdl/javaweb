package vo.administratorVo;

/**
 * 参会人员实体
 */
public class Conferee {
    private int conf_id;//参会者id
    private String conf_name;//参会者名单
    private int account;//参会者的系统账户
    private String password;//参会者密码
    private int tel;//参会者电话
    private String sex;//参会者性别
    private String email;//参会者email
    private String description;//参会者其他信息

    public Conferee() {
    }
    public Conferee(String conf_name, int account, String password) {
        this.conf_name = conf_name;
        this.account = account;
        this.password = password;
    }
    public Conferee(int conf_id, String conf_name, int account,
                    String password, int tel, String sex, String email) {
        this.conf_id = conf_id;
        this.conf_name = conf_name;
        this.account = account;
        this.password = password;
        this.tel = tel;
        this.sex = sex;
        this.email = email;
    }

    public Conferee(int conf_id, String conf_name, int account, String password,
                    int tel, String sex, String email, String description) {
        this.conf_id = conf_id;
        this.conf_name = conf_name;
        this.account = account;
        this.password = password;
        this.tel = tel;
        this.sex = sex;
        this.email = email;
        this.description = description;
    }

    public int getConf_id() {
        return conf_id;
    }

    public void setConf_id(int conf_id) {
        this.conf_id = conf_id;
    }

    public String getConf_name() {
        return conf_name;
    }

    public void setConf_name(String conf_name) {
        this.conf_name = conf_name;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
