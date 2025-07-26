-- Script para criar tabelas com ordem específica das colunas
-- Este script garante que as colunas sejam criadas na ordem desejada

-- ====================================================================
-- TABELA TB_DEPARTAMENTO (Ordem: ID, NOME, DESCRICAO, ATIVO, DATA_CRIACAO, DATA_ATUALIZACAO, CRIADO_POR, ATUALIZADO_POR)
-- ====================================================================
CREATE TABLE IF NOT EXISTS people_flow.tb_departamento (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(250),
    ativo BOOLEAN NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100)
);

-- ====================================================================
-- TABELA TB_CARGO (Ordem: ID, NOME, DESCRICAO, NIVEL, DEPARTAMENTO_ID, SALARIO_BASE, ATIVO, DATA_CRIACAO, DATA_ATUALIZACAO, CRIADO_POR, ATUALIZADO_POR)
-- ====================================================================
CREATE TABLE IF NOT EXISTS people_flow.tb_cargo (
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

-- ====================================================================
-- TABELA TB_USUARIO (Ordem: ID, NOME, EMAIL, SENHA_HASH, ROLE, ATIVO, DATA_CRIACAO, DATA_ATUALIZACAO, CRIADO_POR, ATUALIZADO_POR)
-- ====================================================================
CREATE TABLE IF NOT EXISTS people_flow.tb_usuario (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    ativo BOOLEAN NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100)
);

-- ====================================================================
-- TABELA TB_COLABORADOR (Ordem: ID, USUARIO_ID, CPF, RG, DATA_NASCIMENTO, SEXO, TELEFONE, ESTADO_CIVIL, ENDERECO, CARGO_ID, DEPARTAMENTO_ID, SALARIO, DATA_ADMISSAO, DATA_DEMISSAO, STATUS, DATA_CRIACAO, DATA_ATUALIZACAO, CRIADO_POR, ATUALIZADO_POR)
-- ====================================================================
CREATE TABLE IF NOT EXISTS people_flow.tb_colaborador (
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

-- ====================================================================
-- ÍNDICES PARA PERFORMANCE
-- ====================================================================

-- Índices para TB_DEPARTAMENTO
CREATE INDEX IF NOT EXISTS idx_departamento_nome ON people_flow.tb_departamento(nome);
CREATE INDEX IF NOT EXISTS idx_departamento_ativo ON people_flow.tb_departamento(ativo);

-- Índices para TB_CARGO
CREATE INDEX IF NOT EXISTS idx_cargo_nome ON people_flow.tb_cargo(nome);
CREATE INDEX IF NOT EXISTS idx_cargo_departamento_id ON people_flow.tb_cargo(departamento_id);
CREATE INDEX IF NOT EXISTS idx_cargo_ativo ON people_flow.tb_cargo(ativo);

-- Índices para TB_USUARIO
CREATE INDEX IF NOT EXISTS idx_usuario_email ON people_flow.tb_usuario(email);
CREATE INDEX IF NOT EXISTS idx_usuario_ativo ON people_flow.tb_usuario(ativo);

-- Índices para TB_COLABORADOR
CREATE INDEX IF NOT EXISTS idx_colaborador_cpf ON people_flow.tb_colaborador(cpf);
CREATE INDEX IF NOT EXISTS idx_colaborador_usuario_id ON people_flow.tb_colaborador(usuario_id);
CREATE INDEX IF NOT EXISTS idx_colaborador_cargo_id ON people_flow.tb_colaborador(cargo_id);
CREATE INDEX IF NOT EXISTS idx_colaborador_departamento_id ON people_flow.tb_colaborador(departamento_id);
CREATE INDEX IF NOT EXISTS idx_colaborador_status ON people_flow.tb_colaborador(status);

-- ====================================================================
-- COMENTÁRIOS NAS TABELAS
-- ====================================================================
COMMENT ON TABLE people_flow.tb_departamento IS 'Tabela de departamentos da empresa';
COMMENT ON TABLE people_flow.tb_cargo IS 'Tabela de cargos da empresa';
COMMENT ON TABLE people_flow.tb_usuario IS 'Tabela de usuários do sistema';
COMMENT ON TABLE people_flow.tb_colaborador IS 'Tabela de colaboradores da empresa'; 