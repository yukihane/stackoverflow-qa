package com.example.so62704402;

import lombok.Data;

@Data
public class Profile {

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    //    @Column(name = "profileId")
    private long profileId;

    //    @OneToOne(targetEntity = SiteUser.class)
    //    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;

    //    @Column(name = "about", length = 1000)
    //    @Size(max = 1000, message = "{edit.profile.about.size}")
    private String about;

    public void safeCopyFrom(final Profile profile) {
        // TODO Auto-generated method stub

    }

    public void setUser(final SiteUser userVal) {
        // TODO Auto-generated method stub

    }

}
