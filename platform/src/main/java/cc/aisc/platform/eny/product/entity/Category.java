package cc.aisc.platform.eny.product.entity;

import cc.aisc.platform.commons.base.BaseTreeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sjf on 15-11-11.
 */
@Entity
@Table(name = "t_pdct_categroy")
public class Category extends BaseTreeEntity<Long>{

    @Column(name="category_sn")
    private String categorySn;

    @Column(name="category_name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "parent")
    private List<Category> children = new ArrayList<>();


    public Category(Category parent) {
        super(parent.getLevel());
        this.parent = parent;
    }

    public Category() {
    }

    /*@Override
    public String toString() {
        return "Category{" +
                "categorySn='" + categorySn + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category parent = (Category) o;
        return Objects.equal(categorySn, parent.categorySn) &&
                Objects.equal(name, parent.name) &&
                Objects.equal(description, parent.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), categorySn, name, description);
    }*/

    public List<Category> getChildren() {

        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public Category getParent() {

        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
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
