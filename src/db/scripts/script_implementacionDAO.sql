

CREATE TABLE persons(
    id int AUTO_INCREMENT,
    name VARCHAR(20),
    last_name VARCHAR(20),
    PRIMARY KEY (id)
);

CREATE table users(
    id int AUTO_INCREMENT,
    person_id_fk int,
    
    PRIMARY KEY (id),
    FORREING KEY(person_id_fk) references persons(id)
);

