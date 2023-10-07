package org.acme;

import org.acme.dto.ConsultResponseDTO;
import org.acme.dto.ConsultaBoletoDTO;
import org.acme.dto.PaymentResponseDTO;
import org.acme.dto.TokenDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = " https://sandbox.openfinance.celcoin.dev")
public interface MyRemoteService {

    @POST
    @Path("/v5/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    TokenDTO getToken(Form form);

    @POST
    @Path("/v5/transactions/billpayments/authorize")
    ConsultResponseDTO consult(@HeaderParam("Authorization") String token, ConsultaBoletoDTO dto);

    @POST
    @Path("/v5/transactions/billpayments")
    PaymentResponseDTO payment(@HeaderParam("Authorization") String token, ConsultaBoletoDTO dto);

}
