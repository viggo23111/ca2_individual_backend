package facades;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dtos.IPDTO;
import entities.IP;
import utils.EMF_Creator;
import utils.HttpUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.IOException;

public class IPFacade {

    public IPDTO getIP () throws IOException {
        String IP = HttpUtils.fetchData("https://api.ipify.org/?format=json");
        JsonObject jObjIP = new Gson().fromJson(IP, JsonObject.class);
        String resultIP = jObjIP.get("ip").getAsString();
        IPDTO ipDTO = new IPDTO(resultIP);
        return ipDTO;
    }

    public IPDTO getIPInfo (String ip) throws IOException {
        String IPInfo = HttpUtils.fetchData("https://ipinfo.io/"+ip+"/geo");
        JsonObject jObjIPInfo = new Gson().fromJson(IPInfo, JsonObject.class);
        String resultCity = jObjIPInfo.get("city").getAsString();
        String resultRegion = jObjIPInfo.get("region").getAsString();
        String resultCountry = jObjIPInfo.get("country").getAsString();
        String resultLoc = jObjIPInfo.get("loc").getAsString();
        String resultOrg = jObjIPInfo.get("org").getAsString();
        String resultPostal = jObjIPInfo.get("postal").getAsString();
        String resultTimezone = jObjIPInfo.get("timezone").getAsString();
        IPDTO ipDTO = new IPDTO(ip,resultCity,resultRegion,resultCountry,resultLoc,resultOrg,resultPostal,resultTimezone);
        saveIPInfoRequest(ipDTO);
        return ipDTO;
    }

    public void saveIPInfoRequest(IPDTO ipdto){
        IP ipInfo = new IP(ipdto.getIp(),ipdto.getCity(),ipdto.getRegion(),ipdto.getCountry(),ipdto.getLoc(),ipdto.getOrg(),ipdto.getPostal(),ipdto.getTimezone());
        EntityManagerFactory emf= EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ipInfo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public int getApiRequestAmount(){
        EntityManagerFactory emf= EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createQuery("select count(i) FROM IP i");
            long amount = (long) query.getSingleResult();
            return (int) amount;
        } finally {
            em.close();
        }
    }


}
