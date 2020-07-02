package com.example.en62678427;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class FleetSerialNo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FLT_ID")
    private int fltId;

    @Column(name = "SER_NO_PFX")
    private String serialNoPrefix;

    @Column(name = "SER_NO_BDY")
    private String serialNoBody;

    @ManyToOne
    private Fleet fleet;

    public FleetSerialNo() {

    }

    public FleetSerialNo(final String serialNoPrefix, final String serialNoBody, final Fleet fleet) {
        super();
        this.serialNoPrefix = serialNoPrefix;
        this.serialNoBody = serialNoBody;
        this.fleet = fleet;
    }

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    //    @Column(name = "FLT_ID")
    public int getFltId() {
        return fltId;
    }

    public void setFltId(final int fltId) {
        this.fltId = fltId;
    }
}