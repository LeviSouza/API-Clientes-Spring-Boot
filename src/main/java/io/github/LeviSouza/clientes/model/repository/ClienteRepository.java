package io.github.LeviSouza.clientes.model.repository;

import io.github.LeviSouza.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
