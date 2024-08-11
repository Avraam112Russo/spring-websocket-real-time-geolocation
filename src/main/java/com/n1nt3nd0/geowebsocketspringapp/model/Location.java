package com.n1nt3nd0.geowebsocketspringapp.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Location {
    private String sender;
    private String recipient;
    private double latitude;
    private double longitude;
}
