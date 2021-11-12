package br.com.tci;

/**
 * Classe de interface dos métodos CRUD
 * 
 * @author Grupo Lovelace - XV
 * @param <T> Paramêtro da classe
 * @version 1.0
 */
public interface BaseRepository<T> {

	/**
	 * Método para retorno da instância
	 * 
	 * @param id único da instância
	 * @return instância da classe
	 */
	public T Get(int id);

	/**
	 * Método para adcionar instância
	 * 
	 * @param Instância que será adcionada
	 */
	public void Add(T type);

	/**
	 * Método para atualizar instância
	 * 
	 * @param Instância que será atualizada
	 */
	public void Update(T type);

	/**
	 * Método para deletar uma instância
	 * 
	 * @param Instância que séra deletada
	 */
	public void Delete(T type);
}
