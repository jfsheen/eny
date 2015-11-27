package cc.aisc.platform.auth.currentuser;

import cc.aisc.platform.auth.currentuser.CurrentUser;

/**
 * Created by sjf on 15-11-11.
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}