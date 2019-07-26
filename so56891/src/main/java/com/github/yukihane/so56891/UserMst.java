package com.github.yukihane.so56891;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserMst {

    @Id
    private Long id;
    
    private String userId;
}
