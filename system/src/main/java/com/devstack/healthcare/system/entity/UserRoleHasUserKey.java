package com.devstack.healthcare.system.entity;


import jakarta.persistence.Column;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class UserRoleHasUserKey implements Serializable {

   @Column(name = "user_id")
   private long user;

    @Column(name = "role_id")
    private long userRole;
}
