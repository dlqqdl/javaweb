package service.HotelService;

import vo.hotelVo.Hotel;
import vo.hotelVo.Living;

import java.sql.Connection;
import java.util.List;

/**
 * @author Timgreat
 * @date 2020/12/5 - 11:19
 */
public interface HotelService {
    //登录
    public Hotel login(String name, String password);
    //修改密码
    public boolean updatePwd(int hotel_id, String password);
    //查询记录数
    public int getLivingCount(String name,int hotel_id,int flag);
    //根据条件查询用户列表
    public List<Living> getLivingList(String name,int hotel_id,int currentPage,int pageSize,int flag);
    //添加住宿
    public boolean addLiving(Living living);
    //判断是否已有该记录
    public boolean isExist(int conf_id);

    //删除住宿记录
    public boolean deleteLiving(int conf_id,int hotel_id,int sign);
    //修改住宿信息
    public boolean modifyLiving(Living living);
    //查看具体住宿信息
    public Living viewLiving(int conf_id);
    //查看酒店剩余房间数
    public int getNumOfRoom(int hotel_id);
}
