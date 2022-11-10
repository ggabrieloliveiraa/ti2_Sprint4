CREATE TABLE IF NOT EXISTS usuario (
  codigo INT NOT NULL,
  username VARCHAR(16) NOT NULL,
  email VARCHAR(45) NOT NULL,
  senha VARCHAR(32) NOT NULL,
  PRIMARY KEY (codigo))
  
  CREATE TABLE IF NOT EXISTS receita (
  idReceita INT UNIQUE NOT NULL,
  Nome VARCHAR(45) NOT NULL,
  Serve INT NOT NULL,
  Dificuldade INT NOT NULL,
  TempoDePreparo INT NOT NULL,
  ModoDePreparo TEXT NOT NULL,
  Imagem VARCHAR(200) NULL,
  Categoria INT NOT NULL,
  UsuarioPublicador_codigo INT NOT NULL,
  PRIMARY KEY (idReceita, UsuarioPublicador_codigo),
  CONSTRAINT fk_Receita_Usuario
    FOREIGN KEY (UsuarioPublicador_codigo)
    REFERENCES public.usuario (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

CREATE TABLE IF NOT EXISTS ingrediente (
  idingrediente INT NOT NULL,
  Nome VARCHAR(45) NOT NULL,
  Tipo INT NOT NULL,
  PRIMARY KEY (idingrediente))

CREATE TABLE IF NOT EXISTS ingrediente_receita (
  Ingrediente_idIngrediente INT NOT NULL,
  Quantidade INT NOT NULL,
  receita_idReceita INT NOT NULL,
  PRIMARY KEY (Ingrediente_idIngrediente, receita_idReceita),
  CONSTRAINT fk_IngredienteDaReceita_Ingrediente1
    FOREIGN KEY (Ingrediente_idIngrediente)
    REFERENCES public.ingrediente (idingrediente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ingrediente_receita_receita1
    FOREIGN KEY (receita_idReceita)
    REFERENCES public.receita (idReceita)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    
    
    
