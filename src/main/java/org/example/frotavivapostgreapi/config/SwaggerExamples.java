package org.example.frotavivapostgreapi.config;

import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerExamples {

    @Bean
    public Example loginRequestExample() {
        return new Example()
                .summary("Exemplo de login")
                .description("Exemplo de requisição de login com usuário e senha")
                .value("""
                    {
                        "username": "motorista@empresa.com",
                        "password": "senha123"
                    }
                    """);
    }

    @Bean
    public Example loginResponseExample() {
        return new Example()
                .summary("Resposta de login bem-sucedido")
                .description("Token JWT retornado após login bem-sucedido")
                .value("""
                    {
                        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
                        "tokenType": "Bearer",
                        "expiresIn": 86400000
                    }
                    """);
    }

    @Bean
    public Example alertaRequestExample() {
        return new Example()
                .summary("Exemplo de criação de alerta")
                .description("Exemplo de requisição para criar um novo alerta")
                .value("""
                    {
                        "tipo": "MANUTENCAO",
                        "descricao": "Temperatura do motor acima do normal",
                        "prioridade": "ALTA",
                        "localizacao": "Rodovia BR-101, KM 150"
                    }
                    """);
    }

    @Bean
    public Example alertaResponseExample() {
        return new Example()
                .summary("Resposta de alerta criado")
                .description("Dados do alerta criado com sucesso")
                .value("""
                    {
                        "id": 123,
                        "tipo": "MANUTENCAO",
                        "descricao": "Temperatura do motor acima do normal",
                        "prioridade": "ALTA",
                        "status": "ATIVO",
                        "localizacao": "Rodovia BR-101, KM 150",
                        "dataHoraCriacao": "2024-10-29T10:30:00Z",
                        "caminhaoId": 1
                    }
                    """);
    }

    @Bean
    public Example caminhaoResponseExample() {
        return new Example()
                .summary("Dados do caminhão")
                .description("Informações completas do caminhão com motorista e sensores")
                .value("""
                    {
                        "id": 1,
                        "placa": "ABC-1234",
                        "modelo": "Volvo FH 540",
                        "status": "EM_ROTA",
                        "capacidade": 25000,
                        "motorista": {
                            "id": 1,
                            "nome": "João Silva",
                            "cnh": "12345678901",
                            "telefone": "(11) 99999-9999"
                        },
                        "arduino": {
                            "id": 1,
                            "temperatura": 85.5,
                            "pressaoOleo": 4.2,
                            "nivelCombustivel": 75.0,
                            "velocidade": 80,
                            "rpm": 1800,
                            "ultimaLeitura": "2024-10-29T10:25:00Z"
                        }
                    }
                    """);
    }

    @Bean
    public Example fcmTokenRequestExample() {
        return new Example()
                .summary("Registro de token FCM")
                .description("Exemplo de registro de token para notificações push")
                .value("""
                    {
                        "userId": 123,
                        "token": "dGhpcyBpcyBhIGZha2UgZmNtIHRva2Vu...",
                        "deviceType": "ANDROID",
                        "deviceModel": "Samsung Galaxy S21",
                        "appVersion": "1.2.3"
                    }
                    """);
    }

    @Bean
    public Example notificationRequestExample() {
        return new Example()
                .summary("Envio de notificação")
                .description("Exemplo de envio de notificação push")
                .value("""
                    {
                        "userIds": [123, 456, 789],
                        "title": "Alerta de Manutenção",
                        "body": "Seu caminhão ABC-1234 precisa de manutenção urgente",
                        "data": {
                            "alertaId": "123",
                            "caminhaoId": "1",
                            "tipo": "MANUTENCAO",
                            "prioridade": "ALTA"
                        },
                        "priority": "HIGH"
                    }
                    """);
    }

    @Bean
    public Example manutencaoRequestExample() {
        return new Example()
                .summary("Criação de manutenção")
                .description("Exemplo de agendamento de manutenção")
                .value("""
                    {
                        "tipo": "PREVENTIVA",
                        "descricao": "Troca de óleo e filtros",
                        "dataAgendada": "2024-11-15T08:00:00Z",
                        "quilometragem": 150000,
                        "oficina": "Oficina Central Ltda",
                        "custoEstimado": 850.00
                    }
                    """);
    }

    @Bean
    public Example rotaRequestExample() {
        return new Example()
                .summary("Criação de rota")
                .description("Exemplo de criação de nova rota")
                .value("""
                    {
                        "origem": "São Paulo, SP",
                        "destino": "Rio de Janeiro, RJ",
                        "distanciaKm": 430,
                        "tempoEstimado": "06:30:00",
                        "dataInicio": "2024-10-30T06:00:00Z",
                        "observacoes": "Rota com pedágio, evitar horário de pico"
                    }
                    """);
    }

    @Bean
    public Example errorResponseExample() {
        return new Example()
                .summary("Erro de validação")
                .description("Exemplo de resposta de erro com detalhes")
                .value("""
                    {
                        "timestamp": "2024-10-29T10:30:00Z",
                        "status": 400,
                        "error": "Bad Request",
                        "message": "Dados de entrada inválidos",
                        "details": [
                            "Campo 'placa' é obrigatório",
                            "Campo 'capacidade' deve ser maior que zero"
                        ],
                        "path": "/v1/api/caminhoes"
                    }
                    """);
    }
}
