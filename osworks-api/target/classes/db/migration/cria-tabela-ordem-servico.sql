CREATE TABLE Ordem_servico (
	id BIGSERIAL PRIMARY KEY,
	cliente_id BIGINT  not null,
	descircao varchar(255) not null,
	preco decimal not null,
	status varchar(20) not null,
	data_abertura timestamp(2) not null,
	data_finalizacao timestamp(2) not null
);

ALTER TABLE Ordem_servico add constraint fk_Ordem_servico_cliente
foreign key (cliente_id) references Cliente(id);
