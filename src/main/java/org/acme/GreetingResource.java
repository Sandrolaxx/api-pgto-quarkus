package org.acme;

import java.util.UUID;

import org.acme.dto.ConsultResponseDTO;
import org.acme.dto.ConsultaBoletoDTO;
import org.acme.dto.PaymentResponseDTO;
import org.acme.dto.TokenDTO;
import org.acme.model.Payment;
import org.acme.model.Token;
import org.acme.repositories.RepositoryPayment;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api")
public class GreetingResource {

    @Inject
    @RestClient
    MyRemoteService restClient;

    @Inject
    RepositoryPayment paymentRepo;

    @GET
    @Path("/token")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response hello() {
        TokenDTO dto = getToken();
        Token entity = new Token();

        entity.setToken(dto.getAccessToken());
        entity.persist();

        return Response.ok().build();
    }

    public TokenDTO getToken() {
        Form form = new Form();

        form.param("client_id", "41b44ab9a56440.teste.celcoinapi.v5");
        form.param("client_secret", "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");
        form.param("grant_type", "client_credentials");

        TokenDTO token = restClient.getToken(form);

        return token;
    }

    @POST
    @Path("/consult")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consult(ConsultaBoletoDTO dto) {
        ConsultResponseDTO response = restClient.consult("Bearer " + getToken().getAccessToken(), dto);

        return Response.ok().entity(response).build();
    }

    @POST
    @Path("/payment")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response payment(ConsultaBoletoDTO dto) {
        PaymentResponseDTO response = restClient.payment("Bearer " + getToken().getAccessToken(), dto);
        Payment entity = new Payment();

        entity.setId(UUID.randomUUID());
        entity.setAmount(dto.getBill().getValue());
        entity.setDigitable(dto.getData().getDigitable());
        entity.setReceipt(response.getReceipt().getReceiptformatted());

        paymentRepo.persist(entity);

        return Response.ok().entity(response).build();
    }

    @GET
    @Path("/payment/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPayments() {
        return Response.ok().entity(paymentRepo.listFull()).build();
    }

    @GET
    @Path("/payment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@HeaderParam("id") String id) {
        return Response.ok().entity(paymentRepo.findById(id)).build();
    }

    @PATCH
    @Path("/payment")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@HeaderParam("id") String id) {
        return Response.ok().entity(paymentRepo.update(id)).build();
    }

    @DELETE
    @Path("/payment")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@HeaderParam("id") String id) {
        return Response.ok().entity(paymentRepo.delete(id)).build();
    }

}
