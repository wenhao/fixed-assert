package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.web.dto.AssetDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TABLE_USERS")
public class User {

    @Id
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OrderBy("id")
//    private List<AssetDTO> assetDTOs;

    protected User() {
    }

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
//        this.assetDTOs = assetDTOs;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<AssetDTO> getAssetDTOs() {
//        return assetDTOs;
//    }
//
//    public void setAssetDTOs(List<AssetDTO> assetDTOs) {
//        this.assetDTOs = assetDTOs;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
