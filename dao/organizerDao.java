package dao;

import vo.Organizer;

import java.util.List;

public interface organizerDao {
    /**
     * 注销一个组织者用户
     * @param organizer
     * @return
     */
    public boolean deleteOrganizer(Organizer organizer);

    /**
     * 增加一个组织者用户
     * @param organizer
     * @return
     */
    public boolean addOneOrganizer(Organizer organizer);

    /**
     * 查看所有组织者
     * @return
     */
    public List<Organizer> showAllOrganizer();
}
