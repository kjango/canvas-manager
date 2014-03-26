
--DROP TABLE status CASCADE;

--DROP TABLE TipoUsuario CASCADE;

--DROP TABLE usuario CASCADE;

--DROP TABLE historico CASCADE;

--DROP TABLE credencial CASCADE;

--DROP TABLE pergunta CASCADE;

--DROP TABLE situacao CASCADE;

--DROP TABLE projeto CASCADE;

--DROP TABLE resposta CASCADE;

--DROP TABLE avaliacao CASCADE;

--DROP TABLE equipe CASCADE;

--DROP TABLE resultado CASCADE;

--DROP TABLE parecer CASCADE;



CREATE TABLE status(
	id serial primary key not null,
	descricao varchar(50) not null,
	unique (descricao)
);

CREATE TABLE TipoUsuario(
	id serial primary key not null,
	descricao varchar(50) not null,
	unique(descricao)
);

CREATE TABLE usuario(
	id serial primary key not null,
	nome varchar(100) not null,
	email varchar(50) not null,
	curso varchar(50),
	status_curso integer not null,
	data_conclusao_curso date not null default CURRENT_TIMESTAMP,
	data_registro date not null default CURRENT_TIMESTAMP,
	atualizado_em timestamp not null default CURRENT_TIMESTAMP,
	id_tipo integer not null,
	unique(email),
	foreign key (status_curso) references Status(id),
	foreign key (id_tipo) references TipoUsuario(id)
);

CREATE TABLE historico(
	id serial primary key not null,
	id_usuario integer not null,
	texto varchar(200) not null,
	foreign key (id_usuario) references usuario(id)
);

CREATE TABLE credencial(
	id_usuario integer not null references usuario(id),
	senha varchar(50) not null,
	atualizado_em timestamp not null default CURRENT_TIMESTAMP,
	primary key (id_usuario)
);

CREATE TABLE pergunta(
	id serial primary key not null,
	descricao varchar(300) not null,
	bloco varchar(50) not null
);

CREATE TABLE situacao(
	id serial primary key not null,
	descricao varchar(50) not null,
	unique(descricao)
);

CREATE TABLE projeto(
	id serial primary key not null,
	nome varchar(100) not null,
	lider integer not null references usuario(id),
	id_situacao integer not null references situacao(id),
	criado_em timestamp not null default CURRENT_TIMESTAMP,
	atualizado_em timestamp not null default CURRENT_TIMESTAMP,
	unique(nome)
);

CREATE TABLE resposta(
	id serial primary key not null,
	id_pergunta integer not null references pergunta(id),
	id_projeto integer not null references projeto(id),
	texto varchar(500) not null,
	criado_em timestamp not null default CURRENT_TIMESTAMP,
	atualizado_em timestamp not null default CURRENT_TIMESTAMP
);

CREATE TABLE avaliacao(
	id serial primary key not null,
	id_usuario integer not null references usuario(id),
	id_resposta integer not null references resposta(id),
	nota integer not null,
	comentario varchar(500),
	criado_em timestamp not null default CURRENT_TIMESTAMP,
	atualizado_em timestamp not null default CURRENT_TIMESTAMP
);

CREATE TABLE equipe(
	id_usuario integer not null references usuario(id),
	id_projeto integer not null references projeto(id),
	adicionado_em timestamp not null default CURRENT_TIMESTAMP, 
	primary key (id_usuario, id_projeto)
);

CREATE TABLE resultado(
	id serial primary key not null,
	descricao varchar(50) not null,
	unique(descricao)
);

CREATE TABLE parecer(
	id serial primary key not null,
	id_admin integer not null references usuario(id),
	comentario varchar(500),
	id_resultado integer not null references resultado(id),
	id_projeto integer not null references projeto(id),
	criado_em timestamp not null default CURRENT_TIMESTAMP,
	modificado_em timestamp not null default CURRENT_TIMESTAMP
);



--------------------------------------------DADOS

--ALTER SEQUENCE situacao_id_seq RESTART WITH 1;
INSERT INTO situacao(descricao) VALUES ('Em processo');
INSERT INTO situacao(descricao) VALUES ('Aguardando avaliação');
INSERT INTO situacao(descricao) VALUES ('Aguardando parecer');
INSERT INTO situacao(descricao) VALUES ('Emitindo parecer');
INSERT INTO situacao(descricao) VALUES ('Aprovado');
INSERT INTO situacao(descricao) VALUES ('Recusado');
INSERT INTO situacao(descricao) VALUES ('Excluído');

--perguntas
INSERT into pergunta (descricao, bloco) values ('Para quem está se criando valor?', 'Segmentos de clientes');
INSERT into pergunta (descricao, bloco) values ('Quem são nossos mais importantes clientes?', 'Segmentos de clientes');
INSERT into pergunta (descricao, bloco) values ('Esses clientes possuem necessidades em comum?', 'Segmentos de clientes');
INSERT into pergunta (descricao, bloco) values ('Esses clientes são atingidos da mesma maneira?', 'Segmentos de clientes');

INSERT into pergunta (descricao, bloco) values ('Que valor é entregue ao cliente?', 'Proposta de valor');
INSERT into pergunta (descricao, bloco) values ('Que problemas dos clientes estamos ajudando a solucionar?', 'Proposta de valor');
INSERT into pergunta (descricao, bloco) values ('Que necessidades dos clientes estamos satisfazendo?', 'Proposta de valor');
INSERT into pergunta (descricao, bloco) values ('Que cesta de produtos e serviços estamos oferecendo para cada segmento de cliente?', 'Proposta de valor');

INSERT into pergunta (descricao, bloco) values ('Por quais canais seus segmentos de clientes querem ser atingidos?', 'Canais');
INSERT into pergunta (descricao, bloco) values ('Como são atingidos agora?', 'Canais');
INSERT into pergunta (descricao, bloco) values ('Como nossos canais se integram?', 'Canais');
INSERT into pergunta (descricao, bloco) values ('Quais possuem melhor custo-benefício?', 'Canais');
INSERT into pergunta (descricao, bloco) values ('Como são integrados a rotina do clientes?', 'Canais');

INSERT into pergunta (descricao, bloco) values ('Que tipo de relacionamento cada segmento de clientes espera ser estabelecido e mantido com eles?', 'Relacionamento com o cliente');
INSERT into pergunta (descricao, bloco) values ('Quais tipos de relacionamento tem sido estabelecidos?', 'Relacionamento com o cliente');
INSERT into pergunta (descricao, bloco) values ('Quais os custos desses relacionamentos?', 'Relacionamento com o cliente');
INSERT into pergunta (descricao, bloco) values ('Como eles estão integrados com o modelo de negócios?', 'Relacionamento com o cliente');

INSERT into pergunta (descricao, bloco) values ('Por qual valor os clientes estão realmente dispostos a pagar?', 'Fluxo de receitas');
INSERT into pergunta (descricao, bloco) values ('Pelo que eles atualmente pagam?', 'Fluxo de receitas');
INSERT into pergunta (descricao, bloco) values ('Como eles estão pagando atualmente?', 'Fluxo de receitas');
INSERT into pergunta (descricao, bloco) values ('Quanto cada fluxo de receitas contribuem para a receita total?', 'Fluxo de receitas');

INSERT into pergunta (descricao, bloco) values ('Quais recursos chave a proposta de valor precisa?', 'Recursos chave');
INSERT into pergunta (descricao, bloco) values ('E para o canal de distribuição?', 'Recursos chave');
INSERT into pergunta (descricao, bloco) values ('E para o relacionamento com o cliente?', 'Recursos chave');
INSERT into pergunta (descricao, bloco) values ('E para o fluxo de receitas?', 'Recursos chave');

INSERT into pergunta (descricao, bloco) values ('Quais as atividades chave que a proposta de valor precisa?', 'Atividades chave');
INSERT into pergunta (descricao, bloco) values ('E os canais de distribuição?', 'Atividades chave');
INSERT into pergunta (descricao, bloco) values ('E o relacionamento com o cliente?', 'Atividades chave');
INSERT into pergunta (descricao, bloco) values ('E o fluxo de receitas?', 'Atividades chave');

INSERT into pergunta (descricao, bloco) values ('Quem são os parceiros chave?', 'Parceiros chave');
INSERT into pergunta (descricao, bloco) values ('Quem são nossos fornecedores chave?', 'Parceiros chave');
INSERT into pergunta (descricao, bloco) values ('Quais recursos chave são adquiridos dos parceiros?', 'Parceiros chave');
INSERT into pergunta (descricao, bloco) values ('Quais atividades chave os parceiros fazem?', 'Parceiros chave');

INSERT into pergunta (descricao, bloco) values ('Quais são os principais custos inerentes ao modelo de negócios?', 'Esttrutura de custos');
INSERT into pergunta (descricao, bloco) values ('Quais recursos chave são mais caros?', 'Esttrutura de custos');
INSERT into pergunta (descricao, bloco) values ('Quais atividades chave são mais caras?', 'Esttrutura de custos');

INSERT into status (descricao) values ('Concluido');
INSERT into status (descricao) values ('Em Curso');

INSERT into tipousuario (descricao) values ('Usuario');
INSERT into tipousuario (descricao) values ('Avaliador');
INSERT into tipousuario (descricao) values ('Administrador');

INSERT INTO resultado(id, descricao) VALUES (4, 'Emitindo parecer');
INSERT INTO resultado(id, descricao) VALUES (5, 'Aprovado');
INSERT INTO resultado(id, descricao) VALUES (6, 'Recusado');