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
    public PagamentoDTO cadastrar(@RequestBody @Valid PagamentoDTO dto) {

        return pagamentoService.criarPagamento(dto);

    }

}
