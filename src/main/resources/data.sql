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

-- ====================================================================
-- DEPARTAMENTOS
-- ====================================================================

-- Departamento de Tecnologia
INSERT INTO TB_DEPARTAMENTO (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Tecnologia', 'Departamento responsável pelo desenvolvimento de software e infraestrutura tecnológica', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Departamento de Recursos Humanos
INSERT INTO TB_DEPARTAMENTO (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Recursos Humanos', 'Departamento responsável pela gestão de pessoas e processos de RH', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Departamento Financeiro
INSERT INTO TB_DEPARTAMENTO (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Financeiro', 'Departamento responsável pela gestão financeira e contábil', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Departamento de Vendas
INSERT INTO TB_DEPARTAMENTO (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Vendas', 'Departamento responsável pelas vendas e relacionamento com clientes', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Departamento de Marketing
INSERT INTO TB_DEPARTAMENTO (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Marketing', 'Departamento responsável pela estratégia de marketing e comunicação', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Departamento de Operações
INSERT INTO TB_DEPARTAMENTO (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Operações', 'Departamento responsável pelos processos operacionais e logística', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Departamento de Qualidade
INSERT INTO TB_DEPARTAMENTO (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Qualidade', 'Departamento responsável pela garantia de qualidade de produtos e serviços', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Departamento de Suporte
INSERT INTO TB_DEPARTAMENTO (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Suporte', 'Departamento responsável pelo suporte técnico e atendimento ao cliente', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Departamento de Design
INSERT INTO TB_DEPARTAMENTO (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Design', 'Departamento responsável pelo design e experiência do usuário', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Departamento de Diretoria
INSERT INTO TB_DEPARTAMENTO (nome, descricao, ativo, data_criacao, data_atualizacao) 
VALUES ('Diretoria', 'Departamento da alta administração e gestão estratégica', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ====================================================================
-- CARGOS
-- ====================================================================

-- DEPARTAMENTO DE TECNOLOGIA (ID: 1)
INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Desenvolvedor Frontend Junior', 'Desenvolvedor especializado em interfaces de usuário e experiência do usuário', 'JUNIOR', 1, 4500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Desenvolvedor Frontend Pleno', 'Desenvolvedor frontend com experiência intermediária em projetos web', 'PLENO', 1, 6500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Desenvolvedor Frontend Senior', 'Desenvolvedor frontend experiente com liderança técnica', 'SENIOR', 1, 9000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Desenvolvedor Backend Junior', 'Desenvolvedor especializado em APIs e sistemas backend', 'JUNIOR', 1, 4800.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Desenvolvedor Backend Pleno', 'Desenvolvedor backend com experiência em arquitetura de sistemas', 'PLENO', 1, 7000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Desenvolvedor Backend Senior', 'Desenvolvedor backend especialista em arquitetura e escalabilidade', 'SENIOR', 1, 9500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Desenvolvedor Full Stack Junior', 'Desenvolvedor com conhecimento em frontend e backend', 'JUNIOR', 1, 5000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Desenvolvedor Full Stack Pleno', 'Desenvolvedor fullstack com experiência completa', 'PLENO', 1, 7500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Desenvolvedor Full Stack Senior', 'Desenvolvedor fullstack líder técnico', 'SENIOR', 1, 10000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Arquiteto de Software', 'Responsável pela arquitetura e design de sistemas complexos', 'SENIOR', 1, 12000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Tech Lead', 'Liderança técnica de equipes de desenvolvimento', 'SENIOR', 1, 11000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('DevOps Engineer', 'Especialista em infraestrutura e automação de deploy', 'PLENO', 1, 8000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- DEPARTAMENTO DE RECURSOS HUMANOS (ID: 2)
INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de RH Junior', 'Analista responsável por processos básicos de recursos humanos', 'JUNIOR', 2, 3500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de RH Pleno', 'Analista com experiência em gestão de pessoas e processos', 'PLENO', 2, 5000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de RH Senior', 'Analista especialista em estratégias de recursos humanos', 'SENIOR', 2, 7000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Coordenador de RH', 'Coordenação de equipes e processos de recursos humanos', 'SENIOR', 2, 8500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Especialista em Recrutamento', 'Especialista em processos de atração e seleção de talentos', 'PLENO', 2, 6000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Treinamento', 'Responsável por programas de capacitação e desenvolvimento', 'PLENO', 2, 5500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- DEPARTAMENTO FINANCEIRO (ID: 3)
INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista Financeiro Junior', 'Analista responsável por controles financeiros básicos', 'JUNIOR', 3, 3800.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista Financeiro Pleno', 'Analista com experiência em análises financeiras complexas', 'PLENO', 3, 5500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista Financeiro Senior', 'Analista especialista em estratégias financeiras e investimentos', 'SENIOR', 3, 7500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Contador', 'Responsável pela contabilidade e demonstrações financeiras', 'PLENO', 3, 6000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Controller', 'Responsável pelo controle financeiro e análises gerenciais', 'SENIOR', 3, 9000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- DEPARTAMENTO DE VENDAS (ID: 4)
INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Vendedor Junior', 'Vendedor responsável por vendas diretas e atendimento', 'JUNIOR', 4, 3000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Vendedor Pleno', 'Vendedor com experiência em vendas consultivas', 'PLENO', 4, 4500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Vendedor Senior', 'Vendedor especialista em grandes contas e negociações', 'SENIOR', 4, 6500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Coordenador de Vendas', 'Coordenação de equipes de vendas e metas', 'SENIOR', 4, 8000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Gerente de Vendas', 'Gestão estratégica da área de vendas', 'SENIOR', 4, 10000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- DEPARTAMENTO DE MARKETING (ID: 5)
INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Marketing Junior', 'Analista responsável por campanhas e análises básicas', 'JUNIOR', 5, 3500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Marketing Pleno', 'Analista com experiência em estratégias de marketing digital', 'PLENO', 5, 5200.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Marketing Senior', 'Analista especialista em estratégias de marketing e branding', 'SENIOR', 5, 7200.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Especialista em Marketing Digital', 'Especialista em campanhas digitais e SEO/SEM', 'PLENO', 5, 6000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Coordenador de Marketing', 'Coordenação de equipes e estratégias de marketing', 'SENIOR', 5, 8500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- DEPARTAMENTO DE OPERAÇÕES (ID: 6)
INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Operações Junior', 'Analista responsável por processos operacionais básicos', 'JUNIOR', 6, 3200.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Operações Pleno', 'Analista com experiência em otimização de processos', 'PLENO', 6, 4800.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Operações Senior', 'Analista especialista em gestão operacional e logística', 'SENIOR', 6, 6800.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Coordenador de Operações', 'Coordenação de operações e equipes operacionais', 'SENIOR', 6, 7500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- DEPARTAMENTO DE QUALIDADE (ID: 7)
INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Qualidade Junior', 'Analista responsável por testes e controle de qualidade', 'JUNIOR', 7, 3600.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Qualidade Pleno', 'Analista com experiência em processos de qualidade', 'PLENO', 7, 5200.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Qualidade Senior', 'Analista especialista em sistemas de gestão da qualidade', 'SENIOR', 7, 7000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Coordenador de Qualidade', 'Coordenação de processos de qualidade e certificações', 'SENIOR', 7, 8000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- DEPARTAMENTO DE SUPORTE (ID: 8)
INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Suporte Junior', 'Analista responsável por suporte técnico de primeiro nível', 'JUNIOR', 8, 3000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Suporte Pleno', 'Analista com experiência em suporte técnico avançado', 'PLENO', 8, 4500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Analista de Suporte Senior', 'Analista especialista em resolução de problemas complexos', 'SENIOR', 8, 6000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Coordenador de Suporte', 'Coordenação de equipes de suporte e SLA', 'SENIOR', 8, 7200.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- DEPARTAMENTO DE DESIGN (ID: 9)
INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Designer Junior', 'Designer responsável por criação de materiais gráficos', 'JUNIOR', 9, 3800.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Designer Pleno', 'Designer com experiência em projetos visuais complexos', 'PLENO', 9, 5500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Designer Senior', 'Designer especialista em direção de arte e branding', 'SENIOR', 9, 7800.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('UX/UI Designer', 'Designer especializado em experiência e interface do usuário', 'PLENO', 9, 6800.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Diretor de Arte', 'Direção criativa e estratégica de projetos visuais', 'SENIOR', 9, 9500.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- DEPARTAMENTO DE DIRETORIA (ID: 10)
INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Diretor Executivo', 'Direção executiva e estratégica da empresa', 'SENIOR', 10, 25000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Diretor de Tecnologia', 'Direção estratégica da área de tecnologia', 'SENIOR', 10, 20000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Diretor Financeiro', 'Direção estratégica da área financeira', 'SENIOR', 10, 18000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Diretor de Vendas', 'Direção estratégica da área comercial', 'SENIOR', 10, 22000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Diretor de Marketing', 'Direção estratégica da área de marketing', 'SENIOR', 10, 16000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Diretor de Operações', 'Direção estratégica da área operacional', 'SENIOR', 10, 17000.00, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- CARGOS INATIVOS (para teste)
INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Estagiário de TI', 'Cargo de estágio em tecnologia da informação', 'JUNIOR', 1, 1500.00, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TB_CARGO (nome, descricao, nivel, departamento_id, salario_base, ativo, data_criacao, data_atualizacao) 
VALUES ('Assistente Administrativo', 'Cargo de assistência administrativa geral', 'JUNIOR', 2, 2500.00, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); 