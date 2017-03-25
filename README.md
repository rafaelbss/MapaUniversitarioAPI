Mapa Universitário - API RESTFul
===================
Este projeto é uma API RESTFul que implementa todos os métodos de persistência de dados do projeto [MapaUniversitarioWeb](https://github.com/rafaelbss/MapaUniversitarioWeb/)

Métodos da API
===================
## Listar todos os marcadores:

OBS: Um marcador é representado pela classe Marker.class que possui os seguintes atributos: nome, latitude, longitude, telefone, tipo, facebookUser, detalhes e observações.

[GET] /MapaUniversitarioAPI/markers/

A url acima retorna um objeto JSON com uma coleção de objetos do tipo Marker.class.

![Mapa Universitário](/src/main/java/app/web/mu/api/resources/mrest01.png)

## Listar um marcador específico:

[GET] /MapaUniversitarioAPI/markers/{id}

A url acima retorna um objeto JSON com um objeto específico do tipo Marker.class através do parâmetro {id}.

![Mapa Universitário](/src/main/java/app/web/mu/api/resources/mrest02.png)

## Salvando um novo marcador do tipo MoradiaMarker.class:

[POST] /MapaUniversitarioAPI/markers/moradias/

A url acima salva um novo marcador e retorna uma String com a url de acesso do novo recurso criado. Um objeto do tipo MoradiaMarker.class é passado no corpo da solicitação.

![Mapa Universitário](/src/main/java/app/web/mu/api/resources/mrest03.png)

## Atualizando um novo marcador do tipo MoradiaMarker.class:

[PUT] /MapaUniversitarioAPI/markers/moradias/{id}

A url acima atualiza um marcador existente. Um parâmetro id é passado como parâmetro da URL e um objeto do tipo MoradiaMarker.class é passado no corpo da solicitação.

![Mapa Universitário](/src/main/java/app/web/mu/api/resources/mrest04.png)

## Excluindo um marcador existente do tipo MoradiaMarker.class:

[DELETE] /MapaUniversitarioAPI/markers/moradias/{id}

A url acima remove um marcador existente. Um parâmetro id é passado como parâmetro da URL.

![Mapa Universitário](/src/main/java/app/web/mu/api/resources/mrest05.png)


Instalação
===================
O projeto foi desenvolvido utilizando:

- Eclipse Neon
- Java 8
- Apache Maven
- Spring Boot
- Spring Data
- MySQL

Pra configurar o projeto basta clonar ou fazer download do projeto: [https://github.com/rafaelbss/MapaUniversitarioAPI.git](https://github.com/rafaelbss/MapaUniversitarioAPI.git).

Para importar o projeto no Eclipse(Java EE) acesse:

File > Import > Maven > Existing maven projects.

Depois selecione o diretório onde o projeto foi baixado marque o projeto e clique em Finish.

Depois clique sobre o projeto > Maven > Update project.

Em seguida o maven irá baixar as dependências.


Estrutura do projeto
===================

![Mapa Universitário](/src/main/java/app/web/mu/api/resources/mrest06.png)

O pacote src/main/java/app/web.mu.api.business.model contém as entidades que serão persistidas no banco de dados.

O pacote src/main/java/app/web.mu.api.business.service contém as classes de negócio que se comunicam com a camada Repository de persistência de dados.

O pacote src/main/java/app/web.mu.api.business.service.exception contém as classes de exceção customizadas da API.

O pacote src/main/java/app/web.mu.api.business.service.exception.handler intercepta todas as exceções ocorridas durante a execução da API.

O pacote src/main/java/app/web.mu.api.persistence.repository contém todas as interfaces para persistência de dados.

O pacote src/main/java/app.web.mu.api.resources contém as classes que são anotadas como RestController e expõem os métodos da API.

O pacote src/main/resources contém os arquivos de internacionalização da API e o arquivo application.properties responsável pelas configurações centrais do Spring Boot.
