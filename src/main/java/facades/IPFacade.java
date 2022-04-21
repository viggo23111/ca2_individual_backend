package facades;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dtos.IPDTO;
import dtos.JokeDTO;
import utils.HttpUtils;

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
        return ipDTO;
    }
}
