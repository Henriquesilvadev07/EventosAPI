CREATE TABLE eventos(

    id BIGSERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    descricao TEXT NOT NULL,
    local TEXT NOT NULL,
    capacidade INTEGER NOT NULL,
    status VARCHAR(20)
);