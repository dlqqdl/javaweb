package dao.hotelDao;

import util.Constants;
import vo.hotelVo.Hotel;
import vo.hotelVo.Living;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Timgreat
 * @date 2020/11/23 - 22:12
 */
public interface HotelDao {
    //得到当前登录用户
    public Hotel getLoginHotel(Connection connection, String name);
    //修改用户密码
    public int updatePwd(Connection connection,int hotel_id,String password);
    //查询住宿总数
    public int getLivingCount(Connection connection,String name,int hotel_id,int flag);
    //获取居住列表
    public List<Living> getLivingList(Connection connection,String name,int hotel_id,int currentPage,int pageSize,int flag);
    //添加住宿者
    public int addLiving(Connection connection,Living living);
    //判断住宿者的ID是否存在
    public boolean idExist(Connection connection,int conf_id);
    //删除住宿者
    public int deleteLiving(Connection connection, int conf_id,int hotel_id,int flag);
    //修改用户住宿信息
    public int modifyLiving(Connection connection, Living living);
    //查看住宿具体信息
    public Living viewLiving(Connection connection,int conf_id);
    //查看酒店所能分配房间数
    public int getNumOfRoom(Connection connection,int hotel_id);

}
