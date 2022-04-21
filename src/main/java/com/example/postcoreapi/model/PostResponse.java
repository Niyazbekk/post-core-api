package com.example.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponse {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String postID;
    private String clientID;
    private String postRecipientId;
    private String postItem;
    private String status;
}
