package service.confereeService;

import vo.confereeVo.User;

public interface UserService {
    /**
     * 注册用户
     *
     * @param user
     */
    public  void registUser(User user);

    /**
     * 登录用户
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     *
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public  boolean existUsername(String username) ;

    /**
     * 修改密码及其他用户信息
     * @param user
     */
    public void updatePassword(User user);
}
