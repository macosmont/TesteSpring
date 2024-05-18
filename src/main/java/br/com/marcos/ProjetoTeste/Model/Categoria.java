package br.com.marcos.ProjetoTeste.Model;

public enum Categoria {
    ACAO("Action"),
    COMEDIA("Comedy"),
    ANIMACAO("Animation"),
    DRAMA("Drama"),
    CRIME("Crime");

    private String categoriaOmdb;
    Categoria (String categoriaOmdb){
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

}
