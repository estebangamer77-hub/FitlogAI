package com.fitlog.fitlogai.repository;

import com.fitlog.fitlogai.model.User;

import java.sql.*;

public class UserRepository {

    public boolean register(User user){

        String sql = "INSERT INTO users(username,password) VALUES (?,?)";

        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());

            ps.executeUpdate();

            return true;

        }catch(Exception e){
            return false;
        }
    }

    public User login(String username,String password){

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new User(rs.getString("username"),rs.getString("password"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}