---
marp: true
---
<!-- 
_class: lead 
-->

# Dataaccess-Vergleich

---

# Disclaimer
* NICHT VOLLSTÄNDIG
* nur aufzeigen, worauf man bei der Wahl des Dataaccess-Layers achten kann
* nicht jedes Tool nennt sich hier ORM
* nicht alle Features betrachtet:
    * Connection Pooling
    * spezielle SQL-Features (JSON_AGG in jOOQ)

---

# ORM-Features (1)

DataSource-Verwaltung
* DB-Verbindung automatisch verwalten, Sessions erstellen, Pooling

Objekt-Mapping
* ResultSet/RowSet -> <T> -> PreparedStatement-Parameter

Relation-Mapping
* automatisches Mapping OneToMany/ManyToOne/OneToOne/ManyToMany

---

# ORM-Features (2)

Query-Abstraktion
* Übersetzung von Abfragen in SQL-Dialekte (Postgres/Oracle/MySQL/MSSQL…)

Native Queries
* Abfragen nativ im SQL-Dialekt schreiben

---

# ORM-Features (3)
Optimistic Locking
* Überschreiben alter Stände verhindern (UPDATE WHERE ID=? AND VERSION=?)

Automatisches Batching
* Automatisches Sammeln anstehender INSERT/UPDATE/DELETE-Statements, um Netzwerk-Zyklen zu verringern
* Flushing bei Selects/Transaktionsende

---

# ORM-Features (4)
Manuelles Batching
* INSERT/UPDATE/DELETE-Statements im Bulk ausführen

Caching
* 1st Level Cache, um Selects by ID aus zuvor abgerufenen Session-Objekten abzurufen

Transaktions-Abstraktion
* Transaktions-Klammern setzen, Rollback bei Fehlern, Commit bei Erfolg

---

| Feature\Tool           | JPA (JpaRepo/Dao) | Spring Data JDBC Repos | Spring JDBC Template | GORM (Golang) |
|------------------------|-------------------|-------------------------------|----------|--------|
| DataSource             | JTA               | Spring                        | Spring               | sql.DB |
| Objekt-Mapping         | X                 | X                             | Bean-Property-RowMapper| X      |
| Relation-Mapping       | X                 | X                             |                      | X      |
| Query-Abstraktion      | X | X |  | X |
| Native Queries         | X | X | X | X |

---
| Feature\Tool           | JPA (JpaRepo/Dao) | Spring Data JDBC Repos | Spring JDBC Template | GORM (Golang) |
|------------------------|-------------------|-------------------------------|----------|--------|
| Optimistic Locking     | X | X |	 |
| Automatisches Batching | X |  | |
| Manuelles Batching     | X | X | X | X |
| Caching (1st+)         | X |  |  | |
| Transaktions-Abstraktion | JTA | Spring | Spring | GORM |

---

|  | QueryDSL SQL | jOOQ | Apache Commons DbUtils
|-|--|--|--|
| DataSource | | | X
| Objekt-Mapping | | | X
| Query-Abstraktion | X | X |
| Optimistic Locking | | X |
| Manuelles Batching | X | | 	