package cc.aisc.platform.eny.product.dto;

import com.google.common.base.Objects;

/**
 * Created by sjf on 15-11-24.
 */
public class CategoryNode {

    private Long  id;

    private String name;

    private String description;

    private Long parentId;

    private Integer level;

    /*private Integer lft;

    private Integer rgt;

    private Integer lvl;*/

    @Override
    public String toString() {
        return "CategoryNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parentId=" + parentId +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryNode that = (CategoryNode) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(name, that.name) &&
                Objects.equal(description, that.description) &&
                Objects.equal(parentId, that.parentId) &&
                Objects.equal(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, description, parentId, level);
    }

    public Integer getLevel() {

        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
