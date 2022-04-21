package facades;

import dtos.IPDTO;
import dtos.JokeDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class IPFacadeTest {
    private IPFacade ipFacade = new IPFacade();

    @Test
    void getIPTest() throws IOException {
        IPDTO ipDTO = ipFacade.getIP();
        System.out.println(ipDTO.getIp());
        assertNotNull(ipDTO.getIp());
    }

    @Test
    void getIPInfoTest() throws IOException {
        IPDTO ipDTO = ipFacade.getIPInfo("87.48.15.41");
        System.out.println(ipDTO.getIp());
        System.out.println(ipDTO.getCity());
        System.out.println(ipDTO.getCountry());
        assertNotNull(ipDTO.getIp());
    }
}