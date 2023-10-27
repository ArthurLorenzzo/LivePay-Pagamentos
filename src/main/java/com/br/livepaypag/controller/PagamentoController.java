package com.br.livepaypag.controller;

import com.br.livepaypag.dto.LerPagamentoDTO;
import com.br.livepaypag.dto.PagamentoDTO;
import com.br.livepaypag.service.PagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;
    @GetMapping
    public Page<LerPagamentoDTO> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return pagamentoService.obterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LerPagamentoDTO> detalhar(@PathVariable @NotNull Long id) {
        LerPagamentoDTO dto = pagamentoService.obterPorId(id);

        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<PagamentoDTO> cadastrar(@RequestBody @Valid PagamentoDTO dto) {
        PagamentoDTO pagamento = pagamentoService.criarPagamento(dto);

        return ResponseEntity.ok(pagamento);
    }

    @PostMapping("/{id}")
    public ResponseEntity<PagamentoDTO> confirmarPagamento(@PathVariable @NotNull Long id) {
        pagamentoService.confirmarPagamento(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PagamentoDTO> remover(@PathVariable @NotNull Long id) {
        pagamentoService.excluirPagamento(id);
        return ResponseEntity.noContent().build();
    }

}
