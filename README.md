📦 API RESTful de Gestão de Estoque (Spring Boot)
Esta aplicação é a evolução arquitetural do meu sistema de gestão original (APEX). O objetivo deste projeto foi migrar uma infraestrutura MVC baseada em Java puro/Servlets para uma API RESTful moderna e escalável, utilizando as melhores práticas do ecossistema Spring Boot.

O sistema gerencia o fluxo completo de Vendas, Produtos, Clientes e Usuários, garantindo a integridade do estoque através de regras de negócio estritas aplicadas na camada de serviço.

🚀 Destaques da Arquitetura e Boas Práticas:

Design em Camadas: Código estruturado de forma limpa separando responsabilidades em Controllers, Services, Repositories e Entities.

Tratamento Global de Exceções: Implementação de um @RestControllerAdvice (GlobalExceptionHandler) para capturar erros de validação e regras de negócio (BusinessException, ResourceNotFoundException), padronizando as respostas HTTP e melhorando a experiência de consumo da API.

Validação de Dados: Uso de Jakarta Bean Validation (@Valid, @NotNull, @DecimalMin, etc.) diretamente nas entidades para garantir a integridade dos payloads recebidos.

Transações Seguras: Controle de atomicidade no banco de dados com a anotação @Transactional, protegendo rotinas críticas como a baixa de estoque durante as vendas.

Regras de Negócio Customizadas: Lógicas dinâmicas de validação no ProdutoService, limitando a relação entre preço e estoque máximo/mínimo.

🛠️ Tecnologias Utilizadas:

Java 17+

Spring Boot & Spring Web (REST)

Spring Data JPA / Hibernate

Jakarta Validation

Padrão DTO e Tratamento de Exceções Estruturado
