-- V3__Create_usuario.sql
-- Criação da tabela de usuários

CREATE TABLE people_flow.tb_usuario (
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

-- Índices para TB_USUARIO
CREATE INDEX idx_usuario_email ON people_flow.tb_usuario(email);
CREATE INDEX idx_usuario_ativo ON people_flow.tb_usuario(ativo);

-- Comentários
COMMENT ON TABLE people_flow.tb_usuario IS 'Tabela de usuários do sistema';
COMMENT ON COLUMN people_flow.tb_usuario.id IS 'Identificador único do usuário';
COMMENT ON COLUMN people_flow.tb_usuario.nome IS 'Nome completo do usuário';
COMMENT ON COLUMN people_flow.tb_usuario.email IS 'Email único do usuário';
COMMENT ON COLUMN people_flow.tb_usuario.senha_hash IS 'Hash da senha do usuário';
COMMENT ON COLUMN people_flow.tb_usuario.role IS 'Papel/perfil do usuário (ADMIN, RH, COLABORADOR)';
COMMENT ON COLUMN people_flow.tb_usuario.ativo IS 'Status ativo/inativo do usuário'; 