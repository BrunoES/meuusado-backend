**KAFKA 2.13-3.2.1** & **ZOOKEEPER 3.8.0**

* Subindo zookeper:
bin\zkServer.cmd

* Subindo Kafka:
kafka-server-start.sh config/server.properties

* Criando Tópico:
kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MEUUSADO.ANNOUNCEMENT-VALIDATION

* Listando Tópicos existentes:
- kafka-topics.sh --list --bootstrap-server localhost:9092
- kafka-topics.sh --describe --bootstrap-server localhost:9092 --describe

* Criando Producer:
kafka-console-producer.sh --broker-list localhost:9092 --topic MEUUSADO.ANNOUNCEMENT-VALIDATION

* Criando Consumer para ler apenas novas mensagens:
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic MEUUSADO.ANNOUNCEMENT-VALIDATION

* Criando Consumer para ler todas mensagens desde o início:
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic MEUUSADO.ANNOUNCEMENT-VALIDATION --from-beginning

* Configurar partições de um tópico:
kafka-topics.sh --alter --zookeeper localhost:2181 --topic MEUUSADO.ANNOUNCEMENT-VALIDATION --partitions 3
 *** --partitions deve ser equivalente ao 'num.partitions' configurado em server.properties da instalação do Kafka.

* Listar grupos:
bin/windows/kafka-consumer-groups.sh --all-groups --bootstrap-server localhost:9092 --describe

#Observações importantes:
- Em um ambiente de produção, as configurações de diretórios dos arquivos server.properties(log.dirs) e zookeeper.properties (dataDir)
devem ser configuradas para um diretório fixo, e não ficar como /tmp/.
- Carro o Kafka se perca, limpar pastas tmp/zookeeper e tmp/kafka-logs

**Docker start**
* Exemplos:

* Infa:
- docker run --name postgres-db -p 5432:5432 -t id-imagem
- docker run --name mongo-db -p 27017:27017 -d mongo

* Modules:
- docker run --name eureka-server-0 -p 9090:9090 -t id-imagem
- docker run --name meuusado-core-0 -p 9003:9003 -t id-imagem
- docker run --name meuusado-validator-0 -p 9001:9001 -t id-imagem
- docker run --name meuusado-gateway-0 -p 9000:9000 -t id-imagem