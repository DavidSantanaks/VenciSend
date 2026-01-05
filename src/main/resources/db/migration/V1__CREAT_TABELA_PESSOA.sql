CREATE TABLE clientes (
    id BIGINT  AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    ativo boolean,
    data_criacao TIMESTAMP
);