-- CRIAÇÃO DAS TABELAS - 04/05/2019 - LUCAS NOGUEIRA, lucasnogueiratdm@hotmail.com

DROP DATABASE callcenter;
CREATE DATABASE callcenter;
USE callcenter;

CREATE TABLE if not exists tbRegional 
(
    idRegional          int(6) AUTO_INCREMENT,
    nome                varchar(100) not null,
    
    CONSTRAINT PRIMARY KEY(idRegional)
);

CREATE TABLE if not exists tbSetor 
(
    idSetor          int(6) AUTO_INCREMENT,
    nome             varchar(100) not null,
    idRegional       int(6) not null,
   
    CONSTRAINT PRIMARY KEY(idSetor),
    
    CONSTRAINT fk_Regional FOREIGN KEY(idRegional) 
    REFERENCES tbRegional(idRegional)
);

CREATE TABLE if not exists tbCargo 
(
    idCargo              int(6) AUTO_INCREMENT,
    nome                 varchar(100) not null,
    idSetor              int(6) not null,
    CONSTRAINT PRIMARY KEY(idCargo),
    
    CONSTRAINT fk_Setor FOREIGN KEY(idSetor)
    REFERENCES tbSetor(idSetor)
);

CREATE TABLE if not exists tbCategoriaInativacao 
(
    idCategoriaInativacao          int(6) AUTO_INCREMENT,
    nome                           varchar(100) not null,
    CONSTRAINT PRIMARY KEY(idCategoriaInativacao) 
);

CREATE TABLE if not exists tbCategoria
 (
    idCategoria     int(6) AUTO_INCREMENT,
    nome            varchar(100) not null,

    CONSTRAINT PRIMARY KEY(idCategoria)
);

CREATE TABLE if not exists tbSubcategoria
(
    idSubcategoria      int(6) AUTO_INCREMENT,
    nome                varchar(100) not null,
    prazoAtendimento    Date not null,
    idCategoria         int(6) not null,

    CONSTRAINT fk_Subcategoria PRIMARY KEY(idSubCategoria),

    CONSTRAINT fk_Categoria FOREIGN KEY(idCategoria)
    REFERENCES tbCategoria(idCategoria)
);

-- many-to-many
CREATE TABLE if not exists tbFuncionarioGrupo 
(
    idFuncionarioGrupo  int(6) AUTO_INCREMENT,
    idFuncionario       int(6) not null,
    idGrupoAtendimento  int(6) not null,

    CONSTRAINT PRIMARY KEY(idFuncionarioGrupo)
);

CREATE TABLE if not exists tbGrupoAtendimento
(
    idGrupoAtendimento  int(6) AUTO_INCREMENT,
    nome                varchar(100) not null,
    idFuncionarioGrupo  int(6) not null,

    CONSTRAINT PRIMARY KEY(idGrupoAtendimento),

    CONSTRAINT fk_FuncionarioGrupo FOREIGN KEY(idFuncionarioGrupo) 
    REFERENCES tbFuncionarioGrupo(idFuncionarioGrupo)
);

CREATE TABLE if not exists tbFuncionario
(
    idFuncionario           int(6) AUTO_INCREMENT,
    nome                    varchar(100) not null,
    cpf                     varchar(14) not null,
    dataContratacao         varchar(100) not null,
    matricula               int(20) not null,
    email                   varchar(100) not null,

    idFuncionarioGrupo          int(6),
    idCategoriaInativacao       int(6),
    idUsuario                   int(6),
    idUsuarioDoResponsavel      int(6) not null,
    
    CONSTRAINT PRIMARY KEY(idFuncionario)
);


CREATE TABLE if not exists tbUsuario(
    idUsuario       int(6) AUTO_INCREMENT,
    nome            varchar(100) not null,
    senha           varchar(100) not null,
    idPerfilUsuario        int not null,

    CONSTRAINT PRIMARY KEY(idUsuario)
);

CREATE TABLE IF NOT EXISTS tbPerfil(
    idPerfil            int(6) AUTO_INCREMENT,
    nome                varchar(100) not null,
    idPerfilUsuario     int,

    CONSTRAINT PRIMARY KEY(idPerfil)
);

CREATE TABLE IF NOT EXISTS tbPerfilUsuario(
    idPerfilUsuario         int(6) AUTO_INCREMENT,
    idPerfil                int(6) not null,
    idUsuario               int(6) not null,

    CONSTRAINT PRIMARY KEY(idPerfilUsuario)
);

CREATE TABLE if not exists tbChamado
 (
    idChamado           int(6) AUTO_INCREMENT,
    nome                varchar(100) not null,
    descricao           varchar(200),
    dataInicio          varchar(50) not null,
    dataFechamento      varchar(50) not null,
    idGrupoAtendimento  int(6) not null,
    idCategoria         int(6) not null,
    statusChamado       varchar(100) not null,
    detalhesChamado blob, 

    CONSTRAINT PRIMARY KEY(idChamado)
);

CREATE TABLE IF NOT EXISTS tbConhecimento(
    idConhecimento          int(6) AUTO_INCREMENT,
    nome                    varchar(100) not null,
    descricao               varchar(150),
    tags                    varchar(200),
    idChamado               int not null,
    idUsuarioResponsavel    int not null,

    CONSTRAINT PRIMARY KEY(idConhecimento)
);

ALTER TABLE tbFuncionarioGrupo
ADD CONSTRAINT fk_Funcionario FOREIGN KEY(idFuncionario)
REFERENCES tbFuncionario(idFuncionario);

ALTER TABLE tbFuncionarioGrupo
ADD CONSTRAINT fk_GrupoAtendimento FOREIGN KEY(idGrupoAtendimento)
REFERENCES tbGrupoAtendimento(idGrupoAtendimento);

ALTER TABLE tbFuncionario
ADD CONSTRAINT fk_CategoriaItativacao FOREIGN KEY(idCategoriaInativacao)
REFERENCES tbCategoriaInativacao(idCategoriaInativacao);

ALTER TABLE tbFuncionario
ADD CONSTRAINT fk_Usuario FOREIGN KEY(idUsuario)
REFERENCES tbUsuario(idUsuario);

ALTER TABLE tbFuncionario
ADD CONSTRAINT fk_UsuarioResponsavel FOREIGN KEY(idUsuarioDoResponsavel)
REFERENCES tbUsuario(idUsuario);

ALTER TABLE tbFuncionario
ADD CONSTRAINT fk_FuncionarioGrup FOREIGN KEY(idFuncionarioGrupo) 
REFERENCES tbFuncionarioGrupo(idFuncionarioGrupo);

ALTER TABLE tbPerfil
ADD CONSTRAINT fk_PerfilUsuario_p FOREIGN KEY(idPerfilUsuario)
REFERENCES tbPerfilUsuario(idPerfilUsuario);

ALTER TABLE tbUsuario
ADD CONSTRAINT fk_PerfilUsuario_u FOREIGN KEY(idPerfilUsuario)
REFERENCES tbPerfilUsuario(idPerfilUsuario);

ALTER TABLE tbFuncionarioGrupo
ADD CONSTRAINT fk_Funcionario_fg FOREIGN KEY(idFuncionario)
REFERENCES tbFuncionario(idFuncionario);

ALTER TABLE tbFuncionarioGrupo
ADD CONSTRAINT fk_GrupoAtendimento_fg FOREIGN KEY(idGrupoAtendimento)
REFERENCES tbGrupoAtendimento(idGrupoAtendimento);

ALTER TABLE tbChamado
ADD CONSTRAINT fk_GrupoAtendimento_chamado FOREIGN KEY(idGrupoAtendimento)
REFERENCES tbGrupoAtendimento(idGrupoAtendimento);

ALTER TABLE tbChamado
ADD CONSTRAINT fk_Categoria_chamado FOREIGN KEY(idCategoria)
REFERENCES tbCategoria(idCategoria);

ALTER TABLE tbChamado
ADD CONSTRAINT fk_GrupoAtendimento FOREIGN KEY(idGrupoAtendimento)
REFERENCES tbGrupoAtendimento(idGrupoAtendimento);

ALTER TABLE tbConhecimento
ADD CONSTRAINT fk_Chamado_conhecimento FOREIGN KEY(idChamado)
REFERENCES tbChamado(idChamado);

ALTER TABLE tbConhecimento
ADD CONSTRAINT fk_UsuarioResponsavel_conhecimento FOREIGN KEY(idUsuarioResponsavel)
REFERENCES tbUsuario(idUsuario);