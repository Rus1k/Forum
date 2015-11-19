package com.forumapp.repository.query;

import com.forumapp.model.Post;
import com.forumapp.model.Theme;
import com.forumapp.model.Account;
import com.forumapp.model.UserInfo;

import java.util.List;

/**
 * Created by ruslan on 16.11.2015.
 */
public interface DBService {

    void saveAccount(Account account);
    void savePost(Post post);
    void saveTheme(Theme themes);
    void saveUserInfo(UserInfo userInfo);

    Account getAccount(int idAccount);
    List<Post> getPost(int idTheme);
    List<Theme> getTheme(int idAccount);
    UserInfo getUserInfo(String userLogin);


    String deleteAccount(int idAccount);
    String deletePost(int idPost);
    String deleteTheme(int idTheme);
    String changeUserInfo(UserInfo userInfo);

}
