# cp2-devops-livraria

##2TDSPS

96409 - Leonardo Guimarães de Lima Marques

97385 - José Carlos da Silva

97569 - Maria Luiza de Goveia Lima

96906 - Mariana Marques Sabio

96881 - Vinícius de Abreu Pena
________________________________________________________________________________________________________________

Link da API - https://api-livraria.azurewebsites.net/livros

Gihub - https://github.com/marisabio/cp2-devops-livraria

É um API Rest simples para o cadastro de livros de uma livraria. Requests GET, POST, PUT e DELETE mapeados.

Pra mais informações, só acessar https://api-livraria.azurewebsites.net/swagger-ui/index.html

Query para a tabela dos livros no SQL Server:

CREATE TABLE livro (
        livro_id VARCHAR(30) PRIMARY KEY,
	
        livro_titulo VARCHAR(200) NOT NULL,
	
        livro_autor VARCHAR(200) NOT NULL,
	
        senha_cliente VARCHAR(15) NOT NULL,
	
        setor_cliente VARCHAR2(100)
	
    );

Modelo de JSON para a inserção ou modificação dos livros por POST ou PUT:

{
	"livroId": "03",
	"livroTitulo": "Os Cães Ladram",
	"livroAutor": "Truman Capote",
	"livroAnoPublicacao": "1977"
}
