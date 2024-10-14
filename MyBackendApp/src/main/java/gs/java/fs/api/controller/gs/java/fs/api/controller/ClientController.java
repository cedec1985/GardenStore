package gs.java.fs.api.controller;

import gs.java.fs.api.models.dtos.ClientDTO;
import gs.java.fs.api.models.form.ClientForm;
import gs.java.fs.bll.AuthRequest;
import gs.java.fs.bll.AuthResponse;
import gs.java.fs.bll.ClientService;
import gs.java.fs.domain.entities.Client;
import gs.java.fs.utils.JwtTokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")

public class ClientController {
    private final ClientService clientService;

    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;

    }
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAll() {
        List<Client> users = clientService.getAll();
        List<ClientDTO> dtos = users.stream()
                .map(ClientDTO::fromEntity)
                .toList();
        return ResponseEntity.ok( dtos );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getOne(@PathVariable Long id) {
        Client user = clientService.getOne(id);
        ClientDTO dto = ClientDTO.fromEntity(user);
        return ResponseEntity.ok(dto);
    }
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/insert")
    public ResponseEntity<ClientDTO> create(@RequestBody @Valid ClientForm form){
        Client user = clientService.create( form.ToEntity());
        ClientDTO dto = ClientDTO.fromEntity(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody @Valid ClientForm form) {
        Client toUpdate = clientService.getOne(id);
        toUpdate.setPassword(form.ToEntity().getPassword());
        Client user = clientService.update(toUpdate.getId(), toUpdate);
        return ResponseEntity.ok(
                ClientDTO.fromEntity(user)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable Long id) {
        Client user = clientService.delete( id );
        ClientDTO dto = ClientDTO.fromEntity( user );
        return ResponseEntity.ok( dto );
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword()
                    )
            );

            Client user = (Client) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getMail(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
