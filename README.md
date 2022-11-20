## Simulador de requisições DNS

- A simulação deve ocorrer usando o modelo cliente/servidor fictício.

- As operações que o servidor deve realizar são:
  - Inserir, no mínimo, 100 nomes de sites e seus endereços IP.
  - Pode-se pesquisar sites reais ou criar nomes e endereços, seguindo o modelo
    apresentado.
  - A entrada de dados pode ser via interface com usuário, via arquivo ou direto no método
    main().
  - Inicia com 25 registros de sites armazenados e a cada dez segundos, 25 registros de sites
    devem ser inseridos no servidor DNS.
    - A tabela hash começa com um tamanho e vai aumentando.
  - Responder a requisições de clientes (navegadores simulados).
  - Crie uma classe específica para realizar as operações do servidor.
- As operações que o cliente pode realizar são:
  - A partir de um nome de um site, criar uma requisição ao servidor DNS com o objetivo de
    obter as informações de conexão: ip:porta.
  - O cliente faz o papel de um navegador web ao receber o nome de um site e solicitar o
    resolução do nome ao DNS.
    - É um navegador simulado.
  - Realize quatro requisições:
    - Duas para sites que existem.
    - Dois para sites que não existem (inclui site com nome incorreto ou nome correto, mas que não está na base de dados).
