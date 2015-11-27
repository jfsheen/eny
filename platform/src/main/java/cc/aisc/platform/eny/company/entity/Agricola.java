package cc.aisc.platform.eny.company.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.commons.entity.Person;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sjf on 15-11-3.
 */
@Entity
@Table(name = "t_prdt_agricola")
public class Agricola extends BaseEntity<Long> {

    @Column(name="agricola_sn")
    private String agricolaSn;

    @OneToOne(cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "owner")
    private Set<Factory> factorySet;

    @Column(name="description")
    private String description;

    @Override
    public String toString() {
        return "Agricola{" +
                "agricolaSn='" + agricolaSn + '\'' +
                ", person=" + person +
                ", factorySet=" + factorySet +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Agricola agricola = (Agricola) o;
        return Objects.equal(agricolaSn, agricola.agricolaSn) &&
                Objects.equal(person, agricola.person) &&
                Objects.equal(factorySet, agricola.factorySet) &&
                Objects.equal(description, agricola.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), agricolaSn, person, factorySet, description);
    }

    public String getAgricolaSn() {

        return agricolaSn;
    }

    public void setAgricolaSn(String agricolaSn) {
        this.agricolaSn = agricolaSn;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Factory> getFactorySet() {
        return factorySet;
    }

    public void setFactorySet(Set<Factory> factorySet) {
        this.factorySet = factorySet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
