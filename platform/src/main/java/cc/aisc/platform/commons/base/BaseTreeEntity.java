package cc.aisc.platform.commons.base;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by sjf on 15-11-24.
 */
@MappedSuperclass
public abstract class BaseTreeEntity<ID extends Serializable> extends BaseEntity<ID> {

    @Column(name = "tree_lvl")
    private Integer level;

    public BaseTreeEntity(Integer level) {
        this.level = level + 1;
    }

    public BaseTreeEntity() {
    }

    @Override
    public String toString() {
        return "BaseTreeEntity{" +
                "level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BaseTreeEntity that = (BaseTreeEntity) o;
        return Objects.equal(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), level);
    }

    public Integer getLevel() {

        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
