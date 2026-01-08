# 🔗 URL Shortener (Encurtador de URLs)

Este é um projeto de API REST desenvolvido com **Java** e **Spring Boot** para encurtar URLs longas. O objetivo principal é transformar links grandes em identificadores curtos (baseados em Base62) que redirecionam o usuário para o endereço original.

> 🚧 **Nota:** Este projeto utiliza armazenamento em memória (HashMap) para fins de estudo e prototipagem rápida.

## 🚀 Tecnologias Utilizadas

* **Java 17** (ou versão superior)
* **Spring Boot 3**
* **Maven** (Gerenciamento de dependências)
* **Lombok** (Para redução de código boilerplate - opcional)

## ⚙️ Como Funciona

A lógica de encurtamento utiliza um algoritmo de conversão para **Base62** (caracteres `0-9`, `a-z`, `A-Z`).

1.  A API recebe uma URL original.
2.  Gera um identificador único ou hash.
3.  Converte esse identificador para uma string curta em Base62 (ex: `8M0kX`).
4.  Armazena o par `chave : url_original` em um banco de dados em memória (`HashMap`).
5.  Ao acessar a rota de redirecionamento com a chave, a API devolve um status `302 (Found)` com o header `Location` apontando para a URL original.

