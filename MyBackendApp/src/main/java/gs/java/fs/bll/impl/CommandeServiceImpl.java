package gs.java.fs.bll.impl;

import gs.java.fs.bll.CommandeService;
import gs.java.fs.dal.CommandeRepository;
import gs.java.fs.domain.entities.Commande;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }
    @Override
    public Commande register(Commande commande) {
        // return commandeRepository.findById(commande.getId()).orElseThrow(() -> new RuntimeException("aucun client trouvé avec cet ID"));
        return commandeRepository.save(commande);
    }
       
    @Override
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande getOne(Long id) {
        return commandeRepository.findById(id).orElseThrow(()->new RuntimeException("aucune commnde trouvée avec cet ID"));
    }
    @Override
    public boolean cancel(Long id) {
        Commande commande = getOne(id);
        commandeRepository.delete(commande);
        return false;
    }
    @Override
    public Commande update(Long id, Commande commande) {
        commande.setId(id);
        return commandeRepository.save(commande);
    }

}