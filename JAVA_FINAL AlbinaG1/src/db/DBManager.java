package db;


import model.News;
import model.User;
import model.Comment;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Final01Database",
                    "postgres",
                    "postgres");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static User getUser(String email) {
        User user = null;

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ?");
            preparedStatement.setString(1,email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                user = new User();
                user.setFulName(fullName);
                user.setPassword(password);
                user.setId(id);
                user.setEmail(email);
            }

            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public static void registerUser (User user){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (email,password,fullName)" +
                            "VALUES(?,?,?) ");
            preparedStatement.setString(1, user.getFulName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFulName());
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addNews (News news){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO news (title,content,userid,postdate)" +
                            "VALUES(?,?,?,now()) ");
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setLong(3, news.getUser().getId());
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<News> getAllNews1(){
        List<News> news1 = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT news.id, news.title, news.content, news.postdate, users.fullname, users.email " +
                            "FROM news " +
                            "INNER JOIN users " +
                            "ON news.userid=users.id " +
                            "ORDER BY postdate DESC ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String text = resultSet.getString("content");
                Timestamp postdate = resultSet.getTimestamp("postdate");
                String userFullName = resultSet.getString("fullname");
                String email = resultSet.getString("email");

                User user = new User();
                user.setFulName(userFullName);
                user.setEmail(email);


                News news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setContent(text);
                news.setPostDate(postdate);
                news.setUser(user);

                news1.add(news);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return news1;
    }
    public static News getNewsById(Long id){
        News news = null;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT news.title, news.content, news.postdate, users.fullname, users.email" +
                            "FROM news " +
                            "INNER JOIN users " +
                            "ON news.userid=users.id " +
                            "WHERE news.id=?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){

                String title = resultSet.getString("title");
                String text = resultSet.getString("content");
                Timestamp postdate = resultSet.getTimestamp("postdate");
                String userFullName = resultSet.getString("fullname");
                String email = resultSet.getString("email");

                User user = new User();
                user.setFulName(userFullName);
                user.setEmail(email);

                news.setId(id);
                news.setTitle(title);
                news.setContent(text);
                news.setPostDate(postdate);
                news.setUser(user);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return news;
    }

    public static void addComment(Comment comment) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO comments (comment,userId,newsId,postDate) " +
                            "VALUES (?,?,?,now()) ");
            preparedStatement.setString(1, comment.getComment());
            preparedStatement.setString(2, String.valueOf(comment.getUser().getId()));
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


