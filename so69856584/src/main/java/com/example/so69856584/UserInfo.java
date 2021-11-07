package com.example.so69856584;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Entity(name = "UserInfo")
@Table(name = "user_infos")
@Getter
public class UserInfo {

    @Id
    private Long id;
}
