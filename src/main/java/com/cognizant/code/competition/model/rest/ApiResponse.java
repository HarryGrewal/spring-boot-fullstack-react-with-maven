package com.cognizant.code.competition.model.rest;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponse {

    private String warnings;

    private String errors;

    private String result;

    private String stats;

    private String files;

    private String notLoggedIn;

}
