package core.solution.deepleads;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API DeepLeads",
                version = "1.0.0",
                description = "Lista de Serviços utilizados na DeepLeads. O projeto DeepLeads tem como principal objetivo auxiliar negócios locais a construírem sua estratégia de geração de leads de forma abrangente. Nossa aplicação oferece uma ampla gama de funcionalidades, semelhantes às encontradas no site DeepLeads. Essas funcionalidades incluem: \n" +
                        "    \uD83C\uDF10 Navegação: Explore facilmente todas as seções da nossa plataforma.\n" +
                        "    \uD83D\uDCDD CRUDs / Formulários: Gerencie e colete informações importantes por meio de formulários e operações CRUD (Criar, Ler, Atualizar, Excluir).\n" +
                        "    \uD83D\uDCCA API de Mineração de Leads: Aproveite nossa API para extrair dados valiosos de leads.\n",
                license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")
        ),
        servers = @Server(url = "http://localhost:8080")


)
public class SwaggerConfig {


}
