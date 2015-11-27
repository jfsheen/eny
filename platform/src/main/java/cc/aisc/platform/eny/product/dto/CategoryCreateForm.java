package cc.aisc.platform.eny.product.dto;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by sjf on 15-11-18.
 */
public class CategoryCreateForm {

    @NotEmpty
    private String name = "";

    @NotEmpty
    private String description = "";

    @NotNull
    private Long parentId = 0l;

    @NotNull
    private Integer level = 0;

    @Override
    public String toString() {
        return "CategoryCreateForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parentId=" + parentId +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryCreateForm that = (CategoryCreateForm) o;
        return Objects.equal(name, that.name) &&
                Objects.equal(description, that.description) &&
                Objects.equal(parentId, that.parentId) &&
                Objects.equal(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, description, parentId, level);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
