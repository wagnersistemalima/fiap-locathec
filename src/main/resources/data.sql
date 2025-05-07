CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    placa VARCHAR(10) NOT NULL,
    ano INT NOT NULL,
    cor VARCHAR(20) NOT NULL,
    valor_diaria DECIMAL(10, 2) NOT NULL);

INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria) VALUES
('Toyota', 'Corolla', 'ABC1234', 2020, 'Preto', 100.00),
('Honda', 'Civic', 'XYZ5678', 2019, 'Branco', 120.00),
('Ford', 'Fiesta', 'LMN9101', 2021, 'Vermelho', 80.00),
('Chevrolet', 'Onix', 'QRS2345', 2022, 'Azul', 90.00),
('Volkswagen', 'Gol', 'TUV6789', 2018, 'Prata', 70.00);

CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL);

INSERT INTO pessoas (nome, cpf, telefone, email) VALUES
('João Silva', '12345678900', '11987654321', 'joao.silva@email.com'),
('Maria Oliveira', '98765432100', '21912345678', 'maria.oliveira@email.com'),
('Carlos Santos', '45678912300', '31998765432', 'carlos.santos@email.com'),
('Ana Costa', '78912345600', '41976543210', 'ana.costa@email.com'),
('Fernanda Lima', '32165498700', '51934567890', 'fernanda.lima@email.com');