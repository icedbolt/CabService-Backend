package com.mycab.safar.domain.request;

import com.mycab.safar.domain.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocationRequest {
    Location source;
    Location destination;
}
