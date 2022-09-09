CREATE table tb_cidade(
    id_cidade bigint not null primary key,
    nome varchar(100) not null,
    qtd_habitantes bigint
);

insert into
    tb_cidade(id_cidade, nome, qtd_habitantes)
values
    (1, 'João Pessoa', 1139485),
    (2, 'Campina Grande', 325385);