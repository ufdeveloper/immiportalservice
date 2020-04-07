package com.megshan.immiportalservice.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "listingsAndReviews")
public class UserData {

    @Id
    private String _id;
    private String listing_url;
    private String name;

}
