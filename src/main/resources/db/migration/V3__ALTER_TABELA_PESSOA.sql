ALTER TABLE pessoas add ativo boolean;
INSERT INTO pessoas (nome, senha, ativo)
VALUES ('teste', 'teste', true);
delete from pessoas where id = 1;