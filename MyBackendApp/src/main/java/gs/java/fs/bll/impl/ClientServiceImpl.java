package gs.java.fs.bll.impl;

import gs.java.fs.dal.ClientRepository;
import gs.java.fs.bll.ClientService;
import gs.java.fs.domain.entities.Client;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class ClientServiceImpl implements ClientService {

//    @Resource
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getOne(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("aucun client trouvé avec cet ID"));
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client create(Client toCreate) {
        return clientRepository.save(toCreate);
    }

    @Override
    public Client update(Long id, Client toUpdate) {
        toUpdate.setId(id);
        return clientRepository.save(toUpdate);
    }

    @Override
    public Client delete(Long id) {
        Client toDelete = getOne(id);
        clientRepository.delete(toDelete);
        return toDelete;
    }

}
