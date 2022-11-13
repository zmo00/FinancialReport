package ru.zmo00.financialReport.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<Client> clients;

    public Role(RoleEnum roleEnum) {
        this.role = "ROLE_" + roleEnum.toString();
    }

    public enum RoleEnum {
        CLIENT,
        ADMIN
    }

    public RoleEnum getRoleEnum() {
        return RoleEnum.valueOf(role.substring(5));
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (!id.equals(role1.id)) return false;
        return role.equals(role1.role);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
