package com.devstack.healthcare.system.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRole {

    @Id
    private long id;

    private String roleName;

    private String dscription;

    @OneToMany(mappedBy = "userRole")
    private Set<UserRoleHasUser> userRoleHasUsers;

}
