package org.TianYa.Dao.impl;

import org.TianYa.Dao.ITianYaDao;
import org.TianYa.DataSourceUtil.DataSourceUtil;
import org.TianYa.entity.Favorite;
import org.TianYa.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class TianYaDaoImpl implements ITianYaDao {
    //增添收藏
    @Override
    public boolean addFavorite(Favorite favorite) {
        QueryRunner runner=new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());
        try {
            runner.update("insert into tianya_like(no,title,about) values(?,?,?)",new Object[]{favorite.getNo(),favorite.getTitle(),favorite.getAbout()});
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    //增添User
    @Override
    public boolean addUser(User user) {
        QueryRunner runner=new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());
        try {
            runner.update("insert into tianya_user(user,pwd,sex,email) values(?,?,?,?)",new Object[]{user.getName(),user.getPwd(),user.getSex(),user.getMailBox()});
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    //删除收藏
    @Override
    public boolean deleteFavorite(int no) {
        QueryRunner runner=new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());
        try {
            runner.update("delete from tianya_like where no=?",no);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    //通过no，更改标题
    @Override
    public boolean UpDateFavorite(int no, Favorite favorite) {
        QueryRunner runner=new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());
        try {
            runner.update("update tianya_like set title=?,about=? where no=?",new Object[]{favorite.getTitle(),favorite.getAbout(),no});
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //查询全部收藏
    @Override
    public List<Favorite> QueryAllFavorite() {
        QueryRunner runner=new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());
        try {
            List<Favorite> favorites  =runner.query("select * from tianya_like",new BeanListHandler<Favorite>(Favorite.class));
            return favorites;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //查询收藏，根据no
    @Override
    public Favorite QueryFavorite(int no) {
        QueryRunner runner=new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());
        try {
            Favorite favorite =runner.query("select * from tianya_like where no=?",new BeanHandler<Favorite>(Favorite.class),no);
            return favorite;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //根据no，判断某个这个收藏是否存在
    @Override
    public boolean isExist(int no) {/*false代表不存在，true代表存在*/
        return QueryFavorite(no)==null ? false:true;
    }


    //登录,也用于判断此人是否注册
    @Override
    public boolean isLogin(User user){
        QueryRunner runner=new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());
        try {
            User oneUser =runner.query("select * from tianya_user where user=? and pwd=?",new BeanHandler<User>(User.class),user.getName(),user.getPwd());
           if (oneUser!=null){
               return true;
           }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    //得到这个数据总数
    @Override
    public Long getTotalCount() {
        QueryRunner runner=new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());
        try {
            Long result=runner.query("select count(*) from tianya_like",new ScalarHandler<>());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (long) 0;
    }

    //得到本页的数据
    @Override
    public List<Favorite> queryFavoriteByPage(int currentPage, int pageSize) {
         QueryRunner runner=new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());
        try {
            List<Favorite> favorites=runner.query("select * from tianya_like order by no asc limit ?,? ",new BeanListHandler<Favorite>(Favorite.class),currentPage*pageSize,pageSize);
            return favorites;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
