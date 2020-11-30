package dao;

import vo.Admin;

/**
 * 对系统管理员的操作
 */
public interface adminDao {
    /**
     * 注册系统管理员
     * @param admin
     * @return
     */
    public boolean addNewAdministrator(Admin admin);

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
    public boolean checkIsAdministrator(Admin admin);

    /**
     * 修改信息
     * @param admin
     * @return
     */
    public boolean modifyAdminInfo(Admin admin);
}
