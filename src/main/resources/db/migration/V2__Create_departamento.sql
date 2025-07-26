-- V2__Create_departamento.sql
-- Criação da tabela de departamentos

CREATE TABLE people_flow.tb_departamento (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(250),
    ativo BOOLEAN NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100)
);

-- Índices para TB_DEPARTAMENTO
CREATE INDEX idx_departamento_nome ON people_flow.tb_departamento(nome);
CREATE INDEX idx_departamento_ativo ON people_flow.tb_departamento(ativo);

-- Comentários
COMMENT ON TABLE people_flow.tb_departamento IS 'Tabela de departamentos da empresa';
COMMENT ON COLUMN people_flow.tb_departamento.id IS 'Identificador único do departamento';
COMMENT ON COLUMN people_flow.tb_departamento.nome IS 'Nome do departamento';
COMMENT ON COLUMN people_flow.tb_departamento.descricao IS 'Descrição do departamento';
COMMENT ON COLUMN people_flow.tb_departamento.ativo IS 'Status ativo/inativo do departamento'; 