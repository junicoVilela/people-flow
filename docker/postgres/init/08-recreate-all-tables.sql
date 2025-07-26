-- Script para remover e recriar todas as tabelas do sistema People Flow
-- Execute este script para limpar e recriar todo o banco de dados

-- ====================================================================
-- REMOVER TODAS AS TABELAS (em ordem de dependência)
-- ====================================================================

-- 1. Primeiro dropar tabelas que dependem de outras (filhas)
DROP TABLE IF EXISTS people_flow.tb_registro_ponto CASCADE;
DROP TABLE IF EXISTS people_flow.tb_justificativa_ponto CASCADE;
DROP TABLE IF EXISTS people_flow.tb_documento_colaborador CASCADE;
DROP TABLE IF EXISTS people_flow.tb_dependente CASCADE;
DROP TABLE IF EXISTS people_flow.tb_contrato CASCADE;
DROP TABLE IF EXISTS people_flow.tb_colaborador CASCADE;

-- 2. Depois dropar tabelas principais
DROP TABLE IF EXISTS people_flow.tb_cargo CASCADE;
DROP TABLE IF EXISTS people_flow.tb_usuario CASCADE;
DROP TABLE IF EXISTS people_flow.tb_departamento CASCADE;

-- 3. Dropar tabela de auditoria
DROP TABLE IF EXISTS people_flow.audit_log CASCADE;

-- 4. Dropar funções
DROP FUNCTION IF EXISTS people_flow.audit_trigger_function() CASCADE;

-- ====================================================================
-- CRIAR SCHEMA (se não existir)
-- ====================================================================

CREATE SCHEMA IF NOT EXISTS people_flow;

-- ====================================================================
-- CRIAR EXTENSÕES
-- ====================================================================

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- ====================================================================
-- CRIAR TABELA DE AUDITORIA (PRIMEIRA)
-- ====================================================================

CREATE TABLE people_flow.audit_log (
    id BIGSERIAL PRIMARY KEY,
    table_name VARCHAR(100) NOT NULL,
    operation VARCHAR(20) NOT NULL,
    old_values JSONB,
    new_values JSONB,
    user_id VARCHAR(100),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Índices para auditoria
CREATE INDEX idx_audit_log_timestamp ON people_flow.audit_log(timestamp);
CREATE INDEX idx_audit_log_table_name ON people_flow.audit_log(table_name);

-- ====================================================================
-- CRIAR TB_DEPARTAMENTO (PRIMEIRA - pois é referenciada por outras)
-- ====================================================================

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

-- ====================================================================
-- CRIAR TB_USUARIO (SEGUNDA - pois é referenciada por colaborador)
-- ====================================================================

CREATE TABLE people_flow.tb_usuario (
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

-- Índices para TB_USUARIO
CREATE INDEX idx_usuario_email ON people_flow.tb_usuario(email);
CREATE INDEX idx_usuario_ativo ON people_flow.tb_usuario(ativo);

-- ====================================================================
-- CRIAR TB_CARGO (TERCEIRA - pois é referenciada por colaborador)
-- ====================================================================

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

-- ====================================================================
-- CRIAR TB_COLABORADOR (QUARTA - depois de todas as outras)
-- ====================================================================

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

-- ====================================================================
-- CRIAR TB_CONTRATO
-- ====================================================================

CREATE TABLE people_flow.tb_contrato (
    id BIGSERIAL PRIMARY KEY,
    colaborador_id BIGINT NOT NULL,
    tipo_contrato VARCHAR(50) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    salario DECIMAL(10,2) NOT NULL,
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

-- ====================================================================
-- CRIAR TB_DEPENDENTE
-- ====================================================================

CREATE TABLE people_flow.tb_dependente (
    id BIGSERIAL PRIMARY KEY,
    colaborador_id BIGINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14),
    data_nascimento DATE,
    parentesco VARCHAR(50) NOT NULL,
    ativo BOOLEAN NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100),
    CONSTRAINT fk_dependente_colaborador FOREIGN KEY (colaborador_id) REFERENCES people_flow.tb_colaborador(id)
);

-- ====================================================================
-- CRIAR TB_DOCUMENTO_COLABORADOR
-- ====================================================================

CREATE TABLE people_flow.tb_documento_colaborador (
    id BIGSERIAL PRIMARY KEY,
    colaborador_id BIGINT NOT NULL,
    tipo_documento VARCHAR(50) NOT NULL,
    numero VARCHAR(50) NOT NULL,
    orgao_emissor VARCHAR(50),
    data_emissao DATE,
    data_vencimento DATE,
    arquivo_url VARCHAR(500),
    ativo BOOLEAN NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100),
    CONSTRAINT fk_documento_colaborador FOREIGN KEY (colaborador_id) REFERENCES people_flow.tb_colaborador(id)
);

-- ====================================================================
-- CRIAR TB_REGISTRO_PONTO
-- ====================================================================

CREATE TABLE people_flow.tb_registro_ponto (
    id BIGSERIAL PRIMARY KEY,
    colaborador_id BIGINT NOT NULL,
    data_registro DATE NOT NULL,
    hora_registro TIME NOT NULL,
    tipo_registro VARCHAR(20) NOT NULL,
    latitude DECIMAL(10,8),
    longitude DECIMAL(11,8),
    observacoes TEXT,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100),
    CONSTRAINT fk_registro_ponto_colaborador FOREIGN KEY (colaborador_id) REFERENCES people_flow.tb_colaborador(id)
);

-- ====================================================================
-- CRIAR TB_JUSTIFICATIVA_PONTO
-- ====================================================================

CREATE TABLE people_flow.tb_justificativa_ponto (
    id BIGSERIAL PRIMARY KEY,
    colaborador_id BIGINT NOT NULL,
    data_justificativa DATE NOT NULL,
    tipo_justificativa VARCHAR(50) NOT NULL,
    descricao TEXT NOT NULL,
    status VARCHAR(20) NOT NULL,
    aprovado_por VARCHAR(100),
    data_aprovacao TIMESTAMP,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100),
    CONSTRAINT fk_justificativa_ponto_colaborador FOREIGN KEY (colaborador_id) REFERENCES people_flow.tb_colaborador(id)
);

-- ====================================================================
-- CRIAR FUNÇÃO DE AUDITORIA
-- ====================================================================

CREATE OR REPLACE FUNCTION people_flow.audit_trigger_function()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO people_flow.audit_log (table_name, operation, new_values, user_id)
        VALUES (TG_TABLE_NAME, 'INSERT', to_jsonb(NEW), current_user);
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO people_flow.audit_log (table_name, operation, old_values, new_values, user_id)
        VALUES (TG_TABLE_NAME, 'UPDATE', to_jsonb(OLD), to_jsonb(NEW), current_user);
        RETURN NEW;
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO people_flow.audit_log (table_name, operation, old_values, user_id)
        VALUES (TG_TABLE_NAME, 'DELETE', to_jsonb(OLD), current_user);
        RETURN OLD;
    END IF;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

-- ====================================================================
-- VERIFICAR CRIAÇÃO DAS TABELAS
-- ====================================================================

-- Listar todas as tabelas criadas
SELECT 
    'Tabelas criadas:' as info,
    table_name,
    'Criada com sucesso' as status
FROM information_schema.tables 
WHERE table_schema = 'people_flow'
ORDER BY table_name;

-- Verificar foreign keys
SELECT 
    'Foreign Keys criadas:' as info,
    tc.table_name,
    tc.constraint_name,
    kcu.column_name,
    ccu.table_name AS foreign_table_name
FROM information_schema.table_constraints AS tc 
JOIN information_schema.key_column_usage AS kcu
    ON tc.constraint_name = kcu.constraint_name
    AND tc.table_schema = kcu.table_schema
JOIN information_schema.constraint_column_usage AS ccu
    ON ccu.constraint_name = tc.constraint_name
    AND ccu.table_schema = tc.table_schema
WHERE tc.constraint_type = 'FOREIGN KEY' 
    AND tc.table_schema = 'people_flow'
ORDER BY tc.table_name, tc.constraint_name;

-- ====================================================================
-- MENSAGEM DE CONCLUSÃO
-- ====================================================================

DO $$
BEGIN
    RAISE NOTICE '=== RECRIAÇÃO COMPLETA DAS TABELAS ===';
    RAISE NOTICE 'Todas as tabelas foram removidas e recriadas';
    RAISE NOTICE 'Foreign keys e índices foram criados';
    RAISE NOTICE 'Função de auditoria foi criada';
    RAISE NOTICE 'Sistema pronto para uso';
    RAISE NOTICE '==============================================';
END $$; 