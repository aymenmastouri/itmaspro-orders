package com.itmaspro.general.domain.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

/**
 * Abstract base class for all {@link ApplicationPersistenceEntity persistence entities} with an {@link #getId() id} and a
 * {@link #getVersion()} () modificationCounter} (version) field. All persistence entities of this application
 * should inherit from this class. It is using JPA annotations at the getters what has several advantages but also
 * implies that you have to annotate transient getter methods with the {@link Transient} annotation.
 */
@MappedSuperclass
public abstract class ApplicationPersistenceEntity
{
    @Id
    @GeneratedValue(generator = "uuid")
   @GenericGenerator( name = "uuid", strategy = "uuid2")
    private String id;

    @Version
    private Integer version;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    private void onCreate() {
        Date date = new Date();

        this.setUpdatedAt(date);
        this.setCreatedAt(date);
    }

    @PreUpdate
    private void onUpdate() {
        this.setUpdatedAt(new Date());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion( Integer version )
    {
        this.version = version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {

        StringBuilder buffer = new StringBuilder();
        toString(buffer);
        return buffer.toString();
    }

    /**
     * Method to extend {@link #toString()} logic.
     *
     * @param buffer is the {@link StringBuilder} where to {@link StringBuilder#append(Object) append} the string
     *        representation.
     */
    protected void toString(StringBuilder buffer) {

        buffer.append(getClass().getSimpleName());
        if (this.id != null) {
            buffer.append("[id=");
            buffer.append(this.id);
            buffer.append("]");
        }
    }
}
