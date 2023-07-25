insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante(nome,taxa_frete, cozinha_id) values ('Burguer King', 10, 1);
insert into restaurante(nome,taxa_frete, cozinha_id) values ('Girafas', 9.50, 1);
insert into restaurante(nome,taxa_frete, cozinha_id) values ('SubWay', 9.50, 2);

insert into tab_forma_pagamento(nome) values ('Dinheiro');
insert into tab_forma_pagamento(nome) values ('Credito');
insert into tab_forma_pagamento(nome) values ('Debito');
insert into tab_forma_pagamento(nome) values ('Pix');

insert into tab_estado(nome) values ('Goias');
insert into tab_estado(nome) values ('Rio De Janeiro');
insert into tab_estado(nome) values ('Ceara');

insert into tab_cidade(nome, estado_id) values ('Goiania', 1);
insert into tab_cidade(nome, estado_id) values ('Aquiraz', 2);
insert into tab_cidade(nome, estado_id) values ('Anapolis', 2);

