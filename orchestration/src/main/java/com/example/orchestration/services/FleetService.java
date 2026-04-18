package com.example.orchestration.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.orchestration.models.TransportRequest;

@Service
public class FleetService {

    private Map<Integer, TransportRequest> requests = new HashMap<>();
    private int counter = 1;

    public TransportRequest create(TransportRequest req){

        if(req.getPassengers() <= 0 || req.getOrigin() == null || req.getDestination() == null){
            throw new RuntimeException("Dados Inválidos, vejá lá isso.");
        }

        req.setId(counter++);

        // logica simples para exame sei la
        double cost = req.getPassengers() * 10;
        req.setCost(cost);

        req.setStatus("PENDING");

        requests.put(req.getId(), req);

        return req;
    }

    public String confirm(int id, boolean paymentConfirmed, boolean notified){

        TransportRequest req = requests.get(id);

        if(req == null){
            return "Pedido não existe";
        }

        if(!paymentConfirmed){
            req.setStatus("CANCELLED");
            return "Cancelado por Falta de Pagamento";
        }

        req.setStatus("CONFIRMED");
        return "Reserva confirmada";
    }

    public TransportRequest get(int id){
        return requests.get(id);
    }

}
