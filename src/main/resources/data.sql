-- Inserir usuários de teste para login
-- Senha para todos os usuários: 123456

-- Usuário Administrador
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES (
    'Administrador do Sistema', 
    'admin@empresa.com', 
    '123456', 
    'ADMIN', 
    true, 
    CURRENT_TIMESTAMP, 
    CURRENT_TIMESTAMP
);

-- Usuário RH
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES (
    'Recursos Humanos', 
    'rh@empresa.com', 
    '123456', 
    'RH', 
    true, 
    CURRENT_TIMESTAMP, 
    CURRENT_TIMESTAMP
);

-- Usuário Colaborador
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES (
    'João Silva', 
    'joao.silva@empresa.com', 
    '123456', 
    'COLABORADOR', 
    true, 
    CURRENT_TIMESTAMP, 
    CURRENT_TIMESTAMP
);

-- Usuário Colaborador 2
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES (
    'Maria Santos', 
    'maria.santos@empresa.com', 
    '123456', 
    'COLABORADOR', 
    true, 
    CURRENT_TIMESTAMP, 
    CURRENT_TIMESTAMP
); 