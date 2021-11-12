package com.example.so69901065;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class Address {
    @NotEmpty(message = "Street may not be empty")
    @Size(min = 2, max = 256)
    private String street;

    @NotEmpty(message = "Number may not be empty")
    @Size(min = 1, max = 5)
    private String number;

    @NotEmpty(message = "Postal code may not be empty")
    //@Field("postal_code")
    @JsonProperty("postal_code")
    @Size(min = 5, max = 6)
    private String postalCode;

    @NotEmpty(message = "City may not be empty")
    @Size(min = 2, max = 256)
    private String city;

    @NotEmpty(message = "Province may not be empty")
    @Size(min = 2, max = 256)
    private String province;

    @NotEmpty(message = "Country may not be empty")
    @Size(min = 2, max = 256)
    private String country;
}
