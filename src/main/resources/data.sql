create table funcionario(
	id_funcionario SERIAL PRIMARY KEY,
	nome VARCHAR(100),
	data_nascimento DATE,
	setor_id INTEGER references setor(id_setor)
);

create table setor(
	id_setor SERIAL PRIMARY KEY,
	nome VARCHAR(100)
);


INSERT INTO setor(nome) VALUES ('TI');
INSERT INTO setor(nome) VALUES ('RH');

INSERT INTO funcionario(nome, data_nascimento, setor_id) VALUES('Tomas','1993-05-04', 1);
INSERT INTO funcionario(nome, data_nascimento, setor_id) VALUES ('Isabela','1985-10-11', 1);
INSERT INTO funcionario(nome, data_nascimento, setor_id) VALUES ('Oliver','1996-12-20', 2);
INSERT INTO funcionario(nome, data_nascimento, setor_id) VALUES ('Luiza','1981-02-01', 2);
INSERT INTO funcionario(nome, data_nascimento, setor_id) VALUES ('Caroline','1980-01-04', 2);
INSERT INTO funcionario(nome, data_nascimento, setor_id) VALUES ('Ronaldo','1985-01-20',2);

SELECT * FROM SETOR;
SELECT * FROM funcionario;