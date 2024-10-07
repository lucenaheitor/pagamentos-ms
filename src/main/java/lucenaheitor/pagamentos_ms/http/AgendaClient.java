package lucenaheitor.pagamentos_ms.http;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("barbearia-api")
public interface AgendaClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/agenda/{id}/pago")
     void updatePayment(@PathVariable Long id);
}

