-- Script para reordenar colunas das tabelas no PostgreSQL
-- Execute este script após as tabelas já existirem

-- ====================================================================
-- REORDENAR TB_DEPARTAMENTO (PRIMEIRO - pois é referenciada por outras)
-- ====================================================================
DO $$
BEGIN
    -- Verificar se a tabela existe
    IF EXISTS (SELECT FROM information_schema.tables WHERE table_schema = 'people_flow' AND table_name = 'tb_departamento') THEN
        
        -- Dropar foreign keys que referenciam tb_departamento
        ALTER TABLE people_flow.tb_cargo DROP CONSTRAINT IF EXISTS fk9smtckobroo10rt5t7uj3hkx3;
        ALTER TABLE people_flow.tb_colaborador DROP CONSTRAINT IF EXISTS fkfns830uph28581ggs6jote41r;
        
        -- Criar tabela temporária com ordem desejada
        CREATE TABLE people_flow.tb_departamento_temp (
            id BIGSERIAL PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            descricao VARCHAR(250),
            ativo BOOLEAN NOT NULL,
            data_criacao TIMESTAMP NOT NULL,
            data_atualizacao TIMESTAMP NOT NULL,
            criado_por VARCHAR(100),
            atualizado_por VARCHAR(100)
        );
        
        -- Copiar dados
        INSERT INTO people_flow.tb_departamento_temp 
        SELECT id, nome, descricao, ativo, data_criacao, data_atualizacao, criado_por, atualizado_por
        FROM people_flow.tb_departamento;
        
        -- Dropar tabela original
        DROP TABLE people_flow.tb_departamento;
        
        -- Renomear tabela temporária
        ALTER TABLE people_flow.tb_departamento_temp RENAME TO tb_departamento;
        
        RAISE NOTICE 'Tabela tb_departamento reordenada com sucesso';
    END IF;
END $$;

-- ====================================================================
-- REORDENAR TB_CARGO
-- ====================================================================
DO $$
BEGIN
    IF EXISTS (SELECT FROM information_schema.tables WHERE table_schema = 'people_flow' AND table_name = 'tb_cargo') THEN
        
        -- Dropar foreign keys que referenciam tb_cargo
        ALTER TABLE people_flow.tb_colaborador DROP CONSTRAINT IF EXISTS fkqgt3658c9q5h25kh282yapl03;
        
        CREATE TABLE people_flow.tb_cargo_temp (
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
            atualizado_por VARCHAR(100)
        );
        
        INSERT INTO people_flow.tb_cargo_temp 
        SELECT id, nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao, criado_por, atualizado_por
        FROM people_flow.tb_cargo;
        
        DROP TABLE people_flow.tb_cargo;
        ALTER TABLE people_flow.tb_cargo_temp RENAME TO tb_cargo;
        
        RAISE NOTICE 'Tabela tb_cargo reordenada com sucesso';
    END IF;
END $$;

-- ====================================================================
-- REORDENAR TB_USUARIO
-- ====================================================================
DO $$
BEGIN
    IF EXISTS (SELECT FROM information_schema.tables WHERE table_schema = 'people_flow' AND table_name = 'tb_usuario') THEN
        
        -- Dropar foreign keys que referenciam tb_usuario
        ALTER TABLE people_flow.tb_colaborador DROP CONSTRAINT IF EXISTS fkfun50pmyjogudaq006spvl8cw;
        
        CREATE TABLE people_flow.tb_usuario_temp (
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
        
        INSERT INTO people_flow.tb_usuario_temp 
        SELECT id, nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao, criado_por, atualizado_por
        FROM people_flow.tb_usuario;
        
        DROP TABLE people_flow.tb_usuario;
        ALTER TABLE people_flow.tb_usuario_temp RENAME TO tb_usuario;
        
        RAISE NOTICE 'Tabela tb_usuario reordenada com sucesso';
    END IF;
END $$;

-- ====================================================================
-- REORDENAR TB_COLABORADOR
-- ====================================================================
DO $$
BEGIN
    IF EXISTS (SELECT FROM information_schema.tables WHERE table_schema = 'people_flow' AND table_name = 'tb_colaborador') THEN
        
        CREATE TABLE people_flow.tb_colaborador_temp (
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
            atualizado_por VARCHAR(100)
        );
        
        INSERT INTO people_flow.tb_colaborador_temp 
        SELECT id, usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo_id, departamento_id, salario, data_admissao, data_demissao, status, data_criacao, data_atualizacao, criado_por, atualizado_por
        FROM people_flow.tb_colaborador;
        
        DROP TABLE people_flow.tb_colaborador;
        ALTER TABLE people_flow.tb_colaborador_temp RENAME TO tb_colaborador;
        
        RAISE NOTICE 'Tabela tb_colaborador reordenada com sucesso';
    END IF;
END $$;

-- ====================================================================
-- RECRIAR FOREIGN KEYS
-- ====================================================================

-- Recriar foreign key de cargo para departamento
ALTER TABLE people_flow.tb_cargo 
ADD CONSTRAINT fk_cargo_departamento 
FOREIGN KEY (departamento_id) REFERENCES people_flow.tb_departamento(id);

-- Recriar foreign keys de colaborador
ALTER TABLE people_flow.tb_colaborador 
ADD CONSTRAINT fk_colaborador_usuario 
FOREIGN KEY (usuario_id) REFERENCES people_flow.tb_usuario(id);

ALTER TABLE people_flow.tb_colaborador 
ADD CONSTRAINT fk_colaborador_cargo 
FOREIGN KEY (cargo_id) REFERENCES people_flow.tb_cargo(id);

ALTER TABLE people_flow.tb_colaborador 
ADD CONSTRAINT fk_colaborador_departamento 
FOREIGN KEY (departamento_id) REFERENCES people_flow.tb_departamento(id);

-- ====================================================================
-- RECRIAR ÍNDICES
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
-- VERIFICAR ORDEM DAS COLUNAS
-- ====================================================================
SELECT 
    'tb_departamento' as tabela,
    column_name,
    ordinal_position
FROM information_schema.columns 
WHERE table_schema = 'people_flow' AND table_name = 'tb_departamento'
ORDER BY ordinal_position;

SELECT 
    'tb_cargo' as tabela,
    column_name,
    ordinal_position
FROM information_schema.columns 
WHERE table_schema = 'people_flow' AND table_name = 'tb_cargo'
ORDER BY ordinal_position;

SELECT 
    'tb_usuario' as tabela,
    column_name,
    ordinal_position
FROM information_schema.columns 
WHERE table_schema = 'people_flow' AND table_name = 'tb_usuario'
ORDER BY ordinal_position;

SELECT 
    'tb_colaborador' as tabela,
    column_name,
    ordinal_position
FROM information_schema.columns 
WHERE table_schema = 'people_flow' AND table_name = 'tb_colaborador'
ORDER BY ordinal_position; 