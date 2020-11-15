package com.megshan.immiportalservice.domain.employment;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@Document(collection = "employment")
public class Employment {

    @Id
    private String userId;
    private List<Employer> employers;
}
