package cc.aisc.platform.commons.auth.entity;

import cc.aisc.platform.commons.base.BaseTreeEntity;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-12-1.
 */
@Entity
@Table(name = "t_auth_resource")
public class Resource extends BaseTreeEntity<Long, Resource> {

    @Column(name = "res_name")
    private String resName;

    @Column(name = "func_id", nullable = false, unique = true)
    private String funcId;

    @Column(name = "func_na", nullable = false, columnDefinition = "boolean default true")
    private Boolean funcNa = true;

    @Column(name = "res_desc")
    private String description;

    public Resource() {
    }

    public Resource(Resource parent) {
        super(parent.getLevel(), parent);
    }

    public Resource(String resName, String funcId, String description) {
        this.resName = resName;
        this.funcId = funcId;
        this.description = description;
    }

    public Boolean getFuncNa() {
        return funcNa;
    }

    public void setFuncNa(Boolean funcNa) {
        this.funcNa = funcNa;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resName='" + resName + '\'' +
                ", funcId='" + funcId + '\'' +
                ", funcNa=" + funcNa +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Resource resource = (Resource) o;
        return Objects.equal(resName, resource.resName) &&
                Objects.equal(funcId, resource.funcId) &&
                Objects.equal(funcNa, resource.funcNa) &&
                Objects.equal(description, resource.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), resName, funcId, funcNa, description);
    }

    public String getFuncId() {

        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResName() {

        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }
}
