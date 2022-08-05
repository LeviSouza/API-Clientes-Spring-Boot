package io.github.LeviSouza.clientes.rest;

import io.github.LeviSouza.clientes.model.entity.Cliente;
import io.github.LeviSouza.clientes.model.entity.ServicoPrestado;
import io.github.LeviSouza.clientes.model.repository.ClienteRepository;
import io.github.LeviSouza.clientes.model.repository.ServicoPrestadoRepository;
import io.github.LeviSouza.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.LeviSouza.clientes.util.BigDecimalCenverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoRepository;
    private final BigDecimalCenverter bigDecimalCenverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO dto ){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cliente inexistente."));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalCenverter.converter(dto.getPreco()));

        return servicoRepository.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(@RequestParam (value = "nome",required = false,defaultValue = "") String nome,
    @RequestParam(value = "mes", required = false) Integer mes){

        return  servicoRepository.findByNomeAndMes("%" +nome + "%", mes);

    }
}
