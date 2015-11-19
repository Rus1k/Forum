package com.forumapp.repository.query;

import com.forumapp.model.Post;
import com.forumapp.model.Theme;
import com.forumapp.model.Account;
import com.forumapp.model.UserInfo;

/**
 * Created by ruslan on 16.11.2015.
 */
public interface DBService {

    void saveUser(Account account);
    void savePost(Post post);
    void saveTheme(Theme themes);
    void saveUserInfo(UserInfo userInfo);

    UserInfo getUserInfo(String userLogin);
    String deleteUser(int idAccount);
    String deletePost(int idPost);
    String deleteTheme(int idTheme);
    String changeUserInfo(int idUserInfo);

}
