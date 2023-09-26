<h1> Este projeto consiste na elaboração de um programa para gerenciar os horários de um semestre das turmas do curso do Bacharelado em Tecnologia da Informação (BTI) do Campus Pau dos Ferros (CMPF) da Universidade Federal Rural do Semi-Árido (UFERSA).</h1>

<h2> Para ser possível a execução é necessario a criação de um banco de dados que atenda os requisito da aplicação.</h2>

## **1. Configurando o banco de dados.**

* ### Criando Banco de dados.
~~~SQL
    CREATE DATABASE "BDprojeto"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
~~~

* ### Criando tabela Componente Curricular.
~~~SQL
CREATE TABLE IF NOT EXISTS public.componentecurricular
(
    nomecc character varying(100) COLLATE pg_catalog."default" NOT NULL,
    cargahorariacc integer NOT NULL,
    codigocc character varying(7) COLLATE pg_catalog."default" NOT NULL,
    semestre integer,
    obrigatoriedade character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT componentecurricular_pkey PRIMARY KEY (codigocc)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.componentecurricular
    OWNER to postgres;
~~~
* ### Criando tabela Professores.
~~~SQL
CREATE TABLE IF NOT EXISTS public.professores
(
    nome character varying(60) COLLATE pg_catalog."default" NOT NULL,
    matricula character varying(10) COLLATE pg_catalog."default" NOT NULL,
    titulacao character varying(15) COLLATE pg_catalog."default",
    email character varying(50) COLLATE pg_catalog."default",
    cargahoraria integer DEFAULT 0,
    CONSTRAINT professores_pkey PRIMARY KEY (matricula)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.professores
    OWNER to postgres;
~~~
* ### Criando tabela Turmas.
~~~SQL
CREATE TABLE IF NOT EXISTS public.turmas
(
    codigo character varying(7) COLLATE pg_catalog."default",
    nomecc character varying(100) COLLATE pg_catalog."default",
    horario character varying(9) COLLATE pg_catalog."default",
    turm integer,
    vagas integer,
    semestre integer,
    docente character varying(60) COLLATE pg_catalog."default",
    cargahoraria integer
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.turmas
    OWNER to postgres;
~~~
---
## **2. Preenchendo as tabelas com dados para teste.**

* ### INSERT script tabela Componente Curricular.
~~~SQL
INSERT INTO public.componentecurricular(
	nomecc, cargahorariacc, codigocc, semestre, obrigatoriedade)
	VALUES (?, ?, ?, ?, ?);
~~~

* ### INSERT script tabela Professores.
~~~SQL
INSERT INTO public.professores(
	nome, matricula, titulacao, email, cargahoraria)
	VALUES (?, ?, ?, ?, ?);
~~~
* ### INSERT script tabela Turmas.
~~~SQL
INSERT INTO public.turmas(
	codigo, nomecc, horario, turm, vagas, semestre, docente, cargahoraria)
	VALUES (?, ?, ?, ?, ?, ?, ?, ?);
~~~
---
## **3. Altere a conexão com o banco de dados conforme suas configurações.**
~~~JAVA
this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDprojeto","seu_user","sua_senha");
~~~