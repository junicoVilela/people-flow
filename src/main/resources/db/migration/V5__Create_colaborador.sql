-- V5__Create_colaborador.sql
-- Criação da tabela de colaboradores

CREATE TABLE people_flow.tb_colaborador (
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    rg VARCHAR(20),
    data_nascimento DATE,
    sexo VARCHAR(10),
    telefone VARCHAR(20),
    estado_civil VARCHAR(20),
    endereco TEXT,
    cargo_id BIGINT,
    departamento_id BIGINT,
    salario DECIMAL(10,2),
    data_admissao DATE,
    data_demissao DATE,
    status VARCHAR(20),
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100),
    CONSTRAINT fk_colaborador_usuario FOREIGN KEY (usuario_id) REFERENCES people_flow.tb_usuario(id),
    CONSTRAINT fk_colaborador_cargo FOREIGN KEY (cargo_id) REFERENCES people_flow.tb_cargo(id),
    CONSTRAINT fk_colaborador_departamento FOREIGN KEY (departamento_id) REFERENCES people_flow.tb_departamento(id)
);

-- Índices para TB_COLABORADOR
CREATE INDEX idx_colaborador_cpf ON people_flow.tb_colaborador(cpf);
CREATE INDEX idx_colaborador_usuario_id ON people_flow.tb_colaborador(usuario_id);
CREATE INDEX idx_colaborador_cargo_id ON people_flow.tb_colaborador(cargo_id);
CREATE INDEX idx_colaborador_departamento_id ON people_flow.tb_colaborador(departamento_id);
CREATE INDEX idx_colaborador_status ON people_flow.tb_colaborador(status);

-- Comentários
COMMENT ON TABLE people_flow.tb_colaborador IS 'Tabela de colaboradores da empresa';
COMMENT ON COLUMN people_flow.tb_colaborador.id IS 'Identificador único do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.usuario_id IS 'ID do usuário associado ao colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.cpf IS 'CPF único do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.rg IS 'RG do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.data_nascimento IS 'Data de nascimento do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.sexo IS 'Sexo do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.telefone IS 'Telefone do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.estado_civil IS 'Estado civil do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.endereco IS 'Endereço completo do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.cargo_id IS 'ID do cargo do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.departamento_id IS 'ID do departamento do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.salario IS 'Salário atual do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.data_admissao IS 'Data de admissão do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.data_demissao IS 'Data de demissão do colaborador (se aplicável)';
COMMENT ON COLUMN people_flow.tb_colaborador.status IS 'Status do colaborador (ATIVO, INATIVO, FERIAS, etc.)'; 