package io.github.LeviSouza.clientes;

import io.github.LeviSouza.clientes.model.entity.Cliente;
import io.github.LeviSouza.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClienteApplication {

    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository repository){
        return args -> {
//            Cliente cliente = Cliente.builder().cpf("123456489").nome("Pedro").build();
//            repository.save(cliente);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ClienteApplication.class);
    }
}
