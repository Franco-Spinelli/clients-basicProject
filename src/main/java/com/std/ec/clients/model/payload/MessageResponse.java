package com.std.ec.clients.model.payload;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder
public class MessageResponse implements Serializable {
    private String message;
    private Object object;
}
