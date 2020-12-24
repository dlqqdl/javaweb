package dao.confereeDao;

import vo.confereeVo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回null，说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询（登录）
     * @param username
     * @return
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息（注册）
     * @param user
     * @return
     */
    public User saveUser(User user);

    /**
     * 修改用户信息（登录）
     * @param user
     * @return
     */
    public User updateUser(User user);


}
