FROM postgres:14.3

ENV POSTGRES_PASSWORD 1234
COPY meu_usado_dump_v1.sql /docker-entrypoint-initdb.d/

EXPOSE 1521