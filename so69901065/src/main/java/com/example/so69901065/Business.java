package com.example.so69901065;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@Document(collection = "businesses")
public class Business {
    //@Id
    private String id;

    @NotBlank
    @Size(max = 64)
    private String name;

    //@Field("created_at")
    private Date createdAt;

    //@Field("updated_at")
    private Date updatedAt;

    private Boolean active;

    //@DBRef
    private User owner;

    @Valid
    private List<Address> addresses;

    public Business(String name, User owner, List<Address> addresses, Date createdAt, Date updatedAt, Boolean active) {
        this.name = name;
        this.owner = owner;
        this.addresses = addresses;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public Business(String name, User owner, List<Address> addresses, Date updatedAt, Boolean active) {
        this.name = name;
        this.owner = owner;
        this.addresses = addresses;
        this.updatedAt = updatedAt;
        this.active = active;
    }
}
