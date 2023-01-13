CREATE TABLE IF NOT EXISTS aluno(
id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
matricula VARCHAR(50),
email VARCHAR(60),
senha VARCHAR(60)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO aluno (nome, matricula, email, senha) values ('William', 'db12545','will_s@gmail.com','12345will');
INSERT INTO aluno (nome, matricula, email, senha) values ('Paulo silva', 'db12577','paulo_s@gmail.com','12345will');
INSERT INTO aluno (nome, matricula, email, senha) values ('Ricardo oliveira', 'db12598','ricardo_s@gmail.com','12345will');
INSERT INTO aluno (nome, matricula, email, senha) values ('Flávio silva', 'db12588','silva_s@gmail.com','12345will');