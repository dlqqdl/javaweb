package dao.administratorDao;

import vo.administratorVo.Admin;

import java.util.List;

/**
 * 对系统管理员的操作
 */
public interface adminDao {
    /**
     * 注册系统管理员
     * @param admin
     * @return
     */
    public Admin addNewAdministrator(Admin admin);

    /**
     * 注销系统管理员
     * @param admin
     * @return
     */
    public boolean deleteOneAdministrator(Admin admin);

    /**
     * 登录
     * @param admin
     * @return
     */
    public Admin checkIsAdministrator(Admin admin);

    /**
     * 修改密码
     * @param admin
     * @return
     */
    public boolean modifyPassword(Admin admin);

    /**
     *
     * @return
     */
    public List<Admin> showAllAdmin();

    /**
     *
     * @return
     */
    public List<Admin> showAdmin(int id);
}
