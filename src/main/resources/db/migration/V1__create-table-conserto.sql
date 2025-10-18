create table conserto(
id bigint not null auto_increment,
entrada varchar(20),
saida varchar(20),
nome varchar(100) not null,
experiencia int,
modelo varchar(100) not null,
marca varchar(100) not null,
ano varchar(5) not null,

primary key(id)

);