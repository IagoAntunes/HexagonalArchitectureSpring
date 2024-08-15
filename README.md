## Projeto Hexagonal com Kafka

### Descrição do Projeto

Este projeto é uma aplicação de exemplo que utiliza a arquitetura hexagonal (também conhecida como Arquitetura de Portas e Adaptadores) e integra o Apache Kafka para comunicação assíncrona entre serviços. A aplicação é desenvolvida em Kotlin e Java, utilizando o Spring Framework.

### Arquitetura Hexagonal

A arquitetura hexagonal é um estilo de arquitetura de software que visa criar aplicações altamente desacopladas e testáveis. Ela se baseia em três conceitos principais:

1. **Domínio**: Contém a lógica de negócios central da aplicação. É independente de qualquer tecnologia externa.
2. **Portas**: Interfaces que definem os pontos de entrada e saída da aplicação. Elas permitem a comunicação entre o domínio e o mundo externo.
3. **Adaptadores**: Implementações concretas das portas. Eles adaptam as chamadas do mundo externo para o domínio e vice-versa.

A arquitetura hexagonal promove a separação de preocupações, facilitando a manutenção e evolução do software.

### Apache Kafka

O Apache Kafka é uma plataforma de streaming distribuída que permite a publicação, assinatura, armazenamento e processamento de fluxos de registros em tempo real. Ele é amplamente utilizado para construir pipelines de dados em tempo real e sistemas de streaming.

Neste projeto, o Kafka é utilizado para comunicação assíncrona entre diferentes partes do sistema. A aplicação envia e consome mensagens de tópicos Kafka para processar dados de clientes.

### Estrutura do Projeto

- **Configurações do Kafka**: Configurações para o consumidor Kafka são definidas na classe `KafkaConsumerConfig`.
- **Consumidor Kafka**: A classe `ReceiveValidatedCustomerDataConsumer` consome mensagens do tópico Kafka `tp-cpf-validated` e processa os dados do cliente.
- **Adaptadores**: Implementações das portas de entrada e saída, como `InsertCustomerAdapter`, que insere dados de clientes no banco de dados MongoDB.
- **Mensagens**: A classe `CustomerMessage` define a estrutura das mensagens trocadas via Kafka.

### Executando o Projeto

Para executar o projeto, você pode utilizar o Docker Compose para configurar e iniciar os serviços necessários, incluindo Kafka, Zookeeper, MongoDB e outras ferramentas auxiliares.

```yaml
version: "3.1"
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    networks:
      - broker-kafka
    ports:
      - 2181:2181
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  kafka:
    image: confluentinc/cp-kafka:latest
    networks:
      - broker-kafka
    depends_on:
      - zookeeper
    ports:
      - 9092:9092
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:29092,PLAINTEXT_HOST://localhost:9092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1

  kafdrop:
    image: obsidiandynamics/kafdrop:latest
    networks:
      - broker-kafka
    depends_on:
      - kafka
    ports:
      - 9000:9000
    environment:
      KAFKA_BROKERCONNECT: kafka:29092

  mongo:
    image: mongo
    restart: always
    ports:
      - 27017:27017
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: example
    volumes:
      - mongo-data:/data/db

  mongo-express:
    image: mongo-express
    restart: always
    ports:
      - 8083:8083
    environment:
      ME_CONFIG_MONGODB_ADMINUSERNAME: root
      ME_CONFIG_MONGODB_ADMINPASSWORD: example
      ME_CONFIG_MONGODB_URL: mongodb://root:example@mongo:27017/

  wiremock:
    image: "wiremock/wiremock:latest"
    container_name: my_wiremock
    ports:
      - 8082:8080
    volumes:
      - ./__files:/home/wiremock/__files
      - ./mappings:/home/wiremock/mappings

networks:
  broker-kafka:
    driver: bridge

volumes:
  mongo-data:
```

### Contribuição

Sinta-se à vontade para contribuir com este projeto. Para isso, faça um fork do repositório, crie uma branch para suas alterações e envie um pull request.

### Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo `LICENSE` para obter mais informações.
