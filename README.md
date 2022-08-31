**KAFKA 2.13-3.2.1** & **ZOOKEEPER 3.8.0**

* Subindo zookeper:
bin\zkServer.cmd

* Subindo Kafka:
bin\windows\kafka-server-start.bat config/server.properties

* Criando Tópico:
bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MEUUSADO.ANNOUNCEMENT-VALIDATION

* Listando Tópicos existentes:
bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
bin\windows\kafka-topics.bat --describe --bootstrap-server localhost:9092 --describe

* Criando Producer:
bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic MEUUSADO.ANNOUNCEMENT-VALIDATION

* Criando Consumer para ler apenas novas mensagens:
bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic MEUUSADO.ANNOUNCEMENT-VALIDATION

* Criando Consumer para ler todas mensagens desde o início:
bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic MEUUSADO.ANNOUNCEMENT-VALIDATION --from-beginning

* Configurar partições de um tópico:
bin\windows\kafka-topics.bat --alter --zookeeper localhost:2181 --topic MEUUSADO.ANNOUNCEMENT-VALIDATION --partitions 3
 *** --partitions deve ser equivalente ao 'num.partitions' configurado em server.properties da instalação do Kafka.

* Listar grupos:
bin/windows/kafka-consumer-groups.bat --all-groups --bootstrap-server localhost:9092 --describe

#Observações importantes:
- Em um ambiente de produção, as configurações de diretórios dos arquivos server.properties(log.dirs) e zookeeper.properties (dataDir)
devem ser configuradas para um diretório fixo, e não ficar como /tmp/.
- Carro o Kafka se perca, limpar pastas tmp/zookeeper e tmp/kafka-logs

**Docker start**
* Exemplos:

- docker run --name eureka-server-0 -p 9090:9090 -t id-imagem
- docker run --name meuusado-core-0 -p 9003:9003 -t id-imagem
- docker run --name meuusado-validator-0 -p 9001:9001 -t id-imagem
- docker run --name meuusado-gateway-0 -p 9000:9000 -t id-imagem