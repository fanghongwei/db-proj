CREATE TABLE relationship
(
  id bigint NOT NULL AUTO_INCREMENT,
  child bigint NOT NULL,
  parent bigint,
  primary key (id)
)