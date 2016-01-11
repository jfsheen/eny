package cc.aisc.platform.commons.auth.currentuser;

/**
 * Created by sjf on 15-11-11.
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}