#!/bin/bash

# Script para limpar scripts desnecessários e ambiente
# Execute este script para remover scripts temporários e de teste

echo "=== LIMPEZA DE SCRIPTS E AMBIENTE ==="

# ====================================================================
# REMOVER SCRIPTS TEMPORÁRIOS
# ====================================================================

echo "Removendo scripts temporários..."

# Remover scripts de teste e temporários
rm -f docker/postgres/init/04-reorder-columns.sql
rm -f docker/postgres/init/05-check-constraints.sql

echo "✅ Scripts temporários removidos"

# ====================================================================
# MANTER APENAS SCRIPTS ESSENCIAIS
# ====================================================================

echo "Verificando scripts essenciais..."

# Listar scripts que devem permanecer
echo "Scripts essenciais mantidos:"
ls -la docker/postgres/init/

# ====================================================================
# LIMPAR LOGS E ARQUIVOS TEMPORÁRIOS
# ====================================================================

echo "Limpando logs e arquivos temporários..."

# Remover logs do Maven
rm -rf target/
rm -rf people-flow-app/node_modules/
rm -rf people-flow-app/dist/

# Limpar cache do Maven
mvn clean

echo "✅ Cache e logs limpos"

# ====================================================================
# VERIFICAR VOLUMES DOCKER
# ====================================================================

echo "Verificando volumes Docker..."

# Listar volumes
docker volume ls | grep people-flow

echo "Para remover volumes Docker, execute:"
echo "docker volume rm people-flow_postgres_data_dev"

# ====================================================================
# LIMPAR CONTAINERS (OPCIONAL)
# ====================================================================

echo ""
echo "Para limpar containers Docker, execute:"
echo "docker compose -f docker-compose.dev.yml down"
echo "docker compose -f docker-compose.dev.yml down -v"

# ====================================================================
# MENSAGEM FINAL
# ====================================================================

echo ""
echo "=== LIMPEZA CONCLUÍDA ==="
echo "✅ Scripts temporários removidos"
echo "✅ Cache limpo"
echo "✅ Ambiente organizado"
echo ""
echo "Para recriar o ambiente:"
echo "1. docker compose -f docker-compose.dev.yml up -d"
echo "2. ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev"
echo ""
echo "Para limpar completamente o banco:"
echo "docker exec -i people-flow-postgres-dev psql -U people_flow_user -d people_flow_db < docker/postgres/init/06-drop-all-entities.sql" 