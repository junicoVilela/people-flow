#!/bin/bash
# Wrapper simples para Maven

if command -v mvn &> /dev/null; then
    mvn "$@"
else
    echo "Maven não está instalado. Por favor, instale o Maven primeiro."
    exit 1
fi 