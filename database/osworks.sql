-- Database: osworks

-- DROP DATABASE osworks;

CREATE DATABASE osworks
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'pt_BR.UTF-8'
    LC_CTYPE = 'pt_BR.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
	create table Cliente (
	id BIGSERIAL PRIMARY KEY ,
	nome varchar(255) not null,
	email varchar(255) not null,
	telefone varchar(20) not null
);

CREATE TABLE Ordem_servico (
	id BIGSERIAL not null,
	cliente_id BIGINT  not null,
	descricao varchar(255) not null,
	preco decimal not null,
	status varchar(20) not null,
	data_abertura timestamp(2) not null,
	data_fechamento timestamp(2),
	PRIMARY KEY(id)
);

ALTER TABLE Ordem_servico add constraint fk_Ordem_servico_cliente
foreign key (cliente_id) references Cliente(id);

CREATE TABLE comentario(
	id BIGSERIAL not null,
	ordem_servico_id BIGINT not null,
	descricao varchar(255) not null,
	data_envio timestamp not null,
	PRIMARY KEY(id) 
);

ALTER TABLE comentario add constraint fk_comentario_ordem_servico
FOREIGN KEY (ordem_servico_id) REFERENCES Ordem_servico(id);

 drop table Ordem_servico
 
 SELECT * FROM comentario;
 
 SELECT * FROM Ordem_servico;
 
 SELECT * FROM cliente
 
insert into cliente values (DEFAULT,'JOsa de silva', 'josa@gmai..com', '32215733')