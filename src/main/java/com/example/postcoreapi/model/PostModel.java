package com.example.postcoreapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {

    @NotNull
    private String postID;
    @NotNull(message = "clientID can not be empty")
    private String clientID;
    @NotNull(message = "postRecipientId can not be empty")
    private String postRecipientId;
    private String postItem;
    private String status;

}
