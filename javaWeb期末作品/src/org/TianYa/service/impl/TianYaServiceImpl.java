package org.TianYa.service.impl;

import org.TianYa.Dao.ITianYaDao;
import org.TianYa.Dao.impl.TianYaDaoImpl;
import org.TianYa.entity.Favorite;
import org.TianYa.entity.User;
import org.TianYa.service.ITianYaService;

import java.util.List;

public class TianYaServiceImpl implements ITianYaService {
    TianYaDaoImpl TianYaDao=new TianYaDaoImpl();
    //查询某个收藏
    @Override
    public Favorite queryFavoriteByNo(int no) {
        return TianYaDao.QueryFavorite(no);
    }
    //查询所有收藏
    @Override
    public List<Favorite> queryAllFavorite() {
        return TianYaDao.QueryAllFavorite();
    }
    //更改某个收藏
    @Override
    public boolean updateFavoriteByNo(int no, Favorite favorite) {
        if (TianYaDao.isExist(no)){
           return TianYaDao.UpDateFavorite(no,favorite);
        }
        return false;
    }
    //删除
    @Override
    public boolean deleteFavoriteByNo(int no) {
        if (TianYaDao.isExist(no)){
            return TianYaDao.deleteFavorite(no);
        }
        return false;
    }
    //增添
    @Override
    public boolean addFavorite(Favorite favorite) {
        if (!TianYaDao.isExist(favorite.getNo())){
            return TianYaDao.addFavorite(favorite);
        }
        else {
            System.out.println("此人已存在！");
            return false;
        }
    }
    //用户注册
    @Override
    public boolean addUser(User user) {
        if (!TianYaDao.isLogin(user)){
            return TianYaDao.addUser(user);
        }
        else {
            System.out.println("此人已存在！");
            return false;
        }
    }
    //用户登录
    @Override
    public boolean login(User user) {
       return TianYaDao.isLogin(user);
    }
    //记录数据总数
    @Override
    public Long getTotalCount() {
        return TianYaDao.getTotalCount();
    }
    //分页查询
    @Override
    public List<Favorite> queryFavoriteByPage(int currentPage, int pageSize) {
        return TianYaDao.queryFavoriteByPage(currentPage,pageSize);
    }


}
