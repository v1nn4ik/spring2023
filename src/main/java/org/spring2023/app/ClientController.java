package org.spring2023.app;

import org.spring2023.domain.Client;
import org.springframework.stereotype.Controller;
@Controller
public class ClientController {
    public String getSurnameApp() {
        return "Vinnik";
    }

    public void takeMethodFromDomain() {
        System.out.println(new Client().getNameDomain());
    }

//    public void takeMethodFromExtern() {
//        System.out.println(new ClientService().getAgeExtern());
//    }
}
