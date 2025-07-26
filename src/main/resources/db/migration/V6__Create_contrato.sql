-- V6__Create_contrato.sql
-- Criação da tabela de contratos

CREATE TABLE people_flow.tb_contrato (
    id BIGSERIAL PRIMARY KEY,
    colaborador_id BIGINT NOT NULL,
    tipo_contrato VARCHAR(50) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    salario DECIMAL(10,2) NOT NULL,
    carga_horaria_semanal INTEGER NOT NULL,
    cargo_id BIGINT NOT NULL,
    departamento_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL,
    observacoes TEXT,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100),
    CONSTRAINT fk_contrato_colaborador FOREIGN KEY (colaborador_id) REFERENCES people_flow.tb_colaborador(id),
    CONSTRAINT fk_contrato_cargo FOREIGN KEY (cargo_id) REFERENCES people_flow.tb_cargo(id),
    CONSTRAINT fk_contrato_departamento FOREIGN KEY (departamento_id) REFERENCES people_flow.tb_departamento(id)
);

-- Comentários
COMMENT ON TABLE people_flow.tb_contrato IS 'Tabela de contratos dos colaboradores';
COMMENT ON COLUMN people_flow.tb_contrato.id IS 'Identificador único do contrato';
COMMENT ON COLUMN people_flow.tb_contrato.colaborador_id IS 'ID do colaborador';
COMMENT ON COLUMN people_flow.tb_contrato.tipo_contrato IS 'Tipo do contrato (CLT, PJ, ESTAGIO, etc.)';
COMMENT ON COLUMN people_flow.tb_contrato.data_inicio IS 'Data de início do contrato';
COMMENT ON COLUMN people_flow.tb_contrato.data_fim IS 'Data de fim do contrato (se aplicável)';
COMMENT ON COLUMN people_flow.tb_contrato.salario IS 'Salário do contrato';
COMMENT ON COLUMN people_flow.tb_contrato.carga_horaria_semanal IS 'Carga horária semanal do contrato';
COMMENT ON COLUMN people_flow.tb_contrato.cargo_id IS 'ID do cargo no contrato';
COMMENT ON COLUMN people_flow.tb_contrato.departamento_id IS 'ID do departamento no contrato';
COMMENT ON COLUMN people_flow.tb_contrato.status IS 'Status do contrato (ATIVO, INATIVO, ENCERRADO)';
COMMENT ON COLUMN people_flow.tb_contrato.observacoes IS 'Observações sobre o contrato'; 