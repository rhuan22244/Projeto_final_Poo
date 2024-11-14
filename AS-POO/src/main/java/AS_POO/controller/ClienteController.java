package AS_POO.controller;

import AS_POO.model.Cliente;
import AS_POO.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Get: Retorna todos os clientes
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @PostMapping
    public void adicionarCliente(@RequestBody Cliente cliente) {
        clienteService.adicionarCliente(cliente);
    }

    @PutMapping("/{id}")
    public void atualizarCliente(@PathVariable Long id ,@RequestBody Cliente cliente) {
        clienteService.atualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void removerCliente(@PathVariable Long id) {
        clienteService.removerCliente(id);
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @GetMapping("/filtrar")
    public List<Cliente> filtrarPorIdade(@RequestParam int idade) {
        return clienteService.filtrarPorIdade(idade);
    }
}
