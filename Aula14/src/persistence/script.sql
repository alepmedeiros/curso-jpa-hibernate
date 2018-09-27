create database aula14;

use aula14;


create table Produto(	idProduto int primary key auto_increment,
						nomeProduto varchar (35),
						preco double,
						quantidade int, 
						promocao varchar(35),
						valor double);
						

insert into Produto values (null, 'computador', 1000, 1, 'sim', 400);
insert into Produto values (null, 'celular', 500, 1, 'sim', 200);
insert into Produto values (null, 'mouse', 30, 1, 'sim', 20);
insert into Produto values (null, 'tablet', 680, 1, 'nao', 0);
insert into Produto values (null, 'teclado', 80, 1, 'nao', 0);

commit;

