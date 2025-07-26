-- V10__Create_justificativa_ponto.sql
-- Criação da tabela de justificativas de ponto

CREATE TABLE people_flow.tb_justificativa_ponto (
    id BIGSERIAL PRIMARY KEY,
    registro_ponto_id BIGINT NOT NULL,
    motivo TEXT NOT NULL,
    status VARCHAR(20) NOT NULL,
    data_analise TIMESTAMP,
    analista_id BIGINT,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100),
    CONSTRAINT fk_justificativa_ponto_registro FOREIGN KEY (registro_ponto_id) REFERENCES people_flow.tb_registro_ponto(id)
);

-- Comentários
COMMENT ON TABLE people_flow.tb_justificativa_ponto IS 'Tabela de justificativas de ponto dos colaboradores';
COMMENT ON COLUMN people_flow.tb_justificativa_ponto.id IS 'Identificador único da justificativa';
COMMENT ON COLUMN people_flow.tb_justificativa_ponto.registro_ponto_id IS 'ID do registro de ponto';
COMMENT ON COLUMN people_flow.tb_justificativa_ponto.motivo IS 'Motivo da justificativa';
COMMENT ON COLUMN people_flow.tb_justificativa_ponto.status IS 'Status da justificativa (PENDENTE, APROVADA, REJEITADA)';
COMMENT ON COLUMN people_flow.tb_justificativa_ponto.data_analise IS 'Data de análise da justificativa';
COMMENT ON COLUMN people_flow.tb_justificativa_ponto.analista_id IS 'ID do analista que analisou a justificativa'; 