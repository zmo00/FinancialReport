package ru.zmo00.financialReport.models.entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client implements UserDetails {

    @Id
    @Column(name = "client_id")
    private UUID id;

    @Column(unique = true)
    private String username;

    private String password;

    private String firstname;

    private String lastname;

    private LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "clients_roles",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @Transient
    private Integer age;

    public enum Gender {
        MALE,
        FEMALE,
        NON_BINARY
    }

    public Integer getAge() {
        if (age == null) {
            return Period.between(birthdate, LocalDate.now()).getYears();
        }
        return age;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String toString() {
        return "Client@" + username + ": " + lastname + " " + firstname + " " + getAge() + " years old";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + birthdate.hashCode();
        return result;
    }
}
