CREATE TABLE `usuarios` (
  `id` int PRIMARY KEY,
  `nome` varchar(255) NOT NULL,
  `nascimento` data NOT NULL,
  `email` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `pais` varchar(255) NOT NULL,
  `cep` varchar(255) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `password` varchar(6) NOT NULL
);

CREATE TABLE `competencias` (
  `id` int PRIMARY KEY,
  `nome` varchar(255) NOT NULL
);

CREATE TABLE `usuarios_competencias` (
  `id` int PRIMARY KEY,
  `id_competencia` int,
  `id_usuario` int
);

CREATE TABLE `empresas_competencias` (
  `id` int PRIMARY KEY,
  `id_competencia` int,
  `id_empresa` int
);

CREATE TABLE `vagas_competencias` (
  `id` int PRIMARY KEY,
  `id_competencia` int,
  `id_vaga` int
);

CREATE TABLE `empresas` (
  `id` int PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `cnpj` varchar(255) NOT NULL,
  `email` varhar NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `pais` varchar(255) NOT NULL,
  `cep` varchar(255) NOT NULL,
  `password` varchar(6) NOT NULL
);

CREATE TABLE `match` (
  `id` int PRIMARY KEY,
  `id_usuario` int,
  `id_vaga` int,
  `id_empresa` int
);

CREATE TABLE `vagas` (
  `id` int PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `local` varchar(255) NOT NULL,
  `id_empresa` int
);

ALTER TABLE `usuarios_competencias` ADD FOREIGN KEY (`id_competencia`) REFERENCES `competencias` (`id`);

ALTER TABLE `usuarios_competencias` ADD FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

ALTER TABLE `empresas_competencias` ADD FOREIGN KEY (`id_competencia`) REFERENCES `competencias` (`id`);

ALTER TABLE `empresas_competencias` ADD FOREIGN KEY (`id_empresa`) REFERENCES `empresas` (`id`);

ALTER TABLE `vagas_competencias` ADD FOREIGN KEY (`id_competencia`) REFERENCES `competencias` (`id`);

ALTER TABLE `vagas_competencias` ADD FOREIGN KEY (`id_vaga`) REFERENCES `vagas` (`id`);

ALTER TABLE `match` ADD FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

ALTER TABLE `match` ADD FOREIGN KEY (`id_vaga`) REFERENCES `vagas` (`id`);

ALTER TABLE `match` ADD FOREIGN KEY (`id_empresa`) REFERENCES `empresas` (`id`);

ALTER TABLE `vagas` ADD FOREIGN KEY (`id_empresa`) REFERENCES `empresas` (`id`);

INSERT TO usuarios (nome, nascimento, email, cpf, pais, cep, descricao, password)VALUES ('Tulio Amaral', '2001-05-11', 'tulio.amaral@acelerazg.com.br', '111.111.111-00', 'brasil', '74690-505', 'Empenhado e de alta perfomace', '123456')

INSERT TO usuarios (nome, nascimento, email, cpf, pais, cep, descricao, password)VALUES ('Sandubinha Amaral', '2001-05-11', 'sandubinha.amaral@acelerazg.com.br', '111.111.111-00', 'brasil', '74690-505', 'Empenhado e de alta perfomace', '156489')

INSERT TO usuarios (nome, nascimento, email, cpf, pais, cep, descricao, password)VALUES ('Crepe Amaral', '2001-05-11', 'crepe.amaral@acelerazg.com.br', '111.111.111-00', 'brasil', '74690-505', 'Empenhado e de alta perfomace', '156489')

INSERT TO usuarios (nome, nascimento, email, cpf, pais, cep, descricao, password)VALUES ('Almondega Amaral', '2001-05-11', 'aknibdega.amaral@acelerazg.com.br', '111.111.111-00', 'brasil', '74690-505', 'Empenhado e de alta perfomace', '156489')

INSERT TO usuarios (nome, nascimento, email, cpf, pais, cep, descricao, password)VALUES ('Milkshake Amaral', '2001-05-11', 'aknibdega.amaral@acelerazg.com.br', '111.111.111-00', 'brasil', '74690-505', 'Empenhado e de alta perfomace', '156489')

