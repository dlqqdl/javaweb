package dao.administratorDao;

import vo.administratorVo.Organizer;

import java.util.List;

public interface organizerDao {
    /**
     * 注销一个组织者用户
     * @param
     * @return
     */
    public boolean deleteOrganizer(int id);

    /***
     *
     * @param organizer
     * @return
     */
    public boolean addOneOrganizer(Organizer organizer);

    /**
     * 查看所有组织者
     * @return
     */
    public List<Organizer> showAllOrganizer();

    /**
     * 查看某些会务组织者
     * @return
     */
    public List<Organizer> showOrganizer(int id);
}
