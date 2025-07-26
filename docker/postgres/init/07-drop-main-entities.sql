-- Script para dropar entidades principais do sistema People Flow
-- Versão simplificada - remove apenas as tabelas principais

-- ====================================================================
-- DROPPAR TABELAS PRINCIPAIS
-- ====================================================================

-- Dropar tabelas em ordem de dependência (filhas primeiro)
DROP TABLE IF EXISTS people_flow.tb_colaborador CASCADE;
DROP TABLE IF EXISTS people_flow.tb_cargo CASCADE;
DROP TABLE IF EXISTS people_flow.tb_usuario CASCADE;
DROP TABLE IF EXISTS people_flow.tb_departamento CASCADE;

-- ====================================================================
-- VERIFICAR LIMPEZA
-- ====================================================================

-- Verificar se as tabelas principais foram removidas
SELECT 
    'Tabelas principais restantes:' as info,
    table_name
FROM information_schema.tables 
WHERE table_schema = 'people_flow'
AND table_name IN ('tb_departamento', 'tb_cargo', 'tb_usuario', 'tb_colaborador')
ORDER BY table_name;

-- ====================================================================
-- MENSAGEM DE CONCLUSÃO
-- ====================================================================

DO $$
BEGIN
    RAISE NOTICE '=== ENTIDADES PRINCIPAIS REMOVIDAS ===';
    RAISE NOTICE 'Tabelas principais do sistema foram removidas';
    RAISE NOTICE 'Para recriar, execute os scripts de inicialização';
    RAISE NOTICE '==============================================';
END $$; 