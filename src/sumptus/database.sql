--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2017-01-09 23:40:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2036 (class 1262 OID 32840)
-- Name: sumptus; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE sumptus WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE sumptus OWNER TO postgres;

\connect sumptus

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 180 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2039 (class 0 OID 0)
-- Dependencies: 180
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 176 (class 1259 OID 32868)
-- Name: areas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE areas (
    id integer NOT NULL,
    area character varying(250) NOT NULL
);


ALTER TABLE areas OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 32871)
-- Name: areas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE areas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE areas_id_seq OWNER TO postgres;

--
-- TOC entry 2040 (class 0 OID 0)
-- Dependencies: 177
-- Name: areas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE areas_id_seq OWNED BY areas.id;


--
-- TOC entry 178 (class 1259 OID 32881)
-- Name: outlays; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE outlays (
    id integer NOT NULL,
    user_id integer NOT NULL,
    area_id integer NOT NULL,
    payform_id integer NOT NULL,
    description text,
    cost numeric NOT NULL,
    purchase_date date NOT NULL,
    payment_day date NOT NULL,
    paid boolean DEFAULT false,
    true_value numeric,
    percentage double precision,
    true_payday date
);


ALTER TABLE outlays OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 32884)
-- Name: outlays_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE outlays_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE outlays_id_seq OWNER TO postgres;

--
-- TOC entry 2041 (class 0 OID 0)
-- Dependencies: 179
-- Name: outlays_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE outlays_id_seq OWNED BY outlays.id;


--
-- TOC entry 174 (class 1259 OID 32854)
-- Name: payforms; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE payforms (
    id integer NOT NULL,
    form character varying(15) NOT NULL
);


ALTER TABLE payforms OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 32859)
-- Name: payforms_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE payforms_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE payforms_id_seq OWNER TO postgres;

--
-- TOC entry 2042 (class 0 OID 0)
-- Dependencies: 175
-- Name: payforms_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE payforms_id_seq OWNED BY payforms.id;


--
-- TOC entry 172 (class 1259 OID 32841)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    login character varying(15) NOT NULL,
    password character varying(255) NOT NULL,
    admin boolean DEFAULT false NOT NULL,
    created timestamp with time zone
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 32844)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO postgres;

--
-- TOC entry 2043 (class 0 OID 0)
-- Dependencies: 173
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 1904 (class 2604 OID 32873)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY areas ALTER COLUMN id SET DEFAULT nextval('areas_id_seq'::regclass);


--
-- TOC entry 1905 (class 2604 OID 32886)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY outlays ALTER COLUMN id SET DEFAULT nextval('outlays_id_seq'::regclass);


--
-- TOC entry 1903 (class 2604 OID 32861)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY payforms ALTER COLUMN id SET DEFAULT nextval('payforms_id_seq'::regclass);


--
-- TOC entry 1901 (class 2604 OID 32846)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 1914 (class 2606 OID 32878)
-- Name: area_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY areas
    ADD CONSTRAINT area_pkey PRIMARY KEY (id);


--
-- TOC entry 1919 (class 2606 OID 32901)
-- Name: outlay_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY outlays
    ADD CONSTRAINT outlay_pkey PRIMARY KEY (id);


--
-- TOC entry 1912 (class 2606 OID 32880)
-- Name: payform_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY payforms
    ADD CONSTRAINT payform_pkey PRIMARY KEY (id);


--
-- TOC entry 1908 (class 2606 OID 41046)
-- Name: user_login_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT user_login_unique UNIQUE (login);


--
-- TOC entry 1910 (class 2606 OID 32858)
-- Name: user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 1915 (class 1259 OID 32914)
-- Name: fki_area_id_fkey; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_area_id_fkey ON outlays USING btree (area_id);


--
-- TOC entry 1916 (class 1259 OID 32920)
-- Name: fki_payform_id_fkey; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_payform_id_fkey ON outlays USING btree (payform_id);


--
-- TOC entry 1917 (class 1259 OID 32907)
-- Name: fki_user_id_fkey; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_user_id_fkey ON outlays USING btree (user_id);


--
-- TOC entry 1921 (class 2606 OID 32909)
-- Name: area_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY outlays
    ADD CONSTRAINT area_id_fkey FOREIGN KEY (area_id) REFERENCES areas(id);


--
-- TOC entry 1922 (class 2606 OID 32915)
-- Name: payform_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY outlays
    ADD CONSTRAINT payform_id_fkey FOREIGN KEY (payform_id) REFERENCES payforms(id);


--
-- TOC entry 1920 (class 2606 OID 32902)
-- Name: user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY outlays
    ADD CONSTRAINT user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2038 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-01-09 23:40:23

--
-- PostgreSQL database dump complete
--

