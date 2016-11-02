package name.guke.model;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <描述信息>
 *
 * @author <a href="mailto:cdguke@jd.com">guke</a>
 * @version 1.0. 2016/10/13
 * @since <某个版本引入>
 */
@Entity
@Indexed
public class UserEntity implements Serializable {
    @Id
    private Long id;

    @Field
    private String code;

    @Field
    private String name;

    public UserEntity(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public UserEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserEntity{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
