# DeepLeads

## Sobre o Projeto

O projeto DeepLeads tem como principal objetivo auxiliar negócios locais a construírem sua estratégia de geração de leads de forma abrangente. Nossa aplicação oferece uma ampla gama de funcionalidades, semelhantes às encontradas no site DeepLeads. Essas funcionalidades incluem:

- 🌐 **Navegação:** Explore facilmente todas as seções da nossa plataforma.
- 📝 **CRUDs / Formulários:** Gerencie e colete informações importantes por meio de formulários e operações CRUD (Criar, Ler, Atualizar, Excluir).
- 📊 **API de Mineração de Leads:** Aproveite nossa API para extrair dados valiosos de leads.

## Tecnologias Utilizadas

Nosso projeto foi desenvolvido usando as seguintes tecnologias:

- ☕ **Java com Spring Boot:** Para construir a infraestrutura robusta e escalável.
- 💻 **IDE IntelliJ:** Recomendamos o uso do IntelliJ como a melhor IDE para desenvolvimento e teste em nosso ambiente.
- 🌐 **Google Chrome:** Para uma experiência de usuário ideal, recomendamos o uso do Google Chrome como navegador.

## Requisitos para Utilização

Antes de começar a utilizar nossos serviços, certifique-se de atender aos seguintes requisitos:

- ☕ **Java 17 JDK:** É necessário ter o Java Development Kit (JDK) versão 17 instalado.
- 💻 **IDE IntelliJ:** Recomendamos o uso do IntelliJ como ambiente de desenvolvimento.
- 🌐 **Google Chrome:** Para obter a melhor experiência de usuário em nossa plataforma, utilize o Google Chrome como seu navegador padrão.

## Documentação com Swagger

Para acessar a documentação completa da nossa API, utilize o Swagger. A documentação inclui informações detalhadas sobre os endpoints, parâmetros e exemplos de uso.

- 📖 **Documentação Swagger:** [/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Anexos de Documentação

Dentro da aplicação, disponibilizamos uma pasta chamada "postman-collection" que contém uma lista de serviços disponíveis:

- 📋 **Cadastro de Usuários:** Realiza o Cadastro dos usuários na plataforma.
  - URL: [http://localhost:8080/api/auth/signup](http://localhost:8080/api/auth/signup)

- 📋 **Buscar Cadastros:** Retorna a lista de cadastros no Banco de Dados.
  - URL: [http://localhost:8080/api/buscarCadastros](http://localhost:8080/api/buscarCadastros)

- 📋 **Login:** Login efetuado com Sucesso.
  - URL: [http://localhost:8080/api/auth/signin](http://localhost:8080/api/auth/signin)

- 📋 **Atualizar Dados de Usuário:** Atualiza os dados dos usuarios.
  - URL: [http://localhost:8080/api/usuario/atualizar](http://localhost:8080/api/usuario/atualizar)

- 📋 **Deletar Usuário:** Deleta os dados dos usuarios.
  - URL: [http://localhost:8080/api/usuario/deletar](http://localhost:8080/api/usuario/deletar)

- 📋 **Listagem Paginada:** Listagem paginada.
  - URL: [http://localhost:8080/api/usuario/](http://localhost:8080/api/usuario/)

- 📋 **Chat GPT:** Api de integração com o Chat Gpt.
  - URL: [http://localhost:8080/api/generative/ia/generate/ia/](http://localhost:8080/api/generative/ia/generate/ia/)

- 📋 **Salvar Interação com o Chat GPT:** Salva a interação do usuario com o Chat GPT.
  - URL: [http://localhost:8080/api/generative/ia/post/campaigns/by-url-id](http://localhost:8080/api/generative/ia/post/campaigns/by-url-id)

- 📋 **Google Maps:** Api de integração com o Google Maps Latitude Longitude.
  - URL: [http://localhost:8080/api/google/maps/](http://localhost:8080/api/google/maps/)

- 📋 **Mineração de Dados:** Api responsavel por minerar dados no google maps obs: (a busca é baseada no parametro de usuario).
  - URL: [http://localhost:8080/api/mineracao/generate/leads/by-id](http://localhost:8080/api/mineracao/generate/leads/by-id)

- 📋 **Listagem de URLs Mineradas:** Api responsavel pela listagem de urls mineradas pelo usuario.
  - URL: [http://localhost:8080/api/mineracao/get/url/by-user](http://localhost:8080/api/mineracao/get/url/by-user)

- 📋 **Listagem de Leads Minerados:** Api responsavel pela listagem de leads minerados pelo usuario.
  - URL: [http://localhost:8080/api/mineracao/get/leads/by-id](http://localhost:8080/api/mineracao/get/leads/by-id)

## Como Começar

Siga estas etapas simples para começar a utilizar o DeepLeads:

1. Clone este repositório em sua máquina local.
2. Abra o projeto em sua IDE IntelliJ.
3. Certifique-se de que o Java 17 JDK esteja configurado como o JDK padrão em seu ambiente de desenvolvimento.
4. Execute o projeto e acesse-o no Google Chrome para começar a explorar e utilizar as funcionalidades.

## Contribuições

Aceitamos contribuições da comunidade. Se você quiser contribuir para o projeto, por favor siga estas diretrizes:

1. Faça um fork do repositório.
2. Crie sua branch de desenvolvimento: `git checkout -b feature/nova-funcionalidade`.
3. Faça as alterações desejadas e commit-as: `git commit -m 'Adiciona nova funcionalidade'`.
4. Envie suas alterações para o repositório remoto: `git push origin feature/nova-funcionalidade`.
5. Abra um pull request explicando suas alterações e por que elas são necessárias.

## Contato

Para obter mais informações ou esclarecer dúvidas, entre em contato conosco em jhonatas2004@gmai.com.

Agradecemos por escolher o DeepLeads para impulsionar sua estratégia de geração de leads!
