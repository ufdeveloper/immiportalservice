package com.megshan.immiportalservice.domain.travel;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@Document(collection = "travelHistory")
public class TravelHistory {

    @Id
    private String userId;
    private List<Travel> travelHistory;
}
