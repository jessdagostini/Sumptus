CREATE TABLE areas
(
  id serial NOT NULL,
  area character varying(255) NOT NULL,
  CONSTRAINT area_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE areas
  OWNER TO postgres;

CREATE TABLE payforms
(
  id serial NOT NULL,
  name character varying(255),
  CONSTRAINT payform_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE payforms
  OWNER TO postgres;

CREATE TABLE users
(
  id serial NOT NULL,
  name character varying(255) NOT NULL,
  login character varying(20) NOT NULL,
  password character varying(255),
  admin boolean DEFAULT false,
  created timestamp without time zone,
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;


CREATE TABLE outlays
(
  id serial NOT NULL,
  user_id integer NOT NULL,
  payform_id integer NOT NULL,
  description text,
  area_id integer NOT NULL,
  cost numeric,
  purchase_date date,
  payment_day timestamp without time zone,
  paid boolean DEFAULT false,
  CONSTRAINT outlays_pkey PRIMARY KEY (id),
  CONSTRAINT outlay_area_id FOREIGN KEY (area_id)
      REFERENCES areas (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT outlay_payform_id FOREIGN KEY (payform_id)
      REFERENCES payforms (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT outlay_user_id FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE outlays
  OWNER TO postgres;

-- Index: fki_outlay_area_id

-- DROP INDEX fki_outlay_area_id;

CREATE INDEX fki_outlay_area_id
  ON outlays
  USING btree
  (area_id);

-- Index: fki_outlay_payform_id

-- DROP INDEX fki_outlay_payform_id;

CREATE INDEX fki_outlay_payform_id
  ON outlays
  USING btree
  (payform_id);

-- Index: fki_outlay_user_id

-- DROP INDEX fki_outlay_user_id;

CREATE INDEX fki_outlay_user_id
  ON outlays
  USING btree
  (user_id);
