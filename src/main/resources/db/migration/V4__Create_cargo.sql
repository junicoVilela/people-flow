-- V4__Create_cargo.sql
-- Criação da tabela de cargos

CREATE TABLE people_flow.tb_cargo (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(250),
    nivel VARCHAR(20),
    departamento_id BIGINT NOT NULL,
    salario_base DECIMAL(10,2) NOT NULL,
    ativo BOOLEAN NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100),
    CONSTRAINT fk_cargo_departamento FOREIGN KEY (departamento_id) REFERENCES people_flow.tb_departamento(id)
);

-- Índices para TB_CARGO
CREATE INDEX idx_cargo_nome ON people_flow.tb_cargo(nome);
CREATE INDEX idx_cargo_departamento_id ON people_flow.tb_cargo(departamento_id);
CREATE INDEX idx_cargo_ativo ON people_flow.tb_cargo(ativo);

-- Comentários
COMMENT ON TABLE people_flow.tb_cargo IS 'Tabela de cargos da empresa';
COMMENT ON COLUMN people_flow.tb_cargo.id IS 'Identificador único do cargo';
COMMENT ON COLUMN people_flow.tb_cargo.nome IS 'Nome do cargo';
COMMENT ON COLUMN people_flow.tb_cargo.descricao IS 'Descrição do cargo';
COMMENT ON COLUMN people_flow.tb_cargo.nivel IS 'Nível do cargo (JUNIOR, PLENO, SENIOR)';
COMMENT ON COLUMN people_flow.tb_cargo.departamento_id IS 'ID do departamento ao qual o cargo pertence';
COMMENT ON COLUMN people_flow.tb_cargo.salario_base IS 'Salário base do cargo';
COMMENT ON COLUMN people_flow.tb_cargo.ativo IS 'Status ativo/inativo do cargo'; 