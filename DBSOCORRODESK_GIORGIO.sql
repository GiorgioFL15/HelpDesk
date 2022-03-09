DROP DATABASE IF EXISTS DBSOCORRODESK;
CREATE DATABASE DBSOCORRODESK;

USE DBSOCORRODESK;

CREATE TABLE TIPOUSUARIO (
IDTIPOUSUARIO INT NOT NULL PRIMARY KEY AUTO_INCREMENT
, DESCRICAO VARCHAR(255)
);

CREATE TABLE USUARIO (
IDUSUARIO INT NOT NULL PRIMARY KEY AUTO_INCREMENT
, IDTIPOUSUARIO INT, FOREIGN KEY (IDTIPOUSUARIO) REFERENCES TIPOUSUARIO (IDTIPOUSUARIO)
, NOME VARCHAR(255)
, CPF CHAR(11) 
, EMAIL VARCHAR(255)
, DATACADASTRO DATE
, DATAEXPIRACAO DATE
, LOGIN VARCHAR(255)
, SENHA VARCHAR(255)
);

CREATE TABLE CHAMADOS (
IDCHAMADO INT NOT NULL PRIMARY KEY AUTO_INCREMENT
, IDUSUARIO INT, FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO (IDUSUARIO)
, IDTECNICO INT, FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO (IDUSUARIO)
, TITULO VARCHAR(255)
, DESCRICAO VARCHAR(255)
, DATAABERTURA DATE 
, SOLUCAO VARCHAR(255)
, DATAFECHAMENTO DATE 
);

INSERT INTO TIPOUSUARIO (descricao) VALUES ('ADMINISTRADOR');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('TECNICO');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('USUARIO');

INSERT INTO USUARIO (idtipousuario, nome, cpf, email, datacadastro, dataexpiracao, login, senha) VALUES (1, 'Giorgio', '01234567890', 
		'giorgio@hotmail.com', '2021-11-12', null, 'giorgio', 'giorgio123');
INSERT INTO USUARIO (idtipousuario, nome, cpf, email, datacadastro, dataexpiracao, login, senha) VALUES (2, 'Leonardo', '12345678910', 
		'leonardo@hotmail.com', '2021-12-11', null, 'leonardo', 'leonardo123');
INSERT INTO USUARIO (idtipousuario, nome, cpf, email, datacadastro, dataexpiracao, login, senha) VALUES (3, 'Thiago', '98765432101', 
		'thiago@hotmail.com', '2021-10-12', null, 'thiago', 'thiago123');
        

INSERT INTO CHAMADOS VALUES (DEFAULT, 1, NULL, "ERRO 420", "ERRO AO REALIZAR LOGIN", "2021-11-12", NULL , NULL);
INSERT INTO CHAMADOS VALUES (DEFAULT, 2, NULL, "ERRO 421", "ERRO SENHA INCORRETA", "2021-11-13", NULL , NULL);
INSERT INTO CHAMADOS VALUES (DEFAULT, 3, 2, "ERRO 422", "ERRO AO EFETUAR CADASTRO", "2021-11-14", "ATUALIZAR APP NA PLAY STORE", "2021-11-15");
INSERT INTO CHAMADOS VALUES (DEFAULT, 1, 3, "ERRO 423", "ERRO EFETUAR COMPRA", "2021-11-15", "REINICIAR O COMPUTADOR", "2021-11-16");
INSERT INTO CHAMADOS VALUES (DEFAULT, 2, 3, "ERRO 424", "PROBLEMA NO SITE", "2021-11-12", NULL, "2021-11-12");
INSERT INTO CHAMADOS VALUES (DEFAULT, 3, 1, "ERRO 425", "ERRO NA VIEW", "2021-11-12", NULL, "2021-11-13");
INSERT INTO CHAMADOS VALUES (DEFAULT, 1, 2, "ERRO 426", "PROBLEMA COM MENU", "2021-11-25", "REABRIR MENU", "2021-11-28");
INSERT INTO CHAMADOS VALUES (DEFAULT, 2, 1, "ERRO 427", "PROBLEMA AO ENTRAR", "2021-12-01", "REINSTALAR APP", "2021-12-02");
                
SELECT * FROM USUARIO;
SELECT * FROM TIPOUSUARIO;

SELECT USUARIO.IDUSUARIO,
		USUARIO.NOME,
		USUARIO.CPF,
        USUARIO.EMAIL,
        CHAMADOS.DATAABERTURA,
        CHAMADOS.DATAFECHAMENTO,
        CHAMADOS.DESCRICAO,
        CHAMADOS.TITULO, 
        CHAMADOS.SOLUCAO
        
FROM
	USUARIO INNER JOIN CHAMADOS ON 
    USUARIO.IDUSUARIO = CHAMADOS.IDUSUARIO;
    

SELECT USUARIO.IDUSUARIO,
		USUARIO.NOME,
		USUARIO.CPF,
        USUARIO.EMAIL,
        COUNT(CHAMADOS.IDCHAMADO) AS TOTALCHAMADOS
        
FROM
	USUARIO INNER JOIN CHAMADOS ON 
    USUARIO.IDUSUARIO = CHAMADOS.IDUSUARIO

GROUP BY 
	USUARIO.IDUSUARIO,
		USUARIO.NOME,
		USUARIO.CPF,
        USUARIO.EMAIL;