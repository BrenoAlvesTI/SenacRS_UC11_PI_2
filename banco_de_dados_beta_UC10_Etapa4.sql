CREATE DATABASE software_beta;

USE software_beta;

-- Criando a tabela cliente
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    endereco VARCHAR(200) NOT NULL
);

-- Criando a tabela produto
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    ValorCusto DECIMAL(10, 2) NOT NULL,
    ValorVenda DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL
);

-- Criando a tabela pedido
CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    data_hora DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    valor_total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

-- Criando a tabela de relacionamento entre pedido e produto
CREATE TABLE pedido_produto (
    pedido_id INT NOT NULL,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id),
    PRIMARY KEY (pedido_id, produto_id)
);

-- Populando a tabela cliente
INSERT INTO cliente (nome, telefone, endereco) VALUES
('JOÃO SILVA', '(11) 99999-9999', 'RUA DAS FLORES, 123'),
('MARIA OLIVEIRA', '(21) 98888-8888', 'AVENIDA CENTRAL, 456'),
('PEDRO SANTOS', '(31) 97777-7777', 'TRAVESSA DO SOL, 789'),
('ANA COSTA', '(41) 96666-6666', 'RUA DAS PALMEIRAS, 101'),
('CARLOS PEREIRA', '(51) 95555-5555', 'PRAÇA DAS ÁRVORES, 202'),
('JULIANA SOUZA', '(61) 94444-4444', 'ALAMEDA DAS ROSAS, 303'),
('FERNANDO LIMA', '(71) 93333-3333', 'RUA DO CAMPO, 404'),
('PATRÍCIA ROCHA', '(81) 92222-2222', 'AVENIDA PAULISTA, 505'),
('BRUNO ALMEIDA', '(91) 91111-1111', 'RUA AMAZONAS, 606'),
('CARLA MENDES', '(81) 90000-0000', 'ESTRADA NOVA, 707');

-- Populando a tabela produto
INSERT INTO produto (nome, ValorCusto, ValorVenda, quantidade) VALUES
('ARROZ', 10.00, 15.00, 50),
('FEIJÃO', 7.00, 12.00, 40),
('ÓLEO DE SOJA', 5.50, 8.00, 80),
('AÇÚCAR', 3.50, 5.00, 100),
('CAFÉ', 20.00, 30.00, 25),
('MACARRÃO', 4.00, 6.50, 70),
('FARINHA DE TRIGO', 6.00, 9.00, 60),
('SAL', 2.00, 3.00, 150),
('LEITE LONGA VIDA', 3.50, 6.00, 200),
('BISCOITO RECHEADO', 2.50, 4.00, 90);

-- Populando a tabela pedido
INSERT INTO pedido (id_cliente, valor_total) VALUES
(1, 69.00), 
(2, 92.00), 
(3, 60.00), 
(4, 118.50), 
(5, 87.00), 
(6, 63.00), 
(7, 12.00), 
(8, 33.00), 
(9, 90.00),
(10, 104.00);

-- Populando a tabela pedido_produto
INSERT INTO pedido_produto (pedido_id, produto_id, quantidade) VALUES
(1, 1, 3),
(1, 2, 2),
(2, 3, 5),
(2, 4, 6),
(2, 5, 1),
(3, 6, 10),
(4, 7, 5),
(4, 8, 10),
(4, 9, 7),
(5, 10, 20),
(5, 1, 2),
(6, 2, 4),
(6, 3, 3),
(7, 4, 2),
(8, 5, 1),
(8, 6, 3),
(9, 7, 10),
(10, 8, 12),
(10, 9, 10),
(10, 10, 2);

SELECT * FROM cliente;
SELECT * FROM produto;
SELECT * FROM pedido;
SELECT * FROM pedido_produto;

