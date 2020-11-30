package dao;

import vo.Conferee;

import java.util.List;

public interface confereeDao {
    /**
     * 在注册表中加入一个用户
     * @param conferee
     * @return
     */
    public boolean addAUser(Conferee conferee);
    /**
     * 注销一个用户（在注册表中删除）
     * @param conferee
     * @return
     */
    public boolean deleteThisUser(Conferee conferee);

    /**
     * 升级该用户的权限（加入到会议组织者表中）
     * @param conferee
     * @return
     */
    public boolean upGradeToOrganizer(Conferee conferee);

    /**
     * 显示所有用户
     * @return
     */
    public List<Conferee> showAllUser();
}
