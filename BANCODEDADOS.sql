--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5 (Debian 17.5-1.pgdg120+1)
-- Dumped by pg_dump version 17.5 (Debian 17.5-1.pgdg120+1)

-- Started on 2025-06-11 11:54:39 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 16465)
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paciente (
    cpf character varying(14),
    nome character varying(50),
    telefone character varying(20),
    datanascimento date,
    alergia character varying(50),
    idpaciente integer NOT NULL,
    sexo character varying
);


ALTER TABLE public.paciente OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16468)
-- Name: Paciente_idpaciente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Paciente_idpaciente_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Paciente_idpaciente_seq" OWNER TO postgres;

--
-- TOC entry 3388 (class 0 OID 0)
-- Dependencies: 218
-- Name: Paciente_idpaciente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Paciente_idpaciente_seq" OWNED BY public.paciente.idpaciente;


--
-- TOC entry 219 (class 1259 OID 16469)
-- Name: aplicacaovacina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aplicacaovacina (
    dataaplicacao character varying(20),
    localaplicacao character varying(50),
    idaplicacaovacina integer NOT NULL,
    paciente integer,
    vacina integer,
    responsavel integer
);


ALTER TABLE public.aplicacaovacina OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16472)
-- Name: aplicacaovacina_idaplicacaovacina_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.aplicacaovacina_idaplicacaovacina_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.aplicacaovacina_idaplicacaovacina_seq OWNER TO postgres;

--
-- TOC entry 3389 (class 0 OID 0)
-- Dependencies: 220
-- Name: aplicacaovacina_idaplicacaovacina_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.aplicacaovacina_idaplicacaovacina_seq OWNED BY public.aplicacaovacina.idaplicacaovacina;


--
-- TOC entry 221 (class 1259 OID 16473)
-- Name: profissionaldesaude; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profissionaldesaude (
    registroprofissional integer,
    nome character varying(50),
    cpf character varying(14),
    idprofissionalidesaude integer NOT NULL
);


ALTER TABLE public.profissionaldesaude OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16476)
-- Name: profissionalDeSaude_idprofissionalidesaude_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."profissionalDeSaude_idprofissionalidesaude_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."profissionalDeSaude_idprofissionalidesaude_seq" OWNER TO postgres;

--
-- TOC entry 3390 (class 0 OID 0)
-- Dependencies: 222
-- Name: profissionalDeSaude_idprofissionalidesaude_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."profissionalDeSaude_idprofissionalidesaude_seq" OWNED BY public.profissionaldesaude.idprofissionalidesaude;


--
-- TOC entry 223 (class 1259 OID 16477)
-- Name: vacina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vacina (
    nome character varying(50),
    fabricante character varying(50),
    dosesnecessarias integer,
    idvacina integer NOT NULL
);


ALTER TABLE public.vacina OWNER TO postgres;

--
-- TOC entry 3225 (class 2604 OID 16480)
-- Name: aplicacaovacina idaplicacaovacina; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aplicacaovacina ALTER COLUMN idaplicacaovacina SET DEFAULT nextval('public.aplicacaovacina_idaplicacaovacina_seq'::regclass);


--
-- TOC entry 3224 (class 2604 OID 16481)
-- Name: paciente idpaciente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente ALTER COLUMN idpaciente SET DEFAULT nextval('public."Paciente_idpaciente_seq"'::regclass);


--
-- TOC entry 3226 (class 2604 OID 16482)
-- Name: profissionaldesaude idprofissionalidesaude; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profissionaldesaude ALTER COLUMN idprofissionalidesaude SET DEFAULT nextval('public."profissionalDeSaude_idprofissionalidesaude_seq"'::regclass);


--
-- TOC entry 3228 (class 2606 OID 16484)
-- Name: paciente Paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT "Paciente_pkey" PRIMARY KEY (idpaciente);


--
-- TOC entry 3230 (class 2606 OID 16486)
-- Name: aplicacaovacina aplicacaovacina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aplicacaovacina
    ADD CONSTRAINT aplicacaovacina_pkey PRIMARY KEY (idaplicacaovacina);


--
-- TOC entry 3232 (class 2606 OID 16488)
-- Name: profissionaldesaude profissionaldesaude_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profissionaldesaude
    ADD CONSTRAINT profissionaldesaude_pkey PRIMARY KEY (idprofissionalidesaude);


--
-- TOC entry 3234 (class 2606 OID 16490)
-- Name: vacina vacina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vacina
    ADD CONSTRAINT vacina_pkey PRIMARY KEY (idvacina);


--
-- TOC entry 3235 (class 2606 OID 16491)
-- Name: aplicacaovacina fk_paciente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aplicacaovacina
    ADD CONSTRAINT fk_paciente FOREIGN KEY (paciente) REFERENCES public.paciente(idpaciente);


--
-- TOC entry 3236 (class 2606 OID 16496)
-- Name: aplicacaovacina fk_responsavel; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aplicacaovacina
    ADD CONSTRAINT fk_responsavel FOREIGN KEY (responsavel) REFERENCES public.profissionaldesaude(idprofissionalidesaude) NOT VALID;


--
-- TOC entry 3237 (class 2606 OID 16501)
-- Name: aplicacaovacina fk_vacina; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aplicacaovacina
    ADD CONSTRAINT fk_vacina FOREIGN KEY (vacina) REFERENCES public.vacina(idvacina) NOT VALID;


-- Completed on 2025-06-11 11:54:40 -03

--
-- PostgreSQL database dump complete
--

