package com.devstack.healthcare.system.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRoleHasUser {

    @EmbeddedId
    private UserRoleHasUserKey id = new UserRoleHasUserKey();

    @ManyToOne
    @MapsId("user")  // this is the name of the field in the class. feild means variable
    @JoinColumn(name = "user_id",nullable = false) //
    private User user;

    @ManyToOne
    @MapsId("userRole")
    @JoinColumn(name = "role_id",nullable = false)
    private UserRole userRole;

}
