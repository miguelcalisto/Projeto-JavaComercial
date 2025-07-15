--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5 (Debian 17.5-1.pgdg120+1)
-- Dumped by pg_dump version 17.5 (Debian 17.5-1.pgdg120+1)

-- Started on 2025-07-15 15:14:22 -03

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
-- TOC entry 217 (class 1259 OID 16509)
-- Name: aplicacao_vacina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aplicacao_vacina (
    id integer NOT NULL,
    data_aplicacao character varying,
    local_aplicacao character varying,
    paciente_id integer,
    profissional_saude_id integer,
    vacina_id integer
);


ALTER TABLE public.aplicacao_vacina OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16514)
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
-- TOC entry 3395 (class 0 OID 0)
-- Dependencies: 218
-- Name: aplicacaovacina_idaplicacaovacina_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.aplicacaovacina_idaplicacaovacina_seq OWNED BY public.aplicacao_vacina.id;


--
-- TOC entry 219 (class 1259 OID 16515)
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paciente (
    id integer NOT NULL,
    telefone character varying,
    data_nascimento character varying,
    alergias character varying,
    sexo character varying,
    cpf character varying,
    nome character varying
);


ALTER TABLE public.paciente OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16520)
-- Name: paciente_idpaciente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.paciente_idpaciente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.paciente_idpaciente_seq OWNER TO postgres;

--
-- TOC entry 3396 (class 0 OID 0)
-- Dependencies: 220
-- Name: paciente_idpaciente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.paciente_idpaciente_seq OWNED BY public.paciente.id;


--
-- TOC entry 221 (class 1259 OID 16521)
-- Name: profissional_saude; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profissional_saude (
    id integer NOT NULL,
    registro_profissional character varying,
    cpf character varying(14),
    nome character varying
);


ALTER TABLE public.profissional_saude OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16526)
-- Name: profissionalsaude_idprofissionalsaude_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profissionalsaude_idprofissionalsaude_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.profissionalsaude_idprofissionalsaude_seq OWNER TO postgres;

--
-- TOC entry 3397 (class 0 OID 0)
-- Dependencies: 222
-- Name: profissionalsaude_idprofissionalsaude_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profissionalsaude_idprofissionalsaude_seq OWNED BY public.profissional_saude.id;


--
-- TOC entry 223 (class 1259 OID 16527)
-- Name: vacina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vacina (
    id integer NOT NULL,
    nome character varying,
    fabricante character varying,
    doses_necessarias integer
);


ALTER TABLE public.vacina OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16532)
-- Name: vacina_idvacina_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vacina_idvacina_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.vacina_idvacina_seq OWNER TO postgres;

--
-- TOC entry 3398 (class 0 OID 0)
-- Dependencies: 224
-- Name: vacina_idvacina_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vacina_idvacina_seq OWNED BY public.vacina.id;


--
-- TOC entry 225 (class 1259 OID 16533)
-- Name: view_aplicacao_vacina; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.view_aplicacao_vacina AS
 SELECT av.id AS aplicacao_id,
    av.data_aplicacao,
    av.local_aplicacao,
    p.id AS paciente_id,
    p.nome AS paciente_nome,
    ps.id AS profissional_id,
    ps.nome AS profissional_nome,
    v.id AS vacina_id,
    v.nome AS vacina_nome,
    v.doses_necessarias AS vacina_doses_necessarias
   FROM (((public.aplicacao_vacina av
     JOIN public.paciente p ON ((av.paciente_id = p.id)))
     JOIN public.profissional_saude ps ON ((av.profissional_saude_id = ps.id)))
     JOIN public.vacina v ON ((av.vacina_id = v.id)));


ALTER VIEW public.view_aplicacao_vacina OWNER TO postgres;

--
-- TOC entry 3229 (class 2604 OID 16538)
-- Name: aplicacao_vacina id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aplicacao_vacina ALTER COLUMN id SET DEFAULT nextval('public.aplicacaovacina_idaplicacaovacina_seq'::regclass);


--
-- TOC entry 3230 (class 2604 OID 16539)
-- Name: paciente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente ALTER COLUMN id SET DEFAULT nextval('public.paciente_idpaciente_seq'::regclass);


--
-- TOC entry 3231 (class 2604 OID 16540)
-- Name: profissional_saude id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profissional_saude ALTER COLUMN id SET DEFAULT nextval('public.profissionalsaude_idprofissionalsaude_seq'::regclass);


--
-- TOC entry 3232 (class 2604 OID 16541)
-- Name: vacina id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vacina ALTER COLUMN id SET DEFAULT nextval('public.vacina_idvacina_seq'::regclass);


--
-- TOC entry 3234 (class 2606 OID 16543)
-- Name: aplicacao_vacina aplicacao_vacina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aplicacao_vacina
    ADD CONSTRAINT aplicacao_vacina_pkey PRIMARY KEY (id);


--
-- TOC entry 3236 (class 2606 OID 16545)
-- Name: paciente paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (id);


--
-- TOC entry 3238 (class 2606 OID 16547)
-- Name: profissional_saude profissionalsaude_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profissional_saude
    ADD CONSTRAINT profissionalsaude_pkey PRIMARY KEY (id);


--
-- TOC entry 3240 (class 2606 OID 16549)
-- Name: vacina vacina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vacina
    ADD CONSTRAINT vacina_pkey PRIMARY KEY (id);


--
-- TOC entry 3241 (class 2606 OID 16550)
-- Name: aplicacao_vacina fk_aplicacao_vacina_paciente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aplicacao_vacina
    ADD CONSTRAINT fk_aplicacao_vacina_paciente FOREIGN KEY (paciente_id) REFERENCES public.paciente(id);


--
-- TOC entry 3242 (class 2606 OID 16555)
-- Name: aplicacao_vacina fk_aplicacao_vacina_profissional_saude; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aplicacao_vacina
    ADD CONSTRAINT fk_aplicacao_vacina_profissional_saude FOREIGN KEY (profissional_saude_id) REFERENCES public.profissional_saude(id);


--
-- TOC entry 3243 (class 2606 OID 16560)
-- Name: aplicacao_vacina fk_aplicacao_vacina_vacina; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aplicacao_vacina
    ADD CONSTRAINT fk_aplicacao_vacina_vacina FOREIGN KEY (vacina_id) REFERENCES public.vacina(id);


-- Completed on 2025-07-15 15:14:22 -03

--
-- PostgreSQL database dump complete
--

