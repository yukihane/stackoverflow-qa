package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import mrs.app.user.UserIdDuplicateCheck;


//会議室予約システムを利用するユーザー情報を格納するテーブル
//Userエンティティー
@Entity
@Table(name = "usr")
@UserIdDuplicateCheck(message="このユーザーIDは既に登録されています")
public class User implements Serializable {

    @Id
    @NotBlank(groups=ValidGroup1.class)
    @Email(groups=ValidGroup2.class)
    private String userId;

    @NotBlank(groups=ValidGroup1.class)
    @Length(min=4, max=100, groups=ValidGroup2.class)
    private String password;

    @NotBlank(groups=ValidGroup1.class)
    private String firstName;

    @NotBlank(groups=ValidGroup1.class)
    private String lastName;

    /**
    * 電話番号
    */
    @NotBlank(groups=ValidGroup1.class)
    @Pattern(regexp = "0\\d{1,4}\\d{1,4}\\d{4}", groups=ValidGroup2.class)
    private String phoneNumber;

    @NotBlank(groups=ValidGroup1.class)
    private String zipCode;

    /**
    * 住所
    */
    @NotBlank(groups=ValidGroup1.class)
    @Size(max = 200, groups=ValidGroup2.class)
    private String address;

    //@Enumerated(EnumType.STRING)
    @NotBlank(groups=ValidGroup1.class)
    private String roleName;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}