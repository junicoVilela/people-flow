# People Flow

Um sistema moderno de gestão de fluxo de pessoas e recursos humanos desenvolvido com **Arquitetura Hexagonal** (Ports & Adapters), seguindo os princípios da **Arquitetura Limpa**.

## 🏗️ Arquitetura

O **People Flow** foi estruturado seguindo os princípios da **Arquitetura Hexagonal**, com uma clara separação entre as responsabilidades:

```
src/main/java/com/vilelatech/rh/
├── adapters/                       # 🔧 Implementações
│   ├── inbound/                    # Adapters de Entrada (mais explícito)
│   │   └── web/
│   │       └── controller/         # Controllers REST
│   │           ├── AuthController.java
│   │           └── ColaboradorController.java
│   └── outbound/                   # Adapters de Saída (mais explícito)
│       ├── persistence/            # Persistência JPA
│       │   ├── entity/            # Entidades JPA
│       │   │   ├── ColaboradorEntity.java
│       │   │   ├── RegistroPontoEntity.java
│       │   │   └── UsuarioEntity.java
│       │   ├── repository/         # Repositórios JPA
│       │   │   ├── ColaboradorJpaRepository.java
│       │   │   ├── RegistroPontoJpaRepository.java
│       │   │   └── UsuarioJpaRepository.java
│       │   ├── ColaboradorRepositoryAdapter.java
│       │   ├── RegistroPontoRepositoryAdapter.java
│       │   └── UsuarioRepositoryAdapter.java
│       └── messaging/              # Adaptadores de Mensageria
│           └── kafka/              # Integração com Kafka
│               ├── ColaboradorEventProducer.java
│               └── RegistroPontoEventProducer.java
├── application/                     # 💼 Casos de Uso
│   ├── dto/                        # DTOs organizados por contexto
│   │   ├── auth/                   # DTOs de autenticação
│   │   │   ├── LoginRequest.java
│   │   │   └── LoginResponse.java
│   │   └── colaboradorModel/            # DTOs de colaboradorModel
│   │       ├── ColaboradorRequest.java
│   │       ├── ColaboradorResponse.java
│   │       ├── ColaboradorUpdateRequest.java
│   │       └── InativacaoRequest.java
│   ├── exception/                  # 🚨 Exceções de Aplicação
│   │   ├── EntidadeNaoEncontradaException.java
│   │   ├── NegocioException.java
│   │   ├── ValidacaoException.java
│   │   └── AutenticacaoException.java
│   ├── mapper/                     # Mappers de conversão
│   │   ├── ColaboradorDtoMapper.java
│   │   ├── ColaboradorMapper.java
│   │   ├── RegistroPontoMapper.java
│   │   └── UsuarioMapper.java
│   └── usecase/                    # Regras de negócio
│       ├── auth/
│       │   ├── AuthUseCase.java
│       │   └── JwtProvider.java
│       └── colaboradorModel/
│           └── ColaboradorUseCase.java
├── domain/                           # 🎯 Núcleo de Negócio
│   ├── event/                      # 📢 Eventos de Domínio
│   │   ├── ColaboradorCriadoEvent.java
│   │   ├── ColaboradorInativadoEvent.java
│   │   ├── RegistroPontoLancadoEvent.java
│   │   └── DomainEventPublisher.java
│   ├── exception/                  # 🚨 Exceções de Domínio
│   │   ├── ColaboradorInvalidoException.java
│   │   ├── RegistroPontoInvalidoException.java
│   │   └── RegrasNegocioException.java
│   ├── model/                      # Entidades e enums de domínio
│   │   ├── Colaborador.java
│   │   ├── RegistroPonto.java
│   │   ├── Role.java
│   │   ├── Status.java
│   │   ├── TipoRegistro.java
│   │   └── Usuario.java
│   └── validation/                 # 🔍 Validações Críticas de Domínio
│       ├── CpfValidator.java
│       └── EmailValidator.java
├── infrastructure/                 # ⚙️ Configurações Técnicas
│   ├── config/
│   │   ├── JpaConfig.java
│   │   └── SecurityTestConfig.java
│   ├── messaging/                  # 📨 Configurações de Mensageria
│   │   ├── KafkaConfig.java
│   │   ├── EventPublisherConfig.java
│   │   └── SpringDomainEventPublisher.java
│   └── security/
│       ├── JwtAuthenticationEntryPoint.java
│       ├── JwtAuthenticationFilter.java
│       └── SecurityConfig.java
├── ports/                           # 🔌 Contratos (Interfaces)
│   ├── ColaboradorRepository.java
│   ├── RegistroPontoRepository.java
│   └── UsuarioRepository.java
├── common/                         # 🛠️ Utilitários Compartilhados (renomeado de shared)
│   ├── util/                       # Utilitários comuns
│   │   ├── DateUtil.java
│   │   └── StringUtil.java
│   └── validation/                 # Validações de Aplicação
│       ├── ValidadorCpf.java
│       ├── ValidadorEmail.java
│       └── ValidadorTelefone.java
└── RhApplication.java              # 🚀 Classe principal
```

### 🎯 Benefícios da Arquitetura

- **🔌 Ports**: Definem **contratos claros** entre as camadas
- **🔧 Adapters**: **Implementações concretas** que podem ser facilmente substituídas
- **💼 Application**: **Casos de uso** independentes de frameworks externos
- **🎯 Domain**: **Regras de negócio puras**, sem dependências externas
- **📦 DTOs Organizados**: Agrupados por **contexto de negócio** para melhor manutenibilidade
- **🚨 Exceções Centralizadas**: Hierarquia organizada de exceções por camada
- **📢 Eventos de Domínio**: Suporte a event sourcing e comunicação assíncrona
- **🔍 Validações Críticas**: Validadores de domínio para regras de negócio essenciais
- **🛠️ Utilitários Comuns**: Helpers e validações reutilizáveis organizados
- **📨 Mensageria Estruturada**: Configurações e adaptadores organizados por broker
- **🎯 Nomenclatura Explícita**: `inbound/outbound` mais clara que `in/out`
- **📋 Separação Clara**: Validações críticas no domínio, validações de aplicação em `common`

## ✨ Funcionalidades

### 🔐 **Autenticação e Autorização**
- Login com e-mail e senha (texto plano para desenvolvimento)
- Geração e validação de tokens JWT
- Controle de acesso por perfil (`ADMIN`, `RH`, `COLABORADOR`)
- CORS configurado adequadamente

### 👥 **Gestão de Colaboradores**
- ✅ Cadastro de colaboradores com validação robusta
- 📋 Listagem de colaboradores otimizada (todos/ativos)
- 🔍 Visualização de detalhes (query otimizada)
- ✏️ Edição de dados com validações
- ❌ Inativação (demissão)

## 🔧 **Melhorias Implementadas**

### 🛡️ **Segurança**
- **Password Encoder Simples**: Senhas em texto plano para desenvolvimento
- **CORS Restritivo**: Apenas origens autorizadas
- **Validação de Entrada**: Bean Validation em todos os DTOs

### 🚨 **Tratamento de Exceções**
- **GlobalExceptionHandler**: Tratamento centralizado e padronizado
- **Exceções Específicas**: Substituição de `IllegalArgumentException`
- **Respostas Estruturadas**: Formato RFC 7807 para erros
- **Logging Apropriado**: Diferentes níveis por tipo de erro

### ⚡ **Performance**
- **JOIN FETCH**: Eliminação de queries N+1
- **Queries Otimizadas**: Carregamento de dados relacionados em uma única consulta
- **Lazy Loading**: Carregamento sob demanda quando apropriado

### ✅ **Validações**
- **Validação de CPF**: Formato e estrutura
- **Validação de Email**: Formato válido
- **Validação de Dados**: Campos obrigatórios e limites
- **Mensagens Descritivas**: Feedback claro para o usuário

## 🛠️ Tecnologias Utilizadas

### **Backend**
- ☕ **Java 21** - Linguagem de programação
- 🍃 **Spring Boot 3.2.5** - Framework principal
- 🔒 **Spring Security** - Segurança e autenticação
- 🗄️ **Spring Data JPA** - Persistência de dados otimizada
- 🎫 **JWT** - Tokens de autenticação
- 🗃️ **H2 Database** - Banco em memória (desenvolvimento)
- 🔧 **MapStruct** - Mapeamento automático entre objetos
- 📝 **Lombok** - Redução de código boilerplate
- ✅ **Bean Validation** - Validação de entrada robusta

### **Arquitetura**
- 🏗️ **Hexagonal Architecture** (Ports & Adapters)
- 🧹 **Clean Architecture** - Separação de responsabilidades
- 📦 **Domain-Driven Design** - Organização por contextos de negócio
- 🚨 **Tratamento Global de Exceções** - Respostas padronizadas
- ⚡ **Otimizações de Performance** - JOIN FETCH para evitar N+1

## 🚀 Como Executar

### 📋 **Pré-requisitos**
- ☕ JDK 21 ou superior
- 📦 Maven 3.8+

### 🔧 **Passos**

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/people-flow.git
   cd people-flow
   ```

2. **Compile e execute**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Acesse a aplicação**
   - **API**: http://localhost:8080
   - **H2 Console**: http://localhost:8080/h2-console
   - **Documentação**: Swagger UI (se habilitado)

### 🧪 **Testando as Melhorias**

#### **Usuários de Teste** (senha: `123456`)
- **Admin**: `admin@empresa.com` 
- **RH**: `rh@empresa.com`
- **Colaborador**: `joao.silva@empresa.com`

#### **Endpoints Principais**
```bash
# Login
POST /api/auth/login
{
  "email": "admin@empresa.com",
  "password": "123456"
}

# Criar colaborador (requer token)
POST /api/colaboradores
{
  "nome": "João Silva",
  "email": "novo@empresa.com",
  "senha": "123456",
  "cpf": "12345678901",
  "dataNascimento": "1990-01-01",
  "cargo": "Desenvolvedor",
  "departamento": "TI",
  "salario": 5000.00,
  "dataAdmissao": "2024-01-01"
}

# Listar colaboradores (com paginação otimizada)
GET /api/colaboradores?page=0&size=10

# Buscar por ID (query otimizada)
GET /api/colaboradores/1
```

#### **Testando Validações**
```bash
# Dados inválidos retornarão erro estruturado
POST /api/colaboradores
{
  "nome": "A",           # Muito curto
  "email": "email-invalido", # Formato inválido
  "cpf": "123",          # CPF inválido
  "salario": -100        # Valor negativo
}
```

#### **Testando Exceções**
```bash
# Entidade não encontrada
GET /api/colaboradores/999

# Resposta estruturada:
{
  "timestamp": "2024-01-01T10:00:00",
  "status": 404,
  "error": "Entidade não encontrada",
  "message": "Colaborador com ID 999 não foi encontrado(a)"
}
```