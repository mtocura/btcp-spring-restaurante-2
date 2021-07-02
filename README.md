# Aula 3 - Introdução a MVC e Injeção de Dependências - TM

## Exercício 1 - Restaurante

Este repositório contém a melhoria da api de restaurante presente no repositório: https://github.com/mtocura/btcp-spring-restaurante


- POST ```` /aula2/tt/mesas ````
    - Cria uma mesa
    - body request
    ````
    {
      "pedidos": [
          {
              "pratos": [
                  {
                      "preco": 20.50,
                      "descricao": "Virada Paulista",
                      "quantidade": 1
                  },
                  {
                      "preco": 16.50,
                      "descricao": "Bolo de Chocolate",
                      "quantidade": 1
                  }
              ]
          },
          {
              "pratos": [
                  {
                      "preco": 32.99,
                      "descricao": "Pizza",
                      "quantidade": 1
                  },
                  {
                      "preco": 16.50,
                      "descricao": "Torta",
                      "quantidade": 1
                  }
              ]
          }
      ]
    }
    ````
    - retorna o path onde foi criado o registro


- GET ````` /aula2/tt/mesas `````
    - retorna todas as mesas registradas
    - body response:
    ````
    [
      {
          "pedidos": [
              {
                  "pratos": [
                      {
                          "preco": 20.5,
                          "descricao": "Virada Paulista",
                          "quantidade": 1
                      },
                      {
                          "preco": 16.5,
                          "descricao": "Bolo de Chocolate",
                          "quantidade": 1
                      }
                  ],
                  "total": 37.0
              },
              {
                  "pratos": [
                      {
                          "preco": 32.99,
                          "descricao": "Pizza",
                          "quantidade": 1
                      },
                      {
                          "preco": 16.5,
                          "descricao": "Torta",
                          "quantidade": 1
                      }
                  ],
                  "total": 49.49
              }
          ],
          "valorTotal": 86.49000000000001
      },
      {
          "pedidos": [
              {
                  "pratos": [
                      {
                          "preco": 20.5,
                          "descricao": "Virada Paulista",
                          "quantidade": 1
                      },
                      {
                          "preco": 16.5,
                          "descricao": "Bolo de Chocolate",
                          "quantidade": 1
                      }
                  ],
                  "total": 37.0
              },
              {
                  "pratos": [
                      {
                          "preco": 32.99,
                          "descricao": "Pizza",
                          "quantidade": 1
                      },
                      {
                          "preco": 16.5,
                          "descricao": "Torta",
                          "quantidade": 1
                      }
                  ],
                  "total": 49.49
              }
          ],
          "valorTotal": 86.49000000000001
      }
    ]
    ````


- GET ```` /aula2/tt/mesas/{id} ````
    - retorna todos os pedidos da mesa juntamente com o valor total
    - body response:
    ````
    [
        {
            "pratos": [
                {
                    "preco": 20.5,
                    "descricao": "Misoshiro",
                    "quantidade": 2
                },
                {
                    "preco": 18.0,
                    "descricao": "Tempura",
                    "quantidade": 1
                }
            ],
            "status": "NOVO",
            "data": "2/7/2021",
            "totalPedido": 59.0
        }
    ]
    ````

- GET ```` /aula2/tt/mesas/{dia}/{mes}/{ano} ````
    - retorna todos os pedidos de uma data
    - body response:
    ````
    [
        {
            "pratos": [
                {
                    "preco": 20.5,
                    "descricao": "Misoshiro",
                    "quantidade": 2
                },
                {
                    "preco": 18.0,
                    "descricao": "Tempura",
                    "quantidade": 1
                }
            ],
            "status": "NOVO",
            "data": "2/7/2021",
            "totalPedido": 59.0
        }
    ]
    ````


- GET ```` /aula2/tt/mesas/{id}/checkout ````
    - fecha a conta da mesa
    - limpa os pedidos da mesa
    - adiciona o valor total no saldo do caixa
    - retorna o valor total da mesa
    ````
    [
        {
            "pratos": [],
            "status": "FINALIZADO",
            "data": "2/7/2021",
            "totalPedido": 0.0
        }
    ]
    ````

- GET ````/aula2/tt/caixa ````
    - retorna o saldo do caixa
    - body response:
    `````
    [
        {
            "data": "2/7/2021",
            "valor": 59.0,
            "saldo": 118.0
        }
    ]
    `````

- GET ````/aula2/tt/caixa/{dia}/{mes}/{ano} ````
    - retorna um array com todos os registros de saldo do caixa de uma data
    - body response:
    `````
    [
        {
            "data": "2/7/2021",
            "valor": 59.0,
            "saldo": 118.0
        }
    ]
    `````