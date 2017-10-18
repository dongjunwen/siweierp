package com.fangxin.siwei.fangzhi.mapper;


import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
public interface UserMapper extends MyMapper<User> {
    /**
     *  获取用户信息
     * @return
     */
    List<User> getUsers();
    /**
     * 登录
     * @param name
     * @return
     */
    User login(String name);

    /**
     * 根据id获取user
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 修改
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 新增
     * @param user
     * @return
     */
    Integer createUser(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer delUser(Integer id);
}
