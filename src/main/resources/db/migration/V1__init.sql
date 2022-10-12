CREATE TABLE location (
    id bigint GENERATED ALWAYS AS IDENTITY,
    city_name varchar(255),
    country_name varchar(255),
    hotel_name varchar(255),
    latitude varchar(255),
    longitude varchar(255),
    trip_id bigint,
    PRIMARY KEY (id)
    );

CREATE TABLE trip (
    id bigint GENERATED ALWAYS AS IDENTITY,
    start_date TIMESTAMP(6) WITHOUT TIME ZONE,
    end_date TIMESTAMP(6) WITHOUT TIME ZONE,
    meal  varchar(20),
    location_id bigint,
    PRIMARY KEY (id)
    );



CREATE TABLE personal_info (
    id bigint GENERATED ALWAYS AS IDENTITY,
    address varchar(255),
    email varchar(255),
    phone varchar(15),
    traveler_id bigint,
    PRIMARY KEY (id)
    );

CREATE TABLE traveler (
    id bigint GENERATED ALWAYS AS IDENTITY,
    age int,
    first_name varchar(255),
    last_name varchar(255),
    personal_info_id bigint,
    PRIMARY KEY (id)
    );

CREATE TABLE traveler_list (
    trip_id bigint NOT NULL,
    traveler_id bigint NOT NULL,
    FOREIGN KEY (traveler_id) REFERENCES traveler (id),
    FOREIGN KEY (trip_id) REFERENCES trip (id)
    );

ALTER TABLE trip add FOREIGN KEY (location_id) REFERENCES location (id);
ALTER TABLE location add FOREIGN KEY (trip_id) REFERENCES trip (id);
ALTER TABLE personal_info add FOREIGN KEY (traveler_id) REFERENCES traveler (id);
ALTER TABLE traveler add FOREIGN KEY (personal_info_id) REFERENCES personal_info (id);