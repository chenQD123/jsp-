package org.TianYa.Dao;

import org.TianYa.entity.Favorite;
import org.TianYa.entity.User;

import java.util.List;

public interface ITianYaDao {
//    增添用户
    public boolean addFavorite(Favorite favorite);

//    删除用户
    public boolean deleteFavorite(int no);

//    根据id，更改用户信息
    public boolean UpDateFavorite(int no,Favorite favorite);

//    查询所有用户信息
    public List<Favorite> QueryAllFavorite();

//    根据id，查询某个用户的信息
    public Favorite QueryFavorite(int no);

//    判断收藏是否存在
    public boolean isExist(int no);

//    查询总数据数
    public Long getTotalCount();

//    查询当前页数
    public List<Favorite> queryFavoriteByPage(int currentPage, int pageSize);

    //    增加用户
    public boolean addUser(User user);

    //登录,也用于判断此人是否注册
    public boolean isLogin(User user);
}
