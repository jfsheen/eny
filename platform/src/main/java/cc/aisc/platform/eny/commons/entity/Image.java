package cc.aisc.platform.eny.commons.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.commons.base.BaseImageEntity;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-11-18.
 */
@Entity
@Table(name = "t_images")
public class Image extends BaseImageEntity<Long> {

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "belong2")
    private Trait trait;

    @Override
    public String toString() {
        return "Image{" +
                "trait=" + trait +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Image image = (Image) o;
        return Objects.equal(trait, image.trait);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), trait);
    }

    public Trait getTrait() {

        return trait;
    }

    public void setTrait(Trait trait) {
        this.trait = trait;
    }
}
