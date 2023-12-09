package com.std.ec.clients.model.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClientDTO {
    private Integer id;
    private String name;
    private String email;
    private String phone;
}
