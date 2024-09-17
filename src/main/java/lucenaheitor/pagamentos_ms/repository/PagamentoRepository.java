package lucenaheitor.pagamentos_ms.repository;

import lucenaheitor.pagamentos_ms.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
