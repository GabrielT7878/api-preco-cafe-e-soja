
# API Preço da Saca Café e Soja

Essa API é um projeto desenvolvido em Java utilizando Spring Boot, que fornece a cotação diária atualizada da saca de café e soja.

Os dados são obtidos através do site do CEPEA (Centro de Estudos Avançados em Economia Aplicada) sob a licença não comercial Creative Commons (CC BY NC, https://creativecommons.org/licenses/by-nc/4.0/).




## Instalação

1. **Clone o repositório:**

   ```sh
   git clone https://github.com/GabrielT7878/api-preco-cafe-e-soja
   cd api-preco-cafe-e-soja
   ```
2. **Crie um Database Mysql**
    ```bash
    create database produto-api
    ```

3. **Configure as variáveis de ambiente**

+ abra `src/main/resources/application.properties`
+ mude `spring.datasource.username` / `spring.datasource.password` e `spring.datasource.url`de acordo com as suas credenciais do banco de dados.

4. **Inicie a API usando o gradle**

```bash
./gradlew bootRun
```
A api vai iniciar em <http://localhost:8080>

## Endpoint

A api conta com um endpoint sendo obrigatório a passagem o parâmetro {produto}

### Get

| Método | Url                    | Descrição                                                | Corpo da Requisição | 
|--------|------------------------|----------------------------------------------------------|--------------------|
| GET    | /preco?produto=cafe | Retorna o preço diário atualizado da commodity escolhida | [JSON](signup)     |


## Exemplos de requisições e respostas


##### <a id="signup"> =>  /preco?commoditie=cafe</a>
```json
{
  "produto": "cafe",
  "data": "05/09/2024",
  "valorR$": 1439.95,
  "variacaoDia": "-0,24%",
  "variacaoMes": "-0,57%",
  "valorU$$": 258.1
}
```

##### <a id="signup"> =>  /preco?commoditie=soja</a>
```json
{
  "produto": "soja",
  "data": "05/09/2024",
  "valorR$": 140.66,
  "variacaoDia": "-0,68%",
  "variacaoMes": "1,83%",
  "valorU$$": 25.21
}
```