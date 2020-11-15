package com.megshan.immiportalservice.domain.employment;

import com.megshan.immiportalservice.domain.Address;
import lombok.Data;

@Data
public class Employer {

    private String id;
    private String name;
    private String title;
//    private Address address;
    // format - mm/dd/yyyy
    // TODO - use java.util.Date and convert to BSON and vice versa
    private String fromDate;
    private String toDate;
    private boolean currentEmployer;
}
