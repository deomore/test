package DAO;
import Model.Goods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class daoGoods extends dao{
    private Connection connection;

    public Goods getOneById(int GoodsID){
        try {
            connection = ds.getConnection(user, password);
            String getCommand = "SELECT * FROM labjab.goods WHERE GoodsID = ?";
            PreparedStatement select = connection.prepareStatement(getCommand);
            select.setInt(1,GoodsID);
            ResultSet result = select.executeQuery();
            result.next();
            int Category = result.getInt("Category");
            String Manufactor = result.getString("Manufactor");
            float Price = result.getFloat("Price");
            return new Goods(Manufactor,Category,Price);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Goods> getAll(){
        try {
            List<Goods> goodsList = new ArrayList<Goods>();
            connection = ds.getConnection(user, password);
            String getCommand = "SELECT * FROM labjab.goods";
            PreparedStatement select = connection.prepareStatement(getCommand);
            ResultSet result = select.executeQuery();
            while (result.next()){
                int GoodsID = result.getInt("GoodsID");
                int Category = result.getInt("Category");
                String Manufactor = result.getString("Manufactor");
                float Price = result.getFloat("Price");
                Goods goods = new Goods(Manufactor, Category, Price);
                goodsList.add(goods);
            }
            return goodsList;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public boolean add(Goods prod){
        try{
            connection = ds.getConnection(user, password);
            String insertCommand = "INSERT INTO labjab.goods (Category,Manufactor, Price) VALUES(?,?,?)";
            PreparedStatement insert = connection.prepareStatement(insertCommand);
            insert.setInt(1, prod.getCategory());
            insert.setString(2, prod.getManufactor());
            insert.setFloat(3,prod.getPrice());

            if (insert.executeUpdate()>0) return true;
            insert.execute();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean update(int id, Goods goods){
        try{connection = ds.getConnection(user, password);
            String updateCommand = "UPDATE labjab.goods SET Category = ?, Manufactor = ?, Price = ? WHERE GoodsID = ?";
            PreparedStatement update = connection.prepareStatement(updateCommand);
            update.setInt(1,goods.getCategory());
            update.setString(2,goods.getManufactor());
            update.setFloat(3,goods.getPrice());
            update.setInt(4,id);
            update.execute();
            if (update.executeUpdate()>0) return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean delete(int GID) {
        try{
            connection = ds.getConnection(user,password);
            String deleteCommand = "DELETE FROM labjab.goods WHERE GoodsID = ?";
            PreparedStatement delete = connection.prepareStatement(deleteCommand);
            delete.setInt(1, GID);
            delete.execute();
            if (delete.executeUpdate()>0) return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
