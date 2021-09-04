package mk.ukim.finki.emt.ordermanagement.domain.dto;

import lombok.Data;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Adopter;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.AdopterId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Pet;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.PetId;

@Data
public class OrderInfoDtoResponse {
    OrderId orderId;
    Boolean isApproved;
    Pet pet;
    Adopter adopter;




}
