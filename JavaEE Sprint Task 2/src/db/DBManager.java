package db;

import model.Items;
import servlet.UpdateItemServlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection connection;

    public static Items item;
    private static Long id;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/SprintTask030Database",
                    "postgres",
                    "postgres");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Items> getItems() {
        List<Items> itemsList = new ArrayList<>();
        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Double price = resultSet.getDouble("price");
                Items item = new Items();
                item.setId(id);
                item.setName(name);
                item.setDescription(description);
                item.setPrice(price);
                itemsList.add(item);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return itemsList;
    }

    public static void addItem(Items item) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO items (name,description,price) " +
                            "VALUES (?,?,?)");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Items getItemById(Long id) {
        Items item = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM items WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String idshka = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Double price = resultSet.getDouble("price");
                item = new Items();
                item.setId(Long.parseLong(idshka));
                item.setName(name);
                item.setDescription(description);
                item.setPrice(price);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
    public static void deleteItem(Long id){
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM items WHERE id = ? ");
            statement.setLong(1,id);
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void updateItem(Items item){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE items SET name=?, description=?, price=? WHERE id=?");
            preparedStatement.setString(1,item.getName());
            preparedStatement.setString(2,item.getDescription());
            preparedStatement.setDouble(3,item.getPrice());
            preparedStatement.setLong(4,item.getId());
            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
