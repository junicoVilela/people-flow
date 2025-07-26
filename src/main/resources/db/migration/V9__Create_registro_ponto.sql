-- V9__Create_registro_ponto.sql
-- Criação da tabela de registros de ponto

CREATE TABLE people_flow.tb_registro_ponto (
    id BIGSERIAL PRIMARY KEY,
    colaborador_id BIGINT NOT NULL,
    data_registro DATE NOT NULL,
    hora_entrada TIME,
    hora_saida TIME,
    total_horas DECIMAL(5,2),
    observacao TEXT,
    tipo_registro VARCHAR(20) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    criado_por VARCHAR(100),
    atualizado_por VARCHAR(100),
    CONSTRAINT fk_registro_ponto_colaborador FOREIGN KEY (colaborador_id) REFERENCES people_flow.tb_colaborador(id)
);

-- Comentários
COMMENT ON TABLE people_flow.tb_registro_ponto IS 'Tabela de registros de ponto dos colaboradores';
COMMENT ON COLUMN people_flow.tb_registro_ponto.id IS 'Identificador único do registro de ponto';
COMMENT ON COLUMN people_flow.tb_registro_ponto.colaborador_id IS 'ID do colaborador';
COMMENT ON COLUMN people_flow.tb_registro_ponto.data_registro IS 'Data do registro de ponto';
COMMENT ON COLUMN people_flow.tb_registro_ponto.hora_entrada IS 'Hora de entrada do colaborador';
COMMENT ON COLUMN people_flow.tb_registro_ponto.hora_saida IS 'Hora de saída do colaborador';
COMMENT ON COLUMN people_flow.tb_registro_ponto.total_horas IS 'Total de horas trabalhadas';
COMMENT ON COLUMN people_flow.tb_registro_ponto.observacao IS 'Observações sobre o registro de ponto';
COMMENT ON COLUMN people_flow.tb_registro_ponto.tipo_registro IS 'Tipo do registro (ENTRADA, SAIDA, INTERVALO)'; 