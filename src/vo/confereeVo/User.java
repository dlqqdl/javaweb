package vo.confereeVo;

public class User {
    private int conf_id;
    private String name;
    private int account;
    private String password;
    private int tel;
    private String sex;
    private String email;
    private String description;

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

//    public User(int conf_id, String name, int account, String password, int tel, String sex, String email, String description) {
//        this.conf_id = conf_id;
//        this.name = name;
//        this.account = account;
//        this.password = password;
//        this.tel = tel;
//        this.sex = sex;
//        this.email = email;
//        this.description = description;
//    }


    public User(int conf_id, String name, int account, String password, int tel, String sex, String email, String description) {
        this.conf_id = conf_id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.tel = tel;
        this.sex = sex;
        this.email = email;
        this.description = description;
    }

    public User(String name, String password, int tel, String sex, String email) {
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.sex = sex;
        this.email = email;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }
}
