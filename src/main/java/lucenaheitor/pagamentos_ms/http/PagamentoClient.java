package lucenaheitor.pagamentos_ms.http;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface PagamentoClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/pagamento-cliente/{id}/pago")
    void atualizaPagamento(@PathVariable Long id);
}

