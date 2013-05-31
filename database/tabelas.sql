CREATE TABLE Pedidos
(
	PedidoId INT NOT NULL IDENTITY(1,1),
	Data DATETIME NOT NULL,
	Espera INT NOT NULL DEFAULT (40 + (CONVERT(INT, (RAND(DATEPART(MILLISECOND,GETDATE())) * 10000)) % 10)),
	NomeCliente VARCHAR(30) NOT NULL,
	Endereco VARCHAR(50) NOT NULL,
	Bairro VARCHAR(20) NOT NULL
);

CREATE TABLE PedidosItens
(
	PedidoId INT NOT NULL,
	Indice INT NOT NULL,
	Id INT NOT NULL,
	Tipo INT NOT NULL,
	Tamanho INT NOT NULL,
	Quantidade INT NOT NULL
);

ALTER TABLE PedidosItens ADD ValorUnitario DECIMAL(5,2) NOT NULL DEFAULT 0.0;

ALTER TABLE Pedidos ADD FormaPagto INT NOT NULL DEFAULT 1;
ALTER TABLE Pedidos ADD TrocoPara DECIMAL(6,2) NOT NULL DEFAULT 0.0;
ALTER TABLE Pedidos ADD Telefone INT NOT NULL DEFAULT 0;