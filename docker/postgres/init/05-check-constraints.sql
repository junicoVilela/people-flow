-- Script para verificar constraints existentes
-- Execute este script antes de tentar reordenar as colunas

-- ====================================================================
-- VERIFICAR CONSTRAINTS EXISTENTES
-- ====================================================================

-- Verificar foreign keys que referenciam tb_departamento
SELECT 
    'Foreign Keys que referenciam tb_departamento:' as info,
    tc.table_name,
    tc.constraint_name,
    kcu.column_name,
    ccu.table_name AS foreign_table_name,
    ccu.column_name AS foreign_column_name
FROM information_schema.table_constraints AS tc 
JOIN information_schema.key_column_usage AS kcu
    ON tc.constraint_name = kcu.constraint_name
    AND tc.table_schema = kcu.table_schema
JOIN information_schema.constraint_column_usage AS ccu
    ON ccu.constraint_name = tc.constraint_name
    AND ccu.table_schema = tc.table_schema
WHERE tc.constraint_type = 'FOREIGN KEY' 
    AND ccu.table_name = 'tb_departamento'
    AND tc.table_schema = 'people_flow';

-- Verificar foreign keys que referenciam tb_cargo
SELECT 
    'Foreign Keys que referenciam tb_cargo:' as info,
    tc.table_name,
    tc.constraint_name,
    kcu.column_name,
    ccu.table_name AS foreign_table_name,
    ccu.column_name AS foreign_column_name
FROM information_schema.table_constraints AS tc 
JOIN information_schema.key_column_usage AS kcu
    ON tc.constraint_name = kcu.constraint_name
    AND tc.table_schema = kcu.table_schema
JOIN information_schema.constraint_column_usage AS ccu
    ON ccu.constraint_name = tc.constraint_name
    AND ccu.table_schema = tc.table_schema
WHERE tc.constraint_type = 'FOREIGN KEY' 
    AND ccu.table_name = 'tb_cargo'
    AND tc.table_schema = 'people_flow';

-- Verificar foreign keys que referenciam tb_usuario
SELECT 
    'Foreign Keys que referenciam tb_usuario:' as info,
    tc.table_name,
    tc.constraint_name,
    kcu.column_name,
    ccu.table_name AS foreign_table_name,
    ccu.column_name AS foreign_column_name
FROM information_schema.table_constraints AS tc 
JOIN information_schema.key_column_usage AS kcu
    ON tc.constraint_name = kcu.constraint_name
    AND tc.table_schema = kcu.table_schema
JOIN information_schema.constraint_column_usage AS ccu
    ON ccu.constraint_name = tc.constraint_name
    AND ccu.table_schema = tc.table_schema
WHERE tc.constraint_type = 'FOREIGN KEY' 
    AND ccu.table_name = 'tb_usuario'
    AND tc.table_schema = 'people_flow';

-- Verificar todas as constraints do schema
SELECT 
    'Todas as constraints do schema people_flow:' as info,
    table_name,
    constraint_name,
    constraint_type
FROM information_schema.table_constraints 
WHERE table_schema = 'people_flow'
ORDER BY table_name, constraint_type;

-- ====================================================================
-- COMANDOS PARA REMOVER CONSTRAINTS (execute manualmente se necessário)
-- ====================================================================

-- Comandos para remover foreign keys (substitua pelos nomes reais encontrados acima)
/*
-- Remover foreign keys de tb_cargo para tb_departamento
ALTER TABLE people_flow.tb_cargo DROP CONSTRAINT IF EXISTS [nome_da_constraint];

-- Remover foreign keys de tb_colaborador para tb_departamento
ALTER TABLE people_flow.tb_colaborador DROP CONSTRAINT IF EXISTS [nome_da_constraint];

-- Remover foreign keys de tb_colaborador para tb_cargo
ALTER TABLE people_flow.tb_colaborador DROP CONSTRAINT IF EXISTS [nome_da_constraint];

-- Remover foreign keys de tb_colaborador para tb_usuario
ALTER TABLE people_flow.tb_colaborador DROP CONSTRAINT IF EXISTS [nome_da_constraint];
*/ 