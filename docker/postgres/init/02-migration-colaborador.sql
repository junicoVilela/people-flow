-- Script de migração para atualizar a tabela de colaboradores
-- Este script adiciona os relacionamentos com Cargo e Departamento

-- Adicionar colunas para os IDs dos relacionamentos (se não existirem)
ALTER TABLE people_flow.tb_colaborador 
ADD COLUMN IF NOT EXISTS cargo_id BIGINT,
ADD COLUMN IF NOT EXISTS departamento_id BIGINT;

-- Adicionar foreign keys (se não existirem)
ALTER TABLE people_flow.tb_colaborador 
ADD CONSTRAINT IF NOT EXISTS fk_colaborador_cargo 
FOREIGN KEY (cargo_id) REFERENCES people_flow.tb_cargo(id);

ALTER TABLE people_flow.tb_colaborador 
ADD CONSTRAINT IF NOT EXISTS fk_colaborador_departamento 
FOREIGN KEY (departamento_id) REFERENCES people_flow.tb_departamento(id);

-- Criar índices para performance
CREATE INDEX IF NOT EXISTS idx_colaborador_cargo_id ON people_flow.tb_colaborador(cargo_id);
CREATE INDEX IF NOT EXISTS idx_colaborador_departamento_id ON people_flow.tb_colaborador(departamento_id);

-- Comentários sobre as alterações
COMMENT ON COLUMN people_flow.tb_colaborador.cargo_id IS 'ID do cargo do colaborador';
COMMENT ON COLUMN people_flow.tb_colaborador.departamento_id IS 'ID do departamento do colaborador'; 