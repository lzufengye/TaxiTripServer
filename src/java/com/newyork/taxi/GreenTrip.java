/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newyork.taxi;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "GreenTrip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GreenTrip.findAll", query = "SELECT g FROM GreenTrip g"),
    @NamedQuery(name = "GreenTrip.findByVendorID", query = "SELECT g FROM GreenTrip g WHERE g.vendorID = :vendorID"),
    @NamedQuery(name = "GreenTrip.findByLpepPickupDatetime", query = "SELECT g FROM GreenTrip g WHERE g.lpepPickupDatetime = :lpepPickupDatetime"),
    @NamedQuery(name = "GreenTrip.findByLpepdropoffdatetime", query = "SELECT g FROM GreenTrip g WHERE g.lpepdropoffdatetime = :lpepdropoffdatetime"),
    @NamedQuery(name = "GreenTrip.findByStoreandfwdflag", query = "SELECT g FROM GreenTrip g WHERE g.storeandfwdflag = :storeandfwdflag"),
    @NamedQuery(name = "GreenTrip.findByRateCodeID", query = "SELECT g FROM GreenTrip g WHERE g.rateCodeID = :rateCodeID"),
    @NamedQuery(name = "GreenTrip.findByPickuplongitude", query = "SELECT g FROM GreenTrip g WHERE g.pickuplongitude = :pickuplongitude"),
    @NamedQuery(name = "GreenTrip.findByPickuplatitude", query = "SELECT g FROM GreenTrip g WHERE g.pickuplatitude = :pickuplatitude"),
    @NamedQuery(name = "GreenTrip.findByDropofflongitude", query = "SELECT g FROM GreenTrip g WHERE g.dropofflongitude = :dropofflongitude"),
    @NamedQuery(name = "GreenTrip.findByDropofflatitude", query = "SELECT g FROM GreenTrip g WHERE g.dropofflatitude = :dropofflatitude"),
    @NamedQuery(name = "GreenTrip.findByPassengercount", query = "SELECT g FROM GreenTrip g WHERE g.passengercount = :passengercount"),
    @NamedQuery(name = "GreenTrip.findByTripdistance", query = "SELECT g FROM GreenTrip g WHERE g.tripdistance = :tripdistance"),
    @NamedQuery(name = "GreenTrip.findByFareamount", query = "SELECT g FROM GreenTrip g WHERE g.fareamount = :fareamount"),
    @NamedQuery(name = "GreenTrip.findByExtra", query = "SELECT g FROM GreenTrip g WHERE g.extra = :extra"),
    @NamedQuery(name = "GreenTrip.findByMTAtax", query = "SELECT g FROM GreenTrip g WHERE g.mTAtax = :mTAtax"),
    @NamedQuery(name = "GreenTrip.findByTipamount", query = "SELECT g FROM GreenTrip g WHERE g.tipamount = :tipamount"),
    @NamedQuery(name = "GreenTrip.findByTollsamount", query = "SELECT g FROM GreenTrip g WHERE g.tollsamount = :tollsamount"),
    @NamedQuery(name = "GreenTrip.findByEhailfee", query = "SELECT g FROM GreenTrip g WHERE g.ehailfee = :ehailfee"),
    @NamedQuery(name = "GreenTrip.findByImprovementSurcharge", query = "SELECT g FROM GreenTrip g WHERE g.improvementSurcharge = :improvementSurcharge"),
    @NamedQuery(name = "GreenTrip.findByTotalamount", query = "SELECT g FROM GreenTrip g WHERE g.totalamount = :totalamount"),
    @NamedQuery(name = "GreenTrip.findByPaymenttype", query = "SELECT g FROM GreenTrip g WHERE g.paymenttype = :paymenttype"),
    @NamedQuery(name = "GreenTrip.findByTriptype", query = "SELECT g FROM GreenTrip g WHERE g.triptype = :triptype"),
    @NamedQuery(name = "GreenTrip.findById", query = "SELECT g FROM GreenTrip g WHERE g.id = :id")})
public class GreenTrip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "VendorID")
    private Integer vendorID;
    @Size(max = 255)
    @Column(name = "lpep_pickup_datetime")
    private Timestamp lpepPickupDatetime;
    @Size(max = 255)
    @Column(name = "Lpep_dropoff_datetime")
    private String lpepdropoffdatetime;
    @Size(max = 255)
    @Column(name = "Store_and_fwd_flag")
    private String storeandfwdflag;
    @Column(name = "RateCodeID")
    private Integer rateCodeID;
    @Size(max = 255)
    @Column(name = "Pickup_longitude")
    private String pickuplongitude;
    @Size(max = 255)
    @Column(name = "Pickup_latitude")
    private String pickuplatitude;
    @Size(max = 255)
    @Column(name = "Dropoff_longitude")
    private String dropofflongitude;
    @Size(max = 255)
    @Column(name = "Dropoff_latitude")
    private String dropofflatitude;
    @Column(name = "Passenger_count")
    private Integer passengercount;
    @Size(max = 255)
    @Column(name = "Trip_distance")
    private String tripdistance;
    @Size(max = 255)
    @Column(name = "Fare_amount")
    private String fareamount;
    @Size(max = 255)
    @Column(name = "Extra")
    private String extra;
    @Size(max = 255)
    @Column(name = "MTA_tax")
    private String mTAtax;
    @Size(max = 255)
    @Column(name = "Tip_amount")
    private String tipamount;
    @Size(max = 255)
    @Column(name = "Tolls_amount")
    private String tollsamount;
    @Size(max = 255)
    @Column(name = "Ehail_fee")
    private String ehailfee;
    @Size(max = 255)
    @Column(name = "improvement_surcharge")
    private String improvementSurcharge;
    @Size(max = 255)
    @Column(name = "Total_amount")
    private String totalamount;
    @Column(name = "Payment_type")
    private Integer paymenttype;
    @Column(name = "Trip_type")
    private Integer triptype;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public GreenTrip() {
    }

    public GreenTrip(Integer id) {
        this.id = id;
    }

    public Integer getVendorID() {
        return vendorID;
    }

    public void setVendorID(Integer vendorID) {
        this.vendorID = vendorID;
    }

    public Timestamp getLpepPickupDatetime() {
        return lpepPickupDatetime;
    }

    public void setLpepPickupDatetime(Timestamp lpepPickupDatetime) {
        this.lpepPickupDatetime = lpepPickupDatetime;
    }

    public String getLpepdropoffdatetime() {
        return lpepdropoffdatetime;
    }

    public void setLpepdropoffdatetime(String lpepdropoffdatetime) {
        this.lpepdropoffdatetime = lpepdropoffdatetime;
    }

    public String getStoreandfwdflag() {
        return storeandfwdflag;
    }

    public void setStoreandfwdflag(String storeandfwdflag) {
        this.storeandfwdflag = storeandfwdflag;
    }

    public Integer getRateCodeID() {
        return rateCodeID;
    }

    public void setRateCodeID(Integer rateCodeID) {
        this.rateCodeID = rateCodeID;
    }

    public String getPickuplongitude() {
        return pickuplongitude;
    }

    public void setPickuplongitude(String pickuplongitude) {
        this.pickuplongitude = pickuplongitude;
    }

    public String getPickuplatitude() {
        return pickuplatitude;
    }

    public void setPickuplatitude(String pickuplatitude) {
        this.pickuplatitude = pickuplatitude;
    }

    public String getDropofflongitude() {
        return dropofflongitude;
    }

    public void setDropofflongitude(String dropofflongitude) {
        this.dropofflongitude = dropofflongitude;
    }

    public String getDropofflatitude() {
        return dropofflatitude;
    }

    public void setDropofflatitude(String dropofflatitude) {
        this.dropofflatitude = dropofflatitude;
    }

    public Integer getPassengercount() {
        return passengercount;
    }

    public void setPassengercount(Integer passengercount) {
        this.passengercount = passengercount;
    }

    public String getTripdistance() {
        return tripdistance;
    }

    public void setTripdistance(String tripdistance) {
        this.tripdistance = tripdistance;
    }

    public String getFareamount() {
        return fareamount;
    }

    public void setFareamount(String fareamount) {
        this.fareamount = fareamount;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getMTAtax() {
        return mTAtax;
    }

    public void setMTAtax(String mTAtax) {
        this.mTAtax = mTAtax;
    }

    public String getTipamount() {
        return tipamount;
    }

    public void setTipamount(String tipamount) {
        this.tipamount = tipamount;
    }

    public String getTollsamount() {
        return tollsamount;
    }

    public void setTollsamount(String tollsamount) {
        this.tollsamount = tollsamount;
    }

    public String getEhailfee() {
        return ehailfee;
    }

    public void setEhailfee(String ehailfee) {
        this.ehailfee = ehailfee;
    }

    public String getImprovementSurcharge() {
        return improvementSurcharge;
    }

    public void setImprovementSurcharge(String improvementSurcharge) {
        this.improvementSurcharge = improvementSurcharge;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public Integer getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(Integer paymenttype) {
        this.paymenttype = paymenttype;
    }

    public Integer getTriptype() {
        return triptype;
    }

    public void setTriptype(Integer triptype) {
        this.triptype = triptype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GreenTrip)) {
            return false;
        }
        GreenTrip other = (GreenTrip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newyork.taxi.GreenTrip[ id=" + id + " ]";
    }
    
}
