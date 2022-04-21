package dtos;

import entities.IP;

import java.time.LocalDateTime;

public class IPDTO {
    private String ip;
    private String city;
    private String region;
    private String country;
    private String loc;
    private String org;
    private String postal;
    private String timezone;
    private LocalDateTime date;

    public IPDTO(String ip, String city, String region, String country, String loc, String org, String postal, String timezone) {
        this.ip = ip;
        this.city = city;
        this.region = region;
        this.country = country;
        this.loc = loc;
        this.org = org;
        this.postal = postal;
        this.timezone = timezone;
    }

    public IPDTO(String ip) {
        this.ip = ip;
    }

    public IPDTO(IP ipInfo) {
        this.ip = ipInfo.getIp();
        this.city = ipInfo.getCity();
        this.region = ipInfo.getRegion();
        this.country = ipInfo.getCountry();
        this.loc = ipInfo.getLoc();
        this.org = ipInfo.getOrg();
        this.postal = ipInfo.getPostal();
        this.timezone = ipInfo.getTimezone();
        this.date = ipInfo.getDate();
    }

    public String getIp() {
        return ip;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getLoc() {
        return loc;
    }

    public String getOrg() {
        return org;
    }

    public String getPostal() {
        return postal;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public String toString() {
        return "IPDTO{" +
                "ip='" + ip + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", loc='" + loc + '\'' +
                ", org='" + org + '\'' +
                ", postal='" + postal + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
