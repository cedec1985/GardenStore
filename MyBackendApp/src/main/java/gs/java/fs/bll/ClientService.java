package gs.java.fs.bll;

import gs.java.fs.domain.entities.Client;

import java.util.List;


public interface ClientService {

    Client getOne(Long id);
    List<Client> getAll();
    Client create(Client toCreate);
    Client update(Long id, Client toUpdate);
    Client delete(Long id);

}

