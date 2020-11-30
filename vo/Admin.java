package vo;

/**
 * 系统管理员
 */
public class Admin {
    private int admin_id;//账号
    private String admin_name;//用户名
    private int telephone;//联系电话
    private String password;//密码

    public Admin() {}
    public Admin(int admin_id, String admin_name, String password) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.password = password;
    }
    public Admin(int admin_id, String admin_name, int telephone, String password) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.telephone = telephone;
        this.password = password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
