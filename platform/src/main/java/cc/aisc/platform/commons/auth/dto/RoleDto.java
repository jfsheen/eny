package cc.aisc.platform.commons.auth.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by sjf on 16-1-11.
 */
public class RoleDto {

    @NotEmpty
    private String roleName;

    private String description;


}
