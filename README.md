# Carstore - Projeto Spring Boot

Este é um projeto prático desenvolvido com Spring Boot para implementar um sistema de gerenciamento de carros. O foco é praticar operações CRUD (Criar, Ler, Atualizar, Deletar) com Java, utilizando uma arquitetura dividida em áreas públicas e privadas. A aplicação permite visualizar carros em uma área acessível a todos, enquanto operações de gerenciamento (como adicionar, editar e excluir) ficam restritas à área logada (privada). Tudo é armazenado em um banco de dados H2 integrado via JPA, com validação de dados e uma interface web responsiva usando Thymeleaf.

## O que dá pra fazer

Área Pública (Não Logada)
- Visualização de Carros: Lista todos os carros cadastrados em uma tabela simples.
- Detalhes de Carros: Ao clicar em um carro na lista, o usuário pode visualizar informações detalhadas (nome e cor) em uma página separada.
- Interatividade: Destaque visual (amarelo) ao clicar em um item da lista para melhor experiência.
- Restrições: Não permite adicionar, editar ou excluir carros. Uma mensagem orienta o usuário a acessar a área privada para gerenciamento.

Área Privada (Logada)
- Adicionar Carros: Formulário para cadastrar novos carros com validação de campos obrigatórios (nome e cor).
- Editar Carros: Para cada carro na lista, há um formulário inline para atualizar nome e cor diretamente.
- Excluir Carros: Botão para remover carros da lista e do banco de dados.
- Listagem Completa: Tabela com todos os carros, incluindo ações de edição e exclusão.
- Validação: Campos obrigatórios com mensagens de erro.

## Tecnologias que usei

- Java 17: Linguagem principal.
- Spring Boot: Framework para desenvolvimento rápido de aplicações.
- Spring Data JPA: Para mapeamento objeto-relacional e operações no banco.
- Banco de dados H2 : Banco de dados em memória/file-based para desenvolvimento.
- Thymeleaf: Motor de templates para renderização de páginas HTML.
- Maven: Gerenciamento de dependências e build.
- Validação de Bean : Para validação de formulários.
- jQuery : Para interatividade simples (ex.: destaque na lista).

## Como rodar
1. Clone: git clone https://github.com/renanlallo/H2-CarStore-Spring.git
2. Compile: mvn clean install
3. Rode: mvn spring-boot:run
4. Acesse: http://localhost:8080 (pública) ou /secured-page (privada). Console H2: /console (usuário: sa, senha: sa).

## Sobre mim
Sou estudante de ads, elaborei esse projeto com Java e estou aprendendo a criar aplicações robustas e escaláveis. Esse projeto foi uma oportunidade para aplicar conceitos como JPA, validação, templates e separação de responsabilidades.
