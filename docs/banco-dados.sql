-- CRIAÇÃO DAS TABELAS - 04/05/2019 - LUCAS NOGUEIRA, lucasnogueiratdm@hotmail.com

DROP DATABASE callcenter;
CREATE DATABASE callcenter;
USE callcenter;

CREATE TABLE if not exists tbRegional -- ok
(
    idRegional          int not null AUTO_INCREMENT,
    nome                varchar(100) not null,
    
    CONSTRAINT PRIMARY KEY(idRegional)
);

CREATE TABLE if not exists tbSetor --ok
(
    idSetor          int not null AUTO_INCREMENT,
    nome             varchar(100) not null,
    idRegional       int not null,
   
    CONSTRAINT PRIMARY KEY(idSetor),
    
    CONSTRAINT FOREIGN KEY(idRegional) 
    REFERENCES tbRegional(idRegional)
);

CREATE TABLE if not exists tbCargo --ok
(
    idCargo              int not null AUTO_INCREMENT,
    nome                 varchar(100) not null,
    idSetor              int not null,
    CONSTRAINT PRIMARY KEY(idCargo),
    
    CONSTRAINT FOREIGN KEY(idSetor)
    REFERENCES tbSetor(idSetor)
);

CREATE TABLE if not exists tbCategoriaInativacao --ok
(
    idCategoriaInativacao          int not null AUTO_INCREMENT,
    nome                           varchar(100) not null,

    CONSTRAINT PRIMARY KEY(idCategoriaInativacao) 
);
-- FUNCIONARIO
--^
--|
-- RELAÇÃO MUITOS PARA MUITOS
CREATE TABLE if not exists tbFuncionarioGrupo --tabela many-to-many
(
    idFuncionarioGrupo  int not null AUTO_INCREMENT,
    idFuncionario       int not null,
    idGrupoAtendimento  int not null,
    CONSTRAINT PRIMARY KEY(idFuncionarioGrupo),
    
    CONSTRAINT FOREIGN KEY(idFuncionario)
    REFERENCES tbFuncionario(idFuncionario),

    CONSTRAINT FOREIGN KEY(idGrupoAtendimento)
    REFERENCES tbGrupoAtendimento(idGrupoAtendimento)
);
--|
--v
-- grupo atendimento
CREATE TABLE if not exists tbGrupoAtendimento
(
    idGrupoAtendimento  int not null AUTO_INCREMENT,
    nome                varchar(100) not null,
    idFuncionarioGrupo  int not null,

    CONSTRAINT PRIMARY KEY(idGrupoAtendimento),

    CONSTRAINT FOREIGN KEY(idFuncionarioGrupo) 
    REFERENCES(tbFuncionarioGrupo)
);

CREATE TABLE if not exists tbFuncionario
(
    idFuncionario           int not null AUTO_INCREMENT,
    nome                    varchar(100) not null,
    cpf                     varchar(14) not null,
    dataContratacao         varchar(100) not null,
    matricula               int(20) not null,
    email                   varchar(100) not null,

    idFuncionarioGrupo          int not null,
    idCategoriaInativacao       int,
    idUsuario                   int,
    idUsuarioDoResponsavel      int not null,
    
    CONSTRAINT PRIMARY KEY(idFuncionario),
    
    CONSTRAINT FOREIGN KEY(idFuncionarioGrupo) 
    REFERENCES(tbFuncionarioGrupo),

    CONSTRAINT FOREIGN KEY(idCategoriaInativacao)
    REFERENCES tbCategoriaInativacao(idCategoriaInativacao),

    CONSTRAINT FOREIGN KEY(idUsuario)
    REFERENCES(tbUsuario),

    CONSTRAINT FOREIGN KEY(idUsuarioDoResponsavel)
    REFERENCES(tbUsuario)
);

CREATE TABLE if not exists tbCategoria
 (
    idCategoria     int not null AUTO_INCREMENT,
    nome            varchar(100) not null,

    CONSTRAINT PRIMARY KEY(idCategoria)
);

CREATE TABLE if not exists tbSubcategoria
(
    idSubcategoria      int not null AUTO_INCREMENT,
    nome                varchar(100) not null,
    prazoAtendimento    Date not null,
    idCategoria         int not null,

    CONSTRAINT PRIMARY KEY(idSubCategoria),

    CONSTRAINT FOREIGN KEY(idCategoria)
    REFERENCES tbCategoria(idCategoria)
);

CREATE TABLE if not exists tbChamado
 (
    idChamado           int not null AUTO_INCREMENT,
    nome                varchar(100) not null,
    descricao           varchar(200),
    dataInicio          varchar(50) not null,
    dataFechamento      varchar(50) not null,
    idGrupoAtendimento  int not null,
    idCategoria         int not null,
    statusChamado       int not null,
    detalhesChamado blob, -- imagem deve ser armazenada 
                          -- em um conjunto de bytes
    CONSTRAINT PRIMARY KEY(idChamado),

    CONSTRAINT FOREIGN KEY(idGrupoAtendimento)
    REFERENCES tbGrupoAtendimento(idGrupoAtendimento),

    CONSTRAINT FOREIGN KEY(idCategoria)
    REFERENCES tbCategoria(idCategoria)
);



-- many-to-many
CREATE TABLE IF NOT EXISTS tbPerfilUsuario(
    idPerfilUsuario         int not null AUTO_INCREMENT,
    idPerfil                int not null,
    idUsuario               int not null,

    CONSTRAINT PRIMARY KEY(idPerfilUsuario),
    
    CONSTRAINT FOREIGN KEY(idUsuario)
    REFERENCES(tbUsuario),

    CONSTRAINT FOREIGN KEY(idPerfil)
    REFERENCES(tbPerfil)
);

CREATE TABLE if not exists tbUsuario(
    idUsuario       int not null AUTO_INCREMENT,
    nome            varchar(100) not null,
    senha           varchar(100) not null,
    idPerfilUsuario        int not null,

    CONSTRAINT PRIMARY KEY(idUsuario),
    
    CONSTRAINT FOREIGN KEY(idPerfilUsuario)
    REFERENCES(tbPerfilUsuario)
);

CREATE TABLE IF NOT EXISTS tbPerfil(
    idPerfil            int not null AUTO_INCREMENT,
    nome                varchar(100) not null,
    idPerfilUsuario     int not null,

    CONSTRAINT PRIMARY KEY(idPerfil),

    CONSTRAINT FOREIGN KEY(idPerfilUsuario)
    REFERENCES(tbPerfilUsuario)
);