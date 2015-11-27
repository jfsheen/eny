package cc.aisc.platform.eny.commons.dto;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by sjf on 15-11-18.
 */
public class TraitAddDto {

    @Size(min = 8, max = 1000, message = "more than 8 chars.")
    private String trait = "";
    @NotEmpty
    private String belong2 = "";
    @NotEmpty
    private String belong2id = "";
    @NotEmpty
    private String images = "";
    @NotEmpty
    private String orderNum = "";

    @Override
    public String toString() {
        return "TraitAddDto{" +
                "trait='" + trait + '\'' +
                ", belong2='" + belong2 + '\'' +
                ", belong2id=" + belong2id +
                ", images='" + images + '\'' +
                ", orderNum=" + orderNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraitAddDto dto = (TraitAddDto) o;
        return Objects.equal(trait, dto.trait) &&
                Objects.equal(belong2, dto.belong2) &&
                Objects.equal(belong2id, dto.belong2id) &&
                Objects.equal(images, dto.images) &&
                Objects.equal(orderNum, dto.orderNum);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(trait, belong2, belong2id, images, orderNum);
    }

    public String getTrait() {

        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public String getBelong2() {
        return belong2;
    }

    public void setBelong2(String belong2) {
        this.belong2 = belong2;
    }

    public String getBelong2id() {
        return belong2id;
    }

    public void setBelong2id(String belong2id) {
        this.belong2id = belong2id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
