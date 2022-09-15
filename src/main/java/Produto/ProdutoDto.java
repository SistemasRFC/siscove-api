package Produto;

public class ProdutoDto {
	
	private Integer codTipoPoroduto;
	private String dscTipoProduto;
	private String indAtivo;
	private Integer codClienteFinal;
	
	public static Produto parse(ProdutoDto produtoDto) {
		Produto produto = new Produto();
		produto.setCodTipoProduto(produtoDto.getCodTipoProduto());
		produto.setDscTipoProduto(produtoDto.getDscTipoProduto());
		produto.setIndAtivo(produtoDto.getIndAtivo());
		produto.setCodClienteFinal(produtoDto.getCodClienteFinal());
		return produto;
	}

	public static ProdutoDto build(Produto produto) {
		ProdutoDto produtoDto = new ProdutoDto(
		produto.getCodTipoProduto(), 
		produto.getDscTipoProduto(),
		produto.getIndAttivo(),
		produto.getCodClienteFinal(),,
		null);
		return produtoDto;
	}

}
