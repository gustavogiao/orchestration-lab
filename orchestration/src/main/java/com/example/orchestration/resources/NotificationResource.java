package com.example.orchestration.resources;

import com.example.orchestration.models.NotificationRequest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/notifications")
public class NotificationResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response sendNotification(NotificationRequest request) {

        if (request == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Pedido de notificação inválido.")
                    .build();
        }

        if (request.getClientName() == null || request.getClientName().isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Nome do cliente inválido.")
                    .build();
        }

        if (request.getClientEmail() == null || request.getClientEmail().isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Email do cliente inválido.")
                    .build();
        }

        if (request.getOrderId() <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Número do pedido inválido.")
                    .build();
        }

        if (request.getOrderStatus() == null || request.getOrderStatus().isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Estado do pedido inválido.")
                    .build();
        }

        String msg = "Notificação enviada com sucesso para "
                + request.getClientName()
                + " (" + request.getClientEmail() + ")"
                + " sobre o pedido " + request.getOrderId()
                + " com estado: " + request.getOrderStatus();

        return Response.ok(msg).build();
    }
}
