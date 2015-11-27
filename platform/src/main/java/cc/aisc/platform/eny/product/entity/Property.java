package cc.aisc.platform.eny.product.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sjf on 15-11-22.
 */
@Entity
@Table(name = "t_prdt_prop")
public class Property extends BaseEntity<Long> {


    private String propField;

    private String propType;

    private String propName;

    private String propDesc;

    @Override
    public String toString() {
        return "Property{" +
                "propField='" + propField + '\'' +
                ", propType='" + propType + '\'' +
                ", propName='" + propName + '\'' +
                ", propDesc='" + propDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Property property = (Property) o;
        return Objects.equal(propField, property.propField) &&
                Objects.equal(propType, property.propType) &&
                Objects.equal(propName, property.propName) &&
                Objects.equal(propDesc, property.propDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), propField, propType, propName, propDesc);
    }

    public String getPropField() {

        return propField;
    }

    public void setPropField(String propField) {
        this.propField = propField;
    }

    public String getPropType() {
        return propType;
    }

    public void setPropType(String propType) {
        this.propType = propType;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropDesc() {
        return propDesc;
    }

    public void setPropDesc(String propDesc) {
        this.propDesc = propDesc;
    }
}
