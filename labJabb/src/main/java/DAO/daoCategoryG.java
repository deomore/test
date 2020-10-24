package DAO;
import Model.CategoryG;
import Model.Goods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class daoCategoryG extends dao{
    private Connection connection;

    public CategoryG getOneById(int IdC){
        try{
            connection = ds.getConnection(user, password);
            String selectCommand = "SELECT * FROM labjab.categoryg WHERE IdC = ?";
            PreparedStatement select = connection.prepareStatement(selectCommand);
            select.setInt(1, IdC);
            ResultSet result = select.executeQuery();
            result.next();
            String Name = result.getString("Name");
            String country = result.getString("country");

            return new CategoryG(Name,country);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<CategoryG> getAll(){
        try{
            List<CategoryG> CatList = new ArrayList<CategoryG>();
            connection = ds.getConnection(user, password);
            String selectCommand = "SELECT * FROM labjab.categoryg";
            PreparedStatement select = connection.prepareStatement(selectCommand);
            ResultSet result = select.executeQuery();
            while(result.next()){
                int IdC = result.getInt("IdC");
                String Name = result.getString("Name");
                String country = result.getString("country");
                CategoryG Cat = new CategoryG(Name, country);
                CatList.add(Cat);
            }
            return CatList;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void add(CategoryG cat){
        try{
            connection = ds.getConnection(user, password);
            String insertCommand = "INSERT INTO labjab.categoryg(Name,country) VALUES(?,?)";
            PreparedStatement insert = connection.prepareStatement(insertCommand);
            insert.setString(1, cat.getName());
            insert.setString(2, cat.getCountry());
            insert.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void update(int id,CategoryG cat){
        try{
            connection = ds.getConnection(user, password);
            String updateCommand = "UPDATE labjab.categoryg SET Name = ?, Country = ? WHERE IdC = ?";
            PreparedStatement update = connection.prepareStatement(updateCommand);
            update.setString(1, cat.getName());
            update.setString(2, cat.getCountry());
            update.setInt(3,id);
            update.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int GID){
        try{
            connection = ds.getConnection(user, password);
            String deleteCommand = "DELETE FROM labjab.categoryg WHERE IdC = ?";
            PreparedStatement delete = connection.prepareStatement(deleteCommand);
            delete.setInt(1, GID);
            delete.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}