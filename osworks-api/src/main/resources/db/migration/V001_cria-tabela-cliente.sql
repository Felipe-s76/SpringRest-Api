create table cliente (
	id SERIAL not null,
	nome varchar(255) not null,
	email varchar(255) not null,
	telefone varchar(20) not null,
	
	primary key(id)
);
