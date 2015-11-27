package cc.aisc.platform.eny.product.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-11-22.
 */
@Entity
@Table(name = "t_prdt_prop_value")
public class PrdtPropValue extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Column(name = "value")
    private String value;

    @Override
    public String toString() {
        return "PrdtPropValue{" +
                "product=" + product +
                ", property=" + property +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PrdtPropValue that = (PrdtPropValue) o;
        return Objects.equal(product, that.product) &&
                Objects.equal(property, that.property) &&
                Objects.equal(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), product, property, value);
    }

    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
