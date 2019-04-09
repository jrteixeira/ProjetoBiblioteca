# ProjetoBiblioteca

Especificações:
Linguagem: Java 8.0
IDE:NetBeans 8.0.1
Banco de Dados: PostgreSQL
Bibliotecas: Driver EclipseLInk (JPA 2.1) / Driver JDBC do PostgreSQl/  postgresql-42.2.5.jar 
        

-Baixar e instalar a IDE NetBeans
https://netbeans.org/downloads/8.0.1/?pagelang=pt_BR
-Baixar e instalar o BD PostgreSql
https://www.enterprisedb.com/downloads/postgres-postgresql-downloads


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



----------------

Abrir o projeto na IDE, e verificar se a dependencia do JAR do postgresql-42.2.5.jar está importada corretamente, caso não estiver importar o arquivo postgresql-42.2.5.jar que encontar-se na raiz do projeto.






