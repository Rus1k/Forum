package com.forumapp.repository.query;

import com.forumapp.model.Account;
import com.forumapp.model.Post;
import com.forumapp.model.Theme;
import com.forumapp.model.UserInfo;
import com.forumapp.repository.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBServiceImpl implements DBService {

    public static final String INSERT_USER = "INSERT INTO account VALUES (?,?)";
    public static final String INSERT_POST = "INSERT INTO posts VALUES (?,?,?,?)";
    public static final String INSERT_THEME = "INSERT INTO themes VALUES (?,?,?)";
    public static final String INSERT_USERINFO = "INSERT INTO user_info VALUES (?,?,?,?,?,?)";
    public static final String SELECT_USERINFO = "SELECT first_name,last_name,birthday,email,city FROM user_info " +
            "INNER JOIN account ON user_info.id_user_info = account.id_account WHERE login = ?";
    public static final String DELETE_ACCOUNT = "DELETE FROM account WHERE login = ?";
    public static final String DELETE_POST = "DELETE FROM posts WHERE id_post = ?";
    public static final String DELETE_THEME = "DELETE FROM themes WHERE id_theme = ?";
    public static final String DELETE_UserInfo = "DELETE FROM user_info WHERE id_user_info = ?";
    String returnText = null;


    PreparedStatement preparedStatement = null;
    Connection connection = Connect.getConnect();


    @Override
    public void saveUser(Account account) {
        try {
            preparedStatement = connection.prepareStatement(INSERT_USER);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void savePost(Post post) {
        try {
            preparedStatement = connection.prepareStatement(INSERT_POST);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveTheme(Theme themes) {
        try {
            preparedStatement = connection.prepareStatement(INSERT_THEME);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        try {
            preparedStatement = connection.prepareStatement(INSERT_USERINFO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserInfo getUserInfo(String userLogin) {
        UserInfo userInfo = new UserInfo();

        try {
            preparedStatement = connection.prepareStatement(SELECT_USERINFO);
            preparedStatement.setString(1, userLogin);
            ResultSet resultSet = preparedStatement.executeQuery();

            userInfo.setFirstName(resultSet.getString("first_name"));
            userInfo.setLastName(resultSet.getString("last_name"));
            userInfo.setBirthday(LocalDate.parse(resultSet.getString("birthday")));
            userInfo.setEmail(resultSet.getString("email"));
            userInfo.setCity(resultSet.getString("city"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    @Override
    public String deleteUser(int idAccount) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_ACCOUNT);
            preparedStatement.setInt(1, idAccount);
            int i = preparedStatement.executeUpdate();
            if (i == 0) {
                returnText = "not delete";
            } else returnText = "deleted";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnText;
    }

    @Override
    public String deletePost(int idPost) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_POST);
            preparedStatement.setInt(1, idPost);
            int i = preparedStatement.executeUpdate();
            if (i == 0) {
                returnText = "not delete";
            } else returnText = "deleted";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnText;
    }

    @Override
    public String deleteTheme(int idTheme) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_THEME);
            preparedStatement.setInt(1, idTheme);
            int i = preparedStatement.executeUpdate();
            if (i == 0) {
                returnText = "not delete";
            } else returnText = "deleted";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnText;
    }

    @Override
    public String changeUserInfo(int idUserInfo) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_UserInfo);
            preparedStatement.setInt(1, idUserInfo);
            int i = preparedStatement.executeUpdate();
            if (i == 0) {
                returnText = "not delete";
            } else returnText = "deleted";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnText;
    }
}
