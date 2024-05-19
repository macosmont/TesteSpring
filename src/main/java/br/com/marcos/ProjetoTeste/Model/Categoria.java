package br.com.marcos.ProjetoTeste.Model;

public enum Categoria {
    ACAO("Action","Ação"),
    COMEDIA("Comedy", "Comédia"),
    ANIMACAO("Animation", "Animação"),
    DRAMA("Drama", "Drama"),
    CRIME("Crime", "Crime");

    private String categoriaOmdb;
    private String categoriaBrasil;
    Categoria (String categoriaOmdb, String categoriaBrasil){
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaBrasil = categoriaBrasil;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

    public static Categoria fromBrasil(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaBrasil.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

}
