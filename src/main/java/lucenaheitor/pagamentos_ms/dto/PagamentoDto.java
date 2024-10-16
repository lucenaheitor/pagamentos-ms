package lucenaheitor.pagamentos_ms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lucenaheitor.pagamentos_ms.model.Status;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDto {
    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Long formaDePagamentoId;
    private Long AgendaId;
}
