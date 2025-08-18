CREATE TABLE respostas (
    id BIGSERIAL PRIMARY KEY,
    mensagem TEXT NOT NULL,
    topico_id BIGINT NOT NULL,
    data_criacao TIMESTAMP,
    autor_id BIGINT NOT NULL,
    solucao TEXT,
    CONSTRAINT fk_topico FOREIGN KEY (topico_id) REFERENCES topicos(id),
    CONSTRAINT fk_autor FOREIGN KEY (autor_id) REFERENCES autor(id)
);