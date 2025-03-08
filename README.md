# PC Maker Rebuild
Não é uma aplicação completa nova, mas utiliza de conceitos novos aprendido e melhorias do uso de JPA, e uso de novas versões de dependências, assim como a utilização de Swagger.

## Principais Tecnologias
 - **Java 17**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;

## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
  direction LR
  class User {
    +String name
    +String email
    +Date updatedAt
    +Date createdAt
  }
  
  class Builds {
    +String name
    +double total
    +String description
    +Date updatedAt
    +Date createdAt
  }
  
  class Item {
    +int quantity
    +double subTotal
    +int indexOfMarketplace
  }
  
  class Product {
    +String name
    +String madeBy
    +String model
    +String category
    +Date updatedAt
    +Date createdAt
  }
  
  class Marketplace {
    +double price
    +String store
    +String linkProduct
  }
  
  User "1" -- "*" Builds : owns
  Builds "1" -- "*" Item : contains
  Item "1" -- "*" Product : includes
  Product "1" -- "*" Marketplace : available at
```