package br.com.marcos.ProjetoTeste.Servicos;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
