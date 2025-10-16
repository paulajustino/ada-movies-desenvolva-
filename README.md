# 🎬 Exercício — API de Filmes com Filtros Dinâmicos

## Objetivo

Desenvolver o endpoint `/movies` para aceitar **todos os filtros possíveis** da entidade `Movie` via **query params**, realizando as consultas diretamente com **Hibernate/JPA**.

---

## Contexto

O projeto já contém:

- A entidade `Movie`
- O repositório `MovieRepository`
- O controlador `MovieController`
- Configuração funcional com JPA/Hibernate

Atualmente, o endpoint `/movies` aceita apenas o filtro por `genre`.

---

## O que deve ser feito

Implemente um endpoint GET `/movies` que aceite **qualquer combinação de filtros** via query params.  
Exemplo:

```http
GET /movies?title=Matrix&genre=Action&release_date=1999-03-31
```

Cada filtro é **opcional** — quando ausente, não deve afetar a busca.  
Os filtros devem ser aplicados diretamente na **consulta ao banco**, não em memória.

---

## Regras

1. Os filtros devem corresponder aos campos da entidade `Movie`:
    - `title`
    - `imageUrl`
    - `description`
    - `releaseDate`
    - `genre`
2. Utilize **consultas Hibernate/JPA**.
3. Não utilize `stream()` ou filtragem manual em memória.
4. Mantenha o mesmo endpoint `/movies`.
5. O retorno deve ser uma lista de filmes que correspondem aos critérios informados.

---

## Exemplo

### Requisição:
```http
GET /movies?genre=Drama
```

### Resposta:
```json
[
  {
    "id": 1,
    "title": "The Shawshank Redemption",
    "image_url": "https://...",
    "description": "A story about hope and friendship.",
    "release_date": "1994-09-22",
    "genre": "Drama"
  }
]
```

---

## Dica

Você pode explorar diferentes abordagens para construir as consultas dinâmicas, como:

- **`@Query` com JPQL**
- **`CriteriaBuilder`**
- **`Specification` (Spring Data JPA Specifications)**

Não é necessário seguir uma única estratégia. O objetivo é praticar **consultas dinâmicas com Hibernate**.
