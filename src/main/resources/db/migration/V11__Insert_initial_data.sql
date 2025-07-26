-- V11__Insert_initial_data.sql
-- Inserção de dados iniciais do sistema

-- ====================================================================
-- DEPARTAMENTOS
-- ====================================================================

INSERT INTO people_flow.tb_departamento (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Tecnologia', 'Departamento responsável pelo desenvolvimento de software e infraestrutura tecnológica', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO people_flow.tb_departamento (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Recursos Humanos', 'Departamento responsável pela gestão de pessoas e processos de RH', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO people_flow.tb_departamento (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Financeiro', 'Departamento responsável pela gestão financeira e contábil', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO people_flow.tb_departamento (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Vendas', 'Departamento responsável pelas vendas e relacionamento com clientes', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO people_flow.tb_departamento (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Marketing', 'Departamento responsável pela estratégia de marketing e comunicação', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ====================================================================
-- USUÁRIOS INICIAIS
-- ====================================================================

-- Usuário Administrador
INSERT INTO people_flow.tb_usuario (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Administrador do Sistema', 'admin@empresa.com', '123456', 'ADMIN', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Usuário RH
INSERT INTO people_flow.tb_usuario (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Recursos Humanos', 'rh@empresa.com', '123456', 'RH', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Usuário Colaborador
INSERT INTO people_flow.tb_usuario (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('João Silva', 'joao.silva@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ====================================================================
-- CARGOS
-- ====================================================================

-- DEPARTAMENTO DE TECNOLOGIA (ID: 1)
INSERT INTO people_flow.tb_cargo (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Desenvolvedor Full Stack Pleno', 'Desenvolvedor fullstack com experiência completa', 'PLENO', 1, 7500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO people_flow.tb_cargo (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de RH Pleno', 'Analista com experiência em gestão de pessoas e processos', 'PLENO', 2, 5000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ====================================================================
-- COLABORADORES
-- ====================================================================

-- Colaborador João Silva (usuario_id = 3, cargo_id = 1, departamento_id = 1)
INSERT INTO people_flow.tb_colaborador (
    usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, 
    cargo_id, departamento_id, salario, data_admissao, status, data_criacao, data_atualizacao
) VALUES (
    3, '12345678901', '123456789', '1990-05-15', 'M', '11987654321', 'Solteiro', 
    'Rua das Flores, 123 - São Paulo/SP', 1, 1, 8500.00, '2023-01-15', 'ATIVO', 
    CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
); 