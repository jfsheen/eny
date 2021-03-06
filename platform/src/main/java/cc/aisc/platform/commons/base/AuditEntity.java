package cc.aisc.platform.commons.base;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sjf on 15-11-21.
 */
@MappedSuperclass
public class AuditEntity<ID extends Serializable> extends BaseEntity<ID> {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Size(max = 20)
    @Column(name = "created_by", length = 20)
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Size(max = 20)
    @Column(name = "updated_by", length = 20)
    private String updatedBy;

    @PrePersist
    public void beforePersist() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    /**
     * Sets updatedAt before update
     */
    @PreUpdate
    public void beforeUpdate() {
        this.updatedAt = new Date();
    }

    @Override
    public String toString() {
        return "AuditEntity{" +
                "createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AuditEntity that = (AuditEntity) o;
        return Objects.equal(createdAt, that.createdAt) &&
                Objects.equal(createdBy, that.createdBy) &&
                Objects.equal(updatedAt, that.updatedAt) &&
                Objects.equal(updatedBy, that.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), createdAt, createdBy, updatedAt, updatedBy);
    }

    public Date getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
