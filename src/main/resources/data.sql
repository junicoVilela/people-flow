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

-- Inserir colaboradores de teste
-- Colaborador João Silva (usuario_id = 3)
INSERT INTO TB_COLABORADOR (
    usuario_id, 
    cpf, 
    rg, 
    data_nascimento, 
    sexo, 
    telefone, 
    estado_civil, 
    endereco, 
    cargo, 
    departamento, 
    salario, 
    data_admissao, 
    status, 
    data_criacao, 
    data_atualizacao
) VALUES (
    3, 
    '12345678901', 
    '123456789', 
    '1990-05-15', 
    'M', 
    '11987654321', 
    'Solteiro', 
    'Rua das Flores, 123 - São Paulo/SP', 
    'Desenvolvedor Full Stack', 
    'Tecnologia', 
    8500.00, 
    '2023-01-15', 
    'ATIVO', 
    CURRENT_TIMESTAMP, 
    CURRENT_TIMESTAMP
);

-- Colaborador Maria Santos (usuario_id = 4)
INSERT INTO TB_COLABORADOR (
    usuario_id, 
    cpf, 
    rg, 
    data_nascimento, 
    sexo, 
    telefone, 
    estado_civil, 
    endereco, 
    cargo, 
    departamento, 
    salario, 
    data_admissao, 
    status, 
    data_criacao, 
    data_atualizacao
) VALUES (
    4, 
    '98765432100', 
    '987654321', 
    '1985-08-22', 
    'F', 
    '11912345678', 
    'Casada', 
    'Av. Paulista, 1000 - São Paulo/SP', 
    'Analista de Recursos Humanos', 
    'Recursos Humanos', 
    6500.00, 
    '2022-06-01', 
    'ATIVO', 
    CURRENT_TIMESTAMP, 
    CURRENT_TIMESTAMP
);

-- Colaborador adicional para teste
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES (
    'Pedro Oliveira', 
    'pedro.oliveira@empresa.com', 
    '123456', 
    'COLABORADOR', 
    true, 
    CURRENT_TIMESTAMP, 
    CURRENT_TIMESTAMP
);

INSERT INTO TB_COLABORADOR (
    usuario_id, 
    cpf, 
    rg, 
    data_nascimento, 
    sexo, 
    telefone, 
    estado_civil, 
    endereco, 
    cargo, 
    departamento, 
    salario, 
    data_admissao, 
    status, 
    data_criacao, 
    data_atualizacao
) VALUES (
    5, 
    '45678912300', 
    '456789123', 
    '1992-12-10', 
    'M', 
    '11955556666', 
    'Solteiro', 
    'Rua Augusta, 500 - São Paulo/SP', 
    'Designer UX/UI', 
    'Design', 
    7200.00, 
    '2023-03-20', 
    'ATIVO', 
    CURRENT_TIMESTAMP, 
    CURRENT_TIMESTAMP
); 