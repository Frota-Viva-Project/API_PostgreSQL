# Sobre o Projeto

A Frota Viva é um projeto que ajuda frotas de caminhões a terem maior controle sobre seus veículos, e caminhoneiros a gerirem melhor seu caminhão. O aplicativo, conectado ao veículo, fornece dados técnicos de forma simples e mostra alertas automáticos sobre falhas e manutenções. A empresa também gerencia motoristas, entregas, custos e manutenções de modo mais eficiente.

### Principais Funcionalidades

- **Monitoramento em Tempo Real** - Acompanhe a localização e status dos veículos
- **Gestão de Manutenções** - Controle preventivo e corretivo da frota
- **Alertas Inteligentes** - Notificações automáticas para situações críticas
- **Notificações Push** - Comunicação instantânea via Firebase
- **Integração Arduino** - Coleta de dados dos sensores dos veículos
- **Autenticação Segura** - JWT + Firebase Auth para máxima segurança
- **API Documentada** - Swagger/OpenAPI para fácil integração

## Tecnologias Utilizadas

### Backend
- **Java 21** - Linguagem principal
- **Spring Boot 3.5.4** - Framework web
- **Spring Security** - Autenticação e autorização
- **Spring Data JPA** - Persistência de dados
- **JWT** - Tokens de autenticação

### Banco de Dados
- **PostgreSQL** - Banco principal
- **Redis** - Cache e sessões

### Integração
- **Firebase Admin SDK** - Notificações push e autenticação
- **MapStruct** - Mapeamento de objetos
- **Swagger/OpenAPI** - Documentação da API

### DevOps
- **Docker** - Containerização
- **Maven** - Gerenciamento de dependências

## Pré-requisitos

Antes de começar, você precisa ter instalado:

- **Java 21** ou superior
- **Maven 3.6+**
- **Docker** (opcional, para execução com containers)
- **PostgreSQL** (se não usar Docker)
- **Redis** (se não usar Docker)

## Como Executar

### Opção 1: Execução Local

1. **Clone o repositório**
```bash
git clone <url-do-repositorio>
cd FrotaVivaPostgreApi
```

2. **Configure as variáveis de ambiente**
Crie um arquivo `.env` na raiz do projeto:
```env
POSTGRES_URL=jdbc:postgresql://localhost:5432/frota_viva
POSTGRES_USER=seu_usuario
POSTGRES_PASSWORD=sua_senha
REDIS_HOST=localhost
REDIS_PORT=6379
REDIS_USER=seu_usuario_redis
REDIS_PASSWORD=sua_senha_redis
API_USERNAME=admin
API_PASSWORD=sua_senha_api
```

3. **Execute a aplicação**
```bash
./mvnw spring-boot:run
```

### Opção 2: Docker

1. **Build da imagem**
```bash
docker build -t frota-viva-api .
```

2. **Execute com Docker Compose** (recomendado)
```bash
docker-compose up -d
```

A API estará disponível em: `http://localhost:8080`

## Documentação da API

Após executar a aplicação, acesse a documentação interativa:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

## Autenticação

A API utiliza JWT para autenticação. Para acessar os endpoints protegidos:

1. **Faça login** no endpoint `/v1/api/auth/login`
2. **Use o token** retornado no header `Authorization: Bearer <token>`

### Exemplo de Login
```bash
curl -X POST http://localhost:8080/v1/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username": "admin", "password": "sua_senha"}'
```

## Principais Endpoints

### Autenticação
- `POST /v1/api/auth/login` - Login tradicional
- `POST /v1/api/auth/firebase` - Autenticação via Firebase

### Gestão de Frota
- `GET /v1/api/caminhoes` - Listar caminhões
- `POST /v1/api/caminhoes` - Cadastrar caminhão
- `PUT /v1/api/caminhoes/{id}` - Atualizar caminhão

### Manutenções
- `GET /v1/api/manutencoes` - Listar manutenções
- `POST /v1/api/manutencoes` - Agendar manutenção

### Notificações FCM
- `PUT /v1/api/fcm/register` - Registrar token FCM
- `POST /v1/api/fcm/send` - Enviar notificação
- `GET /v1/api/fcm/history/{userId}` - Histórico de notificações

### Alertas
- `GET /v1/api/alertas` - Listar alertas
- `POST /v1/api/alertas` - Criar alerta

## Configuração do Firebase

Para usar as funcionalidades de notificação push:

1. **Crie um projeto no Firebase Console**
2. **Baixe o arquivo de configuração** `firebase-adminsdk.json`
3. **Coloque o arquivo** em `src/main/resources/`
4. **Configure as credenciais** nas variáveis de ambiente


## Build para Produção

```bash
./mvnw clean package -DskipTests
```

O arquivo JAR será gerado em `target/FrotaVivaPostgreApi-0.0.1-SNAPSHOT.jar`