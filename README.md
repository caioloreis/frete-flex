# 🚚 Frete Flex

Sistema de cálculo de frete construído com **Java 21** e **Spring Boot**, que permite calcular o custo de envio de pacotes utilizando diferentes estratégias de cálculo.

Este projeto também serve como estudo prático de injeção de dependência no Spring, explorando as anotações `@Qualifier` e `@Primary` para resolver ambiguidades entre múltiplos Beans (`ShippingCalculator`).

## 📋 Sobre o projeto

O **FreteFlex** oferece duas estratégias de cálculo de frete:

| Tipo | Fórmula | Característica |
|---|---|---|
| **Standard** (Normal) | `custo = peso * 1.0 + distância * 0.5` | Mais barato, sem urgência |
| **Express** (Expresso) | `custo = peso * 1.5 + distância * 0.75` | Mais caro, entrega prioritária |

O usuário informa o **peso** do pacote, a **distância** de envio e o **tipo** de frete desejado. O sistema seleciona a implementação de `ShippingCalculator` correspondente e calcula o custo.

## 🛠️ Tecnologias

- [Java 21](https://openjdk.org/projects/jdk/21/)
- [Spring Boot 4.1.0](https://spring.io/projects/spring-boot)
- [Spring Web (MVC)](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Maven](https://maven.apache.org/)

## ✅ Pré-requisitos

- [JDK 21](https://www.oracle.com/java/technologies/downloads/#java21) ou superior
- [Maven](https://maven.apache.org/download.cgi) (opcional, o projeto já inclui o Maven Wrapper)
- [Git](https://git-scm.com/)

## 🚀 Como executar

Clone o repositório:

```bash
git clone https://github.com/caioloreis/frete-flex.git
cd frete-flex
```

Execute a aplicação usando o Maven Wrapper:

```bash
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

### Build do projeto

```bash
./mvnw clean package
```

## 📡 API

### Calcular frete

```
GET /shipping/calculate
```

**Parâmetros de consulta:**

| Parâmetro | Tipo | Descrição |
|---|---|---|
| `weight` | número | Peso do pacote em kg |
| `distance` | número | Distância de envio em km |
| `type` | texto | Tipo de frete: `standard` ou `express` |

**Resposta:**

```json
{
  "shippingCost": 90.0
}
```

### Exemplo de uso

Enviar um pacote de **10 kg** por **100 km** com frete **express**:

```
GET /shipping/calculate?weight=10&distance=100&type=express
```

Cálculo:
- **Standard**: `10 * 1.0 + 100 * 0.5 = 60`
- **Express**: `10 * 1.5 + 100 * 0.75 = 90`

## 🏗️ Design da aplicação

O cálculo de frete é resolvido via **Strategy Pattern**, com múltiplas implementações da interface `ShippingCalculator` (uma para cada tipo de frete). A escolha do Bean correto na injeção de dependência é feita com o uso de:

- **`@Qualifier`** — para indicar explicitamente qual implementação (`standard` ou `express`) deve ser injetada.
- **`@Primary`** — para definir uma implementação padrão quando não há qualificação explícita.

## 📁 Estrutura do projeto

```
frete-flex/
├── .mvn/wrapper/       # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/       # Código-fonte (controllers, services, ShippingCalculator)
│   │   └── resources/  # Configurações da aplicação
│   └── test/           # Testes
├── mvnw / mvnw.cmd
└── pom.xml
```

## 🗺️ Possíveis melhorias

- [ ] Validação de parâmetros de entrada (peso/distância negativos, tipo inválido)
- [ ] Testes automatizados dos calculadores de frete
- [ ] Documentação da API (OpenAPI/Swagger)
- [ ] Novos tipos de frete (ex: econômico, internacional)

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas alterações (`git commit -m 'feat: adiciona nova feature'`)
4. Faça o push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 👤 Autor

**Caio Loreis**

- GitHub: [@caioloreis](https://github.com/caioloreis)
