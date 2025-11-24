

## Data service

Port: 8083

Start app

- `docker-compose up -d`
- `./mvnw spring-boot:run`

Stop app

- `docker-compose down`



## Report Service



### check clickhouse 

- `docker-compose up -d`

- `docker ps`

- `docker exec -it clickhouse clickhouse-client -u user --password pass`

- `SHOW DATABASES;`

- ```
  CREATE TABLE IF NOT EXISTS db.user_events
    (
    	event_date Date,
    	event_time DateTime,
    	id         UInt64,
    	event_type String
    )
    ENGINE = MergeTree
    PARTITION BY toYYYYMM(event_date)
    ORDER BY (event_date, id);
  
  ```

  