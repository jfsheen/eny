package cc.aisc.platform.eny.product.entity;

import cc.aisc.platform.commons.base.BaseTreeEntity;
import cc.aisc.platform.eny.product.service.CategoryService;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sjf on 15-11-11.
 */
@Entity
@Table(name = "t_pdct_categroy")
public class Category extends BaseTreeEntity<Long, Category>{

    @Column(name="category_sn")
    private String categorySn;

    @Column(name="category_name")
    private String name;

    @Column(name="description")
    private String description;



    public Category(Category parent) {
        super(parent.getLevel(), parent);
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "categorySn='" + categorySn + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equal(categorySn, category.categorySn) &&
                Objects.equal(name, category.name) &&
                Objects.equal(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), categorySn, name, description);
    }

    public String getCategorySn() {

        return categorySn;
    }

    public void setCategorySn(String categorySn) {
        this.categorySn = categorySn;
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
}
