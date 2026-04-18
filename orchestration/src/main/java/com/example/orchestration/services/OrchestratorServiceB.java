package com.example.orchestration.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.orchestration.clients.NotificationClient;
import com.example.orchestration.clients.OrderClient;
import com.example.orchestration.clients.PaymentClient;
import com.example.orchestration.clients.ShippingClient;
import com.example.orchestration.models.Order;

@Service
public class OrchestratorServiceB {

    private final OrderClient orderClient;
    private final PaymentClient paymentClient;
    private final ShippingClient shippingClient;
    private final NotificationClient notificationClient;

    public OrchestratorServiceB(OrderClient o, PaymentClient p, ShippingClient s, NotificationClient n){
        this.orderClient = o;
        this.paymentClient = p;
        this.shippingClient = s;
        this.notificationClient = n;
    }

    public ResponseEntity<?> process(Order order){

        log("Pedido Recebido");

        Double total = orderClient.createOrder(order);
        log("Total: " + total);

        boolean paid; 
        try {
            paid = paymentClient.pay();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro de Pagamento");
        }

        if(!paid){
            return ResponseEntity.badRequest().body("Pagamento falhou");
        }

        log("Pagamento Ok.");

        String status = shippingClient.ship();
        log("Envio: " + status);

        notificationClient.notify("Encomenda Enviada.");

        return ResponseEntity.ok("Processo Completo");
    }

    private void log(String msg) {
        System.out.println("[ORCHESTRATOR] " + msg);
    }
}
