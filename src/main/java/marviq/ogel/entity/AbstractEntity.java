package marviq.ogel.entity;

import org.junit.platform.commons.util.ToStringBuilder;

import javax.persistence.*;


@MappedSuperclass
public abstract class AbstractEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false, unique = true)
    protected String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("id", id).toString();
    }
}