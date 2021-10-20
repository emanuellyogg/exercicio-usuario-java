INSERT INTO ENDERECO (endcod, rua, numero, complemento, bairro, cep, cidade, estado) VALUES(11, 'Rua Silva', '11', 'ap 101', 'Centro', '89052005','Blumenau', 'Santa Catarina');
INSERT INTO ENDERECO (endcod, rua, numero, complemento, bairro, cep, cidade, estado) VALUES(12, 'Rua Silva', '12', 'ap 122', 'Centro', '89052003','Blumenau', 'Santa Catarina');
INSERT INTO ENDERECO (endcod, rua, numero, complemento, bairro, cep, cidade, estado) VALUES(13, 'Rua Silva', '13', 'ap 133', 'Centro', '89052008','Blumenau', 'Santa Catarina');

INSERT INTO USUARIO (user_id, senha, nome, cpf, tipo, ENDERECO_ID) VALUES('11', '1234', 'Emanuelly', '999.999.999-99', 'Aluna', 11);
INSERT INTO USUARIO (user_id, senha, nome, cpf, tipo, ENDERECO_ID) VALUES('12', '1234', 'Maria', '888.888.888-88', 'Aluna', 12);
INSERT INTO USUARIO (user_id, senha, nome, cpf, tipo, ENDERECO_ID) VALUES('13', '1234', 'Kely', '777.777.777-77', 'Instrutora', 13);
