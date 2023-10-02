package org.spring2023.extern.api;

import org.spring2023.app.ClientController;
import org.spring2023.domain.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    public String getAgeExtern() {
        return "20";
    }

    public void takeMethodFromDomain() {
        System.out.println(new Client().getNameDomain());
    }
    public void takeMethodFromApp() {
        System.out.println(new ClientController().getSurnameApp());
    }
}
