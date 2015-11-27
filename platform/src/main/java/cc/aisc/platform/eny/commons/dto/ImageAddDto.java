package cc.aisc.platform.eny.commons.dto;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by sjf on 15-11-19.
 */
public class ImageAddDto {

    @NotEmpty
    private String fileName = "";

    @NotEmpty
    private String path = "";

    @Size(min = 4, max = 64)
    private String label = "";

    @NotEmpty
    private String belong2 = "";

    @NotEmpty
    private String belong2id = "";

    @NotEmpty
    private String orderNum = "";

    @Override
    public String toString() {
        return "ImageAddDto{" +
                "fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", label='" + label + '\'' +
                ", belong2='" + belong2 + '\'' +
                ", belong2id=" + belong2id +
                ", orderNum=" + orderNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageAddDto that = (ImageAddDto) o;
        return Objects.equal(fileName, that.fileName) &&
                Objects.equal(path, that.path) &&
                Objects.equal(label, that.label) &&
                Objects.equal(belong2, that.belong2) &&
                Objects.equal(belong2id, that.belong2id) &&
                Objects.equal(orderNum, that.orderNum);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fileName, path, label, belong2, belong2id, orderNum);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBelong2() {
        return belong2;
    }

    public void setBelong2(String belong2) {
        this.belong2 = belong2;
    }

    public String getFileName() {
        return fileName;
    }

    public String getBelong2id() {
        return belong2id;
    }

    public void setBelong2id(String belong2id) {
        this.belong2id = belong2id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
