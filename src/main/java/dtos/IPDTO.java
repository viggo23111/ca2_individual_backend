package dtos;

public class IPDTO {
    private String ip;
    private String city;
    private String region;
    private String country;
    private String loc;
    private String org;
    private String postal;
    private String timezone;

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
