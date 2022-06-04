package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ユーザー情報 Entity
 */
@Entity // ここでエンティティクラスだと明示している
@Table(name = "DBSAMPLE") // SELECT対象のテーブル名を記載
public class User {

    @Id
    @Column(name = "ID") //DB上のどのカラムなのかを記載
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "NAME")
    private String NAME;

    @Column(name = "SEX")
    private String SEX;

    public Long getXD() {
        return ID;
    }

    public void setXD(final Long iD) {
        ID = iD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(final String nAME) {
        NAME = nAME;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(final String sEX) {
        SEX = sEX;
    }

}