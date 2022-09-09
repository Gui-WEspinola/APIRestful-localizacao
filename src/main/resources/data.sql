CREATE table tb_cidade(
    id_cidade bigint not null primary key,
    nome varchar(100) not null,
    qtd_habitantes bigint
);

insert into
    tb_cidade(id_cidade, nome, qtd_habitantes)
values
    (1, 'João Pessoa', 1139485),
    (2, 'Campina Grande', 325385),
    (3, 'Fortaleza', 2478696),
    (4, 'Salvador', 2967865),
    (5, 'Recife', 3165465),
    (6, 'Natal', 975468),
    (7, 'Brasília', 2156389),
    (8, 'Belo Horizonte', 4698523),
    (9, 'Vitória', 697123),
    (10, 'Palmas', 312425),
    (11, 'Santos', 875561),
    (12, 'Sepraquara', 125487)
    ;
