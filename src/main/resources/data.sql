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

-- Adicionando mais 15 colaboradores para teste de paginação

-- Colaborador 6
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Ana Costa', 'ana.costa@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (6, '11122233344', '111222333', '1988-03-25', 'F', '11911112222', 'Casada', 'Rua Consolação, 1500 - São Paulo/SP', 'Analista Financeiro', 'Financeiro', 6800.00, '2022-08-10', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 7
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Carlos Ferreira', 'carlos.ferreira@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (7, '22233344455', '222333444', '1991-07-12', 'M', '11922223333', 'Solteiro', 'Av. Brigadeiro Faria Lima, 2000 - São Paulo/SP', 'Gerente de Projetos', 'Tecnologia', 9500.00, '2021-11-05', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 8
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Fernanda Lima', 'fernanda.lima@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (8, '33344455566', '333444555', '1987-11-30', 'F', '11933334444', 'Divorciada', 'Rua Oscar Freire, 800 - São Paulo/SP', 'Analista de Marketing', 'Marketing', 6200.00, '2023-02-15', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 9
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Roberto Almeida', 'roberto.almeida@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (9, '44455566677', '444555666', '1985-04-18', 'M', '11944445555', 'Casado', 'Rua Haddock Lobo, 1200 - São Paulo/SP', 'Analista de Vendas', 'Vendas', 5800.00, '2022-12-01', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 10
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Juliana Martins', 'juliana.martins@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (10, '55566677788', '555666777', '1993-09-05', 'F', '11955556666', 'Solteira', 'Rua Bela Cintra, 900 - São Paulo/SP', 'Desenvolvedora Frontend', 'Tecnologia', 7800.00, '2023-01-20', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 11
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Lucas Rodrigues', 'lucas.rodrigues@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (11, '66677788899', '666777888', '1990-12-22', 'M', '11966667777', 'Solteiro', 'Av. Jabaquara, 1500 - São Paulo/SP', 'Analista de Suporte', 'Tecnologia', 5500.00, '2023-04-10', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 12
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Patrícia Souza', 'patricia.souza@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (12, '77788899900', '777888999', '1986-06-14', 'F', '11977778888', 'Casada', 'Rua Teodoro Sampaio, 1800 - São Paulo/SP', 'Analista de Qualidade', 'Qualidade', 6500.00, '2022-09-15', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 13
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Diego Santos', 'diego.santos@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (13, '88899900011', '888999000', '1989-01-28', 'M', '11988889999', 'Solteiro', 'Rua Cardeal Arcoverde, 1100 - São Paulo/SP', 'Analista de Produto', 'Produto', 7200.00, '2023-05-08', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 14
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Camila Oliveira', 'camila.oliveira@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (14, '99900011122', '999000111', '1994-03-10', 'F', '11999990000', 'Solteira', 'Rua Harmonia, 700 - São Paulo/SP', 'Analista de Customer Success', 'Customer Success', 6000.00, '2023-06-12', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 15
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Rafael Costa', 'rafael.costa@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (15, '00011122233', '000111222', '1987-08-05', 'M', '11900011111', 'Casado', 'Rua Fradique Coutinho, 1300 - São Paulo/SP', 'Analista de Dados', 'Dados', 7500.00, '2022-10-20', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 16
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Mariana Silva', 'mariana.silva@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (16, '11122233345', '111222334', '1991-11-15', 'F', '11911112223', 'Solteira', 'Rua dos Pinheiros, 1600 - São Paulo/SP', 'Analista de Compliance', 'Compliance', 6800.00, '2023-07-01', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 17
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Thiago Mendes', 'thiago.mendes@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (17, '22233344456', '222333445', '1988-12-03', 'M', '11922223334', 'Solteiro', 'Rua dos Corifeus, 1400 - São Paulo/SP', 'Analista de Segurança', 'Segurança', 8200.00, '2022-11-30', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 18
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Vanessa Lima', 'vanessa.lima@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (18, '33344455567', '333444556', '1992-05-20', 'F', '11933334445', 'Casada', 'Rua dos Carijós, 1200 - São Paulo/SP', 'Analista de Comunicação', 'Comunicação', 5800.00, '2023-08-15', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 19
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Gabriel Pereira', 'gabriel.pereira@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (19, '44455566678', '444555667', '1986-07-08', 'M', '11944445556', 'Divorciado', 'Rua dos Açores, 1000 - São Paulo/SP', 'Analista de Operações', 'Operações', 6500.00, '2022-12-10', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Colaborador 20
INSERT INTO TB_USUARIO (nome, email, senha_hash, role, ativo, data_criacao, data_atualizacao) 
VALUES ('Isabela Santos', 'isabela.santos@empresa.com', '123456', 'COLABORADOR', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_COLABORADOR (usuario_id, cpf, rg, data_nascimento, sexo, telefone, estado_civil, endereco, cargo, departamento, salario, data_admissao, status, data_criacao, data_atualizacao) 
VALUES (20, '55566677789', '555666778', '1993-02-14', 'F', '11955556667', 'Solteira', 'Rua dos Araçás, 800 - São Paulo/SP', 'Analista de Inovação', 'Inovação', 7000.00, '2023-09-01', 'ATIVO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); 