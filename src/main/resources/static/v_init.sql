CREATE TABLE post_model
(
    id                BIGINT NOT NULL,
    postid            VARCHAR(255),
    clientid          VARCHAR(255),
    post_recipient_id VARCHAR(255),
    post_item         VARCHAR(255),
    status            VARCHAR(255),
    CONSTRAINT pk_post_model PRIMARY KEY (id)
);

SELECT * FROM post_model;