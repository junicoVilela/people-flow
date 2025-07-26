-- Script para dropar todas as entidades do sistema People Flow
-- Execute este script para limpar completamente o banco de dados

-- ====================================================================
-- DROPPAR TODAS AS TABELAS (em ordem de dependência)
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

-- ====================================================================
-- DROPPAR FUNÇÕES E TRIGGERS
-- ====================================================================

-- Dropar função de auditoria
DROP FUNCTION IF EXISTS people_flow.audit_trigger_function() CASCADE;

-- ====================================================================
-- DROPPAR ÍNDICES (se ainda existirem)
-- ====================================================================

-- Índices de TB_DEPARTAMENTO
DROP INDEX IF EXISTS people_flow.idx_departamento_nome;
DROP INDEX IF EXISTS people_flow.idx_departamento_ativo;

-- Índices de TB_CARGO
DROP INDEX IF EXISTS people_flow.idx_cargo_nome;
DROP INDEX IF EXISTS people_flow.idx_cargo_departamento_id;
DROP INDEX IF EXISTS people_flow.idx_cargo_ativo;

-- Índices de TB_USUARIO
DROP INDEX IF EXISTS people_flow.idx_usuario_email;
DROP INDEX IF EXISTS people_flow.idx_usuario_ativo;

-- Índices de TB_COLABORADOR
DROP INDEX IF EXISTS people_flow.idx_colaborador_cpf;
DROP INDEX IF EXISTS people_flow.idx_colaborador_usuario_id;
DROP INDEX IF EXISTS people_flow.idx_colaborador_cargo_id;
DROP INDEX IF EXISTS people_flow.idx_colaborador_departamento_id;
DROP INDEX IF EXISTS people_flow.idx_colaborador_status;

-- Índices de auditoria
DROP INDEX IF EXISTS people_flow.idx_audit_log_timestamp;
DROP INDEX IF EXISTS people_flow.idx_audit_log_table_name;

-- ====================================================================
-- DROPPAR SEQUENCES (se existirem)
-- ====================================================================

DROP SEQUENCE IF EXISTS people_flow.tb_departamento_id_seq CASCADE;
DROP SEQUENCE IF EXISTS people_flow.tb_cargo_id_seq CASCADE;
DROP SEQUENCE IF EXISTS people_flow.tb_usuario_id_seq CASCADE;
DROP SEQUENCE IF EXISTS people_flow.tb_colaborador_id_seq CASCADE;
DROP SEQUENCE IF EXISTS people_flow.tb_contrato_id_seq CASCADE;
DROP SEQUENCE IF EXISTS people_flow.tb_dependente_id_seq CASCADE;
DROP SEQUENCE IF EXISTS people_flow.tb_documento_colaborador_id_seq CASCADE;
DROP SEQUENCE IF EXISTS people_flow.tb_justificativa_ponto_id_seq CASCADE;
DROP SEQUENCE IF EXISTS people_flow.tb_registro_ponto_id_seq CASCADE;
DROP SEQUENCE IF EXISTS people_flow.audit_log_id_seq CASCADE;

-- ====================================================================
-- DROPPAR SCHEMA (se estiver vazio)
-- ====================================================================

-- Verificar se o schema está vazio antes de dropar
DO $$
BEGIN
    -- Verificar se ainda existem objetos no schema
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.tables 
        WHERE table_schema = 'people_flow'
    ) AND NOT EXISTS (
        SELECT 1 FROM information_schema.routines 
        WHERE routine_schema = 'people_flow'
    ) AND NOT EXISTS (
        SELECT 1 FROM information_schema.sequences 
        WHERE sequence_schema = 'people_flow'
    ) THEN
        DROP SCHEMA IF EXISTS people_flow CASCADE;
        RAISE NOTICE 'Schema people_flow removido com sucesso';
    ELSE
        RAISE NOTICE 'Schema people_flow ainda contém objetos e não foi removido';
    END IF;
END $$;

-- ====================================================================
-- DROPPAR EXTENSÕES (se não forem usadas por outras aplicações)
-- ====================================================================

-- Comentado por segurança - descomente apenas se tiver certeza
-- DROP EXTENSION IF EXISTS "uuid-ossp" CASCADE;
-- DROP EXTENSION IF EXISTS "pgcrypto" CASCADE;

-- ====================================================================
-- VERIFICAR LIMPEZA
-- ====================================================================

-- Verificar se ainda existem tabelas no schema people_flow
SELECT 
    'Tabelas restantes no schema people_flow:' as info,
    table_name
FROM information_schema.tables 
WHERE table_schema = 'people_flow'
ORDER BY table_name;

-- Verificar se ainda existem sequences no schema people_flow
SELECT 
    'Sequences restantes no schema people_flow:' as info,
    sequence_name
FROM information_schema.sequences 
WHERE sequence_schema = 'people_flow'
ORDER BY sequence_name;

-- Verificar se ainda existem funções no schema people_flow
SELECT 
    'Funções restantes no schema people_flow:' as info,
    routine_name
FROM information_schema.routines 
WHERE routine_schema = 'people_flow'
ORDER BY routine_name;

-- Verificar se ainda existem constraints no schema people_flow
SELECT 
    'Constraints restantes no schema people_flow:' as info,
    table_name,
    constraint_name,
    constraint_type
FROM information_schema.table_constraints 
WHERE table_schema = 'people_flow'
ORDER BY table_name, constraint_type;

-- ====================================================================
-- MENSAGEM DE CONCLUSÃO
-- ====================================================================

DO $$
BEGIN
    RAISE NOTICE '=== LIMPEZA COMPLETA DO BANCO DE DADOS ===';
    RAISE NOTICE 'Todas as entidades do sistema People Flow foram removidas';
    RAISE NOTICE 'Para recriar o banco, execute os scripts de inicialização';
    RAISE NOTICE '==============================================';
END $$; 