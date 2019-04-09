# ProjetoBiblioteca

Especificações:
Linguagem: Java 8.0
IDE:NetBeans 8.0.1
Banco de Dados: PostgreSQL
Bibliotecas: Driver EclipseLInk (JPA 2.1) / Driver JDBC do PostgreSQl/  postgresql-42.2.5.jar 
        

-Baixar e instalar a IDE NetBeans
-Baixar e instalar o BD PostgreSql
-acessar o link para download


Criar um banco de dados com o nome "biblioteca"
Logo após isso criar as tabelas abaixo: 
-------------


CREATE TABLE public.autor
(
    id integer NOT NULL DEFAULT nextval('id_autor'::regclass),
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT autor_nome_key UNIQUE (nome)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.autor
    OWNER to postgres;

CREATE TABLE public.livro
(
    id integer NOT NULL DEFAULT nextval('id_livro'::regclass),
    titulo character varying(50) COLLATE pg_catalog."default",
    lancamento character varying(50) COLLATE pg_catalog."default",
    autor character varying(50) COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.livro
    OWNER to postgres;

CREATE TABLE public.usuario
(
    id integer DEFAULT nextval('user_seq'::regclass),
    nome character varying(50) COLLATE pg_catalog."default",
    login character varying(50) COLLATE pg_catalog."default",
    senha character varying(50) COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to postgres;
