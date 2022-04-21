package entities;

import com.nimbusds.jwt.util.DateUtils;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

import static java.util.Calendar.HOUR;

@Entity
@Table(name = "ip_addresses")
public class IP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ip")
    private String ip;
    @Column(name = "city")
    private String city;
    @Column(name = "region")
    private String region;
    @Column(name = "country")
    private String country;
    @Column(name = "loc")
    private String loc;
    @Column(name = "org")
    private String org;
    @Column(name = "postal")
    private String postal;
    @Column(name = "timezone")
    private String timezone;
    @Column(name = "date")
    private LocalDateTime date;

    public IP() {
    }

    public IP(String ip, String city, String region, String country, String loc, String org, String postal, String timezone) {
        this.ip = ip;
        this.city = city;
        this.region = region;
        this.country = country;
        this.loc = loc;
        this.org = org;
        this.postal = postal;
        this.timezone = timezone;
        this.date =LocalDateTime.now().plusHours(2);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

