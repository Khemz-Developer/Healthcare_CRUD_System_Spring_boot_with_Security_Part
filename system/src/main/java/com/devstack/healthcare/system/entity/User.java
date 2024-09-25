package com.devstack.healthcare.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class User  {

    @Id
    private long id;

    private String fullName;

    private String email;

    private String password;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

    @OneToMany(mappedBy = "user")
    private Set<UserRoleHasUser> userRoleHasUsers;
}
