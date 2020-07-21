package org.TianYa.service;

import org.TianYa.entity.Favorite;
import org.TianYa.entity.User;

import java.util.List;

public interface ITianYaService {
    // 查询收藏信息
    public Favorite queryFavoriteByNo(int sxh);

    // 查询全部收藏信息
    public List<Favorite> queryAllFavorite();

    // 更改收藏信息
    public boolean updateFavoriteByNo(int no, Favorite student);

    // 删除
    public boolean deleteFavoriteByNo(int mo);

    // 增添
    public boolean addFavorite(Favorite favorite);

    //注册用户
    public boolean addUser(User user);
    // 查询总数据数
    public Long getTotalCount();

    // 查询当前页数
    public List<Favorite> queryFavoriteByPage(int currentPage, int pageSize);

    //用户登录
    public boolean login(User user);
}
