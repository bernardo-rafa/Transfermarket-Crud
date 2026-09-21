CREATE TABLE jogador (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    clube VARCHAR(100) NOT NULL,
    posicao VARCHAR(50) NOT NULL,
    numero_camisa INT
);