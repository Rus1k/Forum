package com.forumapp.repository.query;

import com.forumapp.model.Account;
import com.forumapp.model.Post;
import com.forumapp.model.Theme;
import com.forumapp.model.UserInfo;
import com.forumapp.repository.Connect;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBServiceImpl implements DBService {

    public static final String INSERT_ACCOUNT = "INSERT INTO account VALUES (?,?)";
    public static final String INSERT_POST = "INSERT INTO posts VALUES (?,?)";
    public static final String INSERT_THEME = "INSERT INTO themes VALUES (?,?)";
    public static final String INSERT_USERINFO = "INSERT INTO user_info VALUES (?,?,?,?,?)";
    public static final String SELECT_USERINFO = "SELECT id_user_info,first_name,last_name,birthday,email,city FROM user_info " +
            "INNER JOIN account ON user_info.id_user_info = account.id_account WHERE login = ?";
    public static final String SELECT_POST_FROM_THEME = "SELECT * FROM post WHERE id_theme_idx_post = ?";
    public static final String SELECT_THEME_FROM_ACCOUNT = "SELECT * FROM theme WHERE id_account_idx_theme = ?";
    public static final String SELECT_ACCOUNT = "SELECT * FROM account WHERE id_account = ?";
    public static final String DELETE_ACCOUNT = "DELETE FROM account WHERE login = ?";
    public static final String DELETE_POST = "DELETE FROM posts WHERE id_post = ?";
    public static final String DELETE_THEME = "DELETE FROM themes WHERE id_theme = ?";
    public static final String UPDATE_UserInfo = "UPDATE user_info SET first_name = ?, last_name = ?, birthday = ?,email = ?, city = ? " +
            "WHERE id_user_info = ?";
    String returnText = null;


    PreparedStatement preparedStatement = null;
    Connection connection = Connect.getConnect();


    @Override
    public void saveAccount(Account account) {
        try {
            preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1, account.getLogin());
            preparedStatement.setString(2, account.getPassword());
            int i = preparedStatement.executeUpdate();
            if (i == 0) {
                System.out.println("no changes");
            }else System.out.println("saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void savePost(Post post) {
        try {
            preparedStatement = connection.prepareStatement(INSERT_POST);
            preparedStatement.setString(1, post.getText());
            preparedStatement.setDate(2, Date.valueOf(post.getDate()));
            int i = preparedStatement.executeUpdate();
            if (i == 0) {
                System.out.println("no changes");
            }else System.out.println("saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveTheme(Theme themes) {
        try {
            preparedStatement = connection.prepareStatement(INSERT_THEME);
            preparedStatement.setString(1,themes.getName());
            preparedStatement.setDate(2,Date.valueOf(themes.getDate()));
            int i = preparedStatement.executeUpdate();
            if (i == 0) {
                System.out.println("no changes");
            }else System.out.println("saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        try {
            preparedStatement = connection.prepareStatement(INSERT_USERINFO);
            preparedStatement.setString(1, userInfo.getFirstName());
            preparedStatement.setString(2, userInfo.getLastName());
            preparedStatement.setDate(3, Date.valueOf(userInfo.getBirthday()));
            preparedStatement.setString(4, userInfo.getEmail());
            preparedStatement.setString(5, userInfo.getCity());
            int i = preparedStatement.executeUpdate();
            if (i == 0) {
                System.out.println("no changes");
            }else System.out.println("saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getAccount(int idAccount) {
        Account account = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ACCOUNT);
            preparedStatement.setInt(1, idAccount);
            ResultSet resultSet = preparedStatement.executeQuery();
            account.builder().idAccount(idAccount).login(resultSet.getString("login"))
                    .password(resultSet.getString("password")).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public List<Post> getPost(int idTheme) {
        List<Post> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SELECT_POST_FROM_THEME);
            preparedStatement.setInt(1,idTheme);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(Post.builder().idPost(resultSet.getInt("id_post"))
                .text(resultSet.getString("text"))
                .date(LocalDate.parse(resultSet.getString("date"))).build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Theme> getTheme(int idAccount) {
        List<Theme> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SELECT_THEME_FROM_ACCOUNT);
            preparedStatement.setInt(1, idAccount);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(Theme.builder().idTheme(resultSet.getInt("id_theme"))
                .name(resultSet.getString("name"))
                .date(LocalDate.parse(resultSet.getString("date"))).build());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public UserInfo getUserInfo(String userLogin) {
        UserInfo userInfo = null;

        try {
            preparedStatement = connection.prepareStatement(SELECT_USERINFO);
            preparedStatement.setString(1, userLogin);
            ResultSet resultSet = preparedStatement.executeQuery();
            userInfo = UserInfo.builder().idUserInfo(resultSet.getInt("id_user_info"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("lastName"))
                    .birthday(LocalDate.parse(resultSet.getString("birthday")))
                    .email(resultSet.getString("email"))
                    .city(resultSet.getString("city")).build();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    @Override
    public String deleteAccount(int idAccount) {
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
    public String changeUserInfo(UserInfo userInfo) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_UserInfo);
            preparedStatement.setString(1, userInfo.getFirstName());
            preparedStatement.setString(2, userInfo.getLastName());
            preparedStatement.setDate(3, Date.valueOf(userInfo.getBirthday()));
            preparedStatement.setString(4, userInfo.getEmail());
            preparedStatement.setString(5, userInfo.getCity());
            preparedStatement.setInt(6, userInfo.getIdUserInfo());
            int i = preparedStatement.executeUpdate();
            if (i == 0) {
                returnText = "no changes";
            } else returnText = "changes successfully";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnText;
    }
}
