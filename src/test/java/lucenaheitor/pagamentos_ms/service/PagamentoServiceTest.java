package lucenaheitor.pagamentos_ms.service;

import lucenaheitor.pagamentos_ms.dto.PagamentoDto;
import lucenaheitor.pagamentos_ms.model.Pagamento;
import lucenaheitor.pagamentos_ms.model.Status;
import lucenaheitor.pagamentos_ms.repository.PagamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PagamentoServiceTest {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @InjectMocks
    private PagamentoService pagamentoService;

    private PagamentoDto dto;
    private Pagamento pagamento;

    @Autowired
    private PagamentoDto pagamentoDto;


    @Test
    void criarPagamento() {

        dto = new PagamentoDto(
                1L, // id
                new BigDecimal("100.00"), // valor
                "Nome Exemplo", // nome
                "1234567890123456", // número
                "12/23", // expiração
                "123", // código
                Status.CRIADO, // status
                1L, // formaDePagamentoId
                1L // agendaId
        );

        pagamento = new Pagamento();
        pagamento.setStatus(Status.CRIADO);
        when(modelMapper.map(dto, Pagamento.class)).thenReturn(pagamento);
        when(modelMapper.map(pagamento, PagamentoDto.class)).thenReturn(dto);

        PagamentoDto resultado = pagamentoService.criarPagamento(dto);

        verify(pagamentoRepository, times(1)).save(pagamento);
        assertEquals(Status.CRIADO, pagamento.getStatus());
        assertNotNull(resultado);
    }

    @Test
    void atualizarPagamento() {
    PagamentoDto dto = new PagamentoDto(
            1L,
            new BigDecimal("100.00"),
            "Teste",
            "123456789123456",
            "12/24",
            "123",
             Status.CRIADO,
            1L,
            1L
    );


        when(pagamentoRepository.findById(1L)).thenReturn(java.util.Optional.of(pagamento));
        when(modelMapper.map(dto, Pagamento.class)).thenReturn(pagamento);


        pagamento.setStatus(Status.CONFIRMADO);


        when(modelMapper.map(pagamento, PagamentoDto.class)).thenReturn(dto);

        PagamentoDto resultado = pagamentoService.atualizarPagamento(1L, dto);

        verify(pagamentoRepository, times(1)).save(pagamento);
        assertEquals(Status.CONFIRMADO, pagamento.getStatus());
        assertNotNull(resultado);

    }

    @Test
    void confirmarPagamento() {
        Pagamento pagamento = new Pagamento(
                1L,
                new BigDecimal("100.00"),
                "Teste",
                "123456789123456",
                "12/24",
                "123",
                Status.CRIADO,
                1L,
                1L

        );
        pagamento.setStatus(Status.CONFIRMADO);

        when(pagamentoRepository.findById(1L)).thenReturn(java.util.Optional.of(pagamento));
        when(modelMapper.map(pagamento, PagamentoDto.class)).thenReturn(pagamentoDto);

        assertEquals(Status.CONFIRMADO, pagamento.getStatus());
    }

    @Test
    void alteraStatus() {
        Pagamento pagamento  = new Pagamento(
                1L,
                new BigDecimal("100.00"),
                "Teste",
                "123456789123456",
                "12/24",
                "123",
                Status.CRIADO,
                1L,
                1L
        );

        pagamento.setStatus(Status.CONFIRMADO);

        when((pagamentoRepository.findById(1L))).thenReturn(java.util.Optional.of(pagamento));
        when(modelMapper.map(pagamento, PagamentoDto.class)).thenReturn(pagamentoDto);

        assertEquals(Status.CONFIRMADO, pagamento.getStatus());

    }
}