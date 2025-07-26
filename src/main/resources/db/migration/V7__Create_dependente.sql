-- V7__Create_dependente.sql
-- Criação da tabela de dependentes

CREATE TABLE people_flow.tb_dependente (
    id BIGSERIAL PRIMARY KEY,
    colaborador_id BIGINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    parentesco VARCHAR(50) NOT NULL,
    cpf VARCHAR(14),
    ativo BOOLEAN NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100),
    CONSTRAINT fk_dependente_colaborador FOREIGN KEY (colaborador_id) REFERENCES people_flow.tb_colaborador(id)
);

-- Comentários
COMMENT ON TABLE people_flow.tb_dependente IS 'Tabela de dependentes dos colaboradores';
COMMENT ON COLUMN people_flow.tb_dependente.id IS 'Identificador único do dependente';
COMMENT ON COLUMN people_flow.tb_dependente.colaborador_id IS 'ID do colaborador';
COMMENT ON COLUMN people_flow.tb_dependente.nome IS 'Nome completo do dependente';
COMMENT ON COLUMN people_flow.tb_dependente.data_nascimento IS 'Data de nascimento do dependente';
COMMENT ON COLUMN people_flow.tb_dependente.parentesco IS 'Tipo de parentesco (FILHO, CONJUGE, etc.)';
COMMENT ON COLUMN people_flow.tb_dependente.cpf IS 'CPF do dependente';
COMMENT ON COLUMN people_flow.tb_dependente.ativo IS 'Status ativo/inativo do dependente'; 