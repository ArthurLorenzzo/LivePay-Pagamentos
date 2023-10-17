package com.br.livepaypag.service;

import com.br.livepaypag.dto.LerPagamentoDTO;
import com.br.livepaypag.dto.PagamentoDTO;
import com.br.livepaypag.model.Pagamento;
import com.br.livepaypag.model.Status;
import com.br.livepaypag.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    private ModelMapper modelMapper;

    public Page<LerPagamentoDTO> obterTodos(Pageable pageable){
        return pagamentoRepository
                .findAll(pageable)
                .map(p -> modelMapper.map(p, LerPagamentoDTO.class));
    }

    public LerPagamentoDTO obterPorId(Long id){
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(pagamento, LerPagamentoDTO.class);
    }

    public PagamentoDTO criarPagamento(PagamentoDTO pagamentoDTO){
        Pagamento pagamento = modelMapper.map(pagamentoDTO, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        pagamentoRepository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDTO.class);
    }

    public void excluirPagamento(Long id) {
        pagamentoRepository.deleteById(id);
    }

}
