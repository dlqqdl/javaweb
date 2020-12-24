package vo.organVo;

public class Conferee {
    private Integer conf_id;
    private String name;
    private Integer account;
    private String password;
    private Integer tel;
    private String sex;
    private String email;
    private String description;

    public Conferee() {
    }

    public Conferee(Integer conf_id, String name, Integer account, String password, Integer tel, String sex, String email, String description) {
        this.conf_id = conf_id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.tel = tel;
        this.sex = sex;
        this.email = email;
        this.description = description;
    }

    public Conferee(Integer conf_id, String name, Integer tel, String email) {
        this.conf_id = conf_id;
        this.name = name;
        this.tel = tel;
        this.email = email;
    }

    public Integer getConf_id() {
        return conf_id;
    }

    public void setConf_id(Integer conf_id) {
        this.conf_id = conf_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
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

    @Override
    public String toString() {
        return "conferee{" +
                "conf_id=" + conf_id +
                ", name='" + name + '\'' +
                ", account=" + account +
                ", password='" + password + '\'' +
                ", tel=" + tel +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
