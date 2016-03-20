# sky schema

# --- !Ups

CREATE TABLE catalogue (
  id            BIGINT(20)   NOT NULL AUTO_INCREMENT,
  category        VARCHAR(255),
  location_id     BIGINT(20),
  location        VARCHAR(255),
  product         VARCHAR(255),
  PRIMARY KEY (id)
);


insert into catalogue(category, location_id, location, product) values ('Sports', 1, 'London', 'Arsenal TV');
insert into catalogue(category, location_id, location, product) values ('Sports', 1, 'London', 'Chelsea TV');
insert into catalogue(category, location_id, location, product) values ('Sports', 2, 'Liverpool', 'Liverpool TV');
insert into catalogue(category, product) values ('News','Sky News');
insert into catalogue(category, product) values ('News','Sky Sports News');

# --- !Downs

DROP TABLE catalogue;