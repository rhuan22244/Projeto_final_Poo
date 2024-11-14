package AS_POO.service;

import AS_POO.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public List<Cliente> listarTodos(){
        return clientes;
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void atualizarCliente(Long id, Cliente clienteAtualizado){
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)){
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setEmail(clienteAtualizado.getEmail());
                cliente.setTelefone(clienteAtualizado.getTelefone());
                cliente.setCpf(clienteAtualizado.getCpf());

                int indexDaLista = clientes.indexOf(cliente);
                clientes.set(indexDaLista, cliente);
                return;
            }
        }
    }

    public void removerCliente(Long id){
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }

    public Cliente buscarPorId(Long id){
        return clientes.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Cliente> filtrarPorIdade(int idade) {
        return clientes.stream()
                .filter(cliente -> cliente.getIdade() == idade)
                .collect(Collectors.toList());
    }
}
