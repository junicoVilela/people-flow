-- V8__Create_documento_colaborador.sql
-- Criação da tabela de documentos dos colaboradores

CREATE TABLE people_flow.tb_documento_colaborador (
    id BIGSERIAL PRIMARY KEY,
    colaborador_id BIGINT NOT NULL,
    tipo_documento VARCHAR(50) NOT NULL,
    descricao TEXT,
    caminho_arquivo TEXT NOT NULL,
    data_upload TIMESTAMP NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100),
    CONSTRAINT fk_documento_colaborador FOREIGN KEY (colaborador_id) REFERENCES people_flow.tb_colaborador(id)
);

-- Comentários
COMMENT ON TABLE people_flow.tb_documento_colaborador IS 'Tabela de documentos dos colaboradores';
COMMENT ON COLUMN people_flow.tb_documento_colaborador.id IS 'Identificador único do documento';
COMMENT ON COLUMN people_flow.tb_documento_colaborador.colaborador_id IS 'ID do colaborador';
COMMENT ON COLUMN people_flow.tb_documento_colaborador.tipo_documento IS 'Tipo do documento (RG, CPF, CERTIDAO, etc.)';
COMMENT ON COLUMN people_flow.tb_documento_colaborador.descricao IS 'Descrição do documento';
COMMENT ON COLUMN people_flow.tb_documento_colaborador.caminho_arquivo IS 'Caminho do arquivo no sistema';
COMMENT ON COLUMN people_flow.tb_documento_colaborador.data_upload IS 'Data de upload do documento'; 