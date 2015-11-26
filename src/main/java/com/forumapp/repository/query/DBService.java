package com.forumapp.repository.query;

import com.forumapp.model.*;
import java.util.List;

/**
 * Created by ruslan on 16.11.2015.
 */
public interface DBService {

    int saveAccount(Account account);
    void savePost(Post post);
    void saveTheme(Theme themes);
    int saveUserInfo(UserInfo userInfo);

    Account getAccount(int idAccount);
    boolean checkLogin(String login);
    List<Post> getPost(int idTheme);
    List<Theme> getTheme(int idAccount);
    UserInfo getUserInfo(String userLogin);


    String deleteAccount(int idAccount);
    String deletePost(int idPost);
    String deleteTheme(int idTheme);
    String changeUserInfo(UserInfo userInfo);

}
