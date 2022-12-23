package siscove.siscovejava.Produto.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Produto.Dto.ProdutoAutoDto;
import siscove.siscovejava.Produto.Entity.Produto;
import siscove.siscovejava.Produto.Repository.ProdutoRepository;
 
@Repository(value="ProdutoDao")
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<ProdutoAutoDto> getListaProdutosAuto(String termo){
		StringBuilder sb = new StringBuilder();
		sb.append("select NRO_SEQUENCIAL, "
			+ "	   COD_PRODUTO, "
			+ "		concat(DSC_PRODUTO, ' Tipo: ', situacao , ' Marca: ', "
			+ "              DSC_MARCA, ' Valor: ', VLR_VENDA, ' Estoque: ', QTD_ESTOQUE) as DSC_PRODUTO, "
			+ "       VLR_VENDA, "
			+ "       QTD_ESTOQUE "
			+ "  from ( "
			+ "select e.NRO_SEQUENCIAL , "
			+ "       p.COD_PRODUTO, "
			+ "       p.DSC_PRODUTO, "
			+ "       m.DSC_MARCA, "
			+ "       eee.VLR_VENDA, "
			+ "       e.QTD_ESTOQUE, "
			+ "       case when p.IND_SITUACAO_PRODUTO='N' then 'Novo' else 'Semi-Novo' end as situacao "
			+ "  from en_estoque e "
			+ " inner join en_produto p on e.COD_PRODUTO = p.COD_PRODUTO  "
			+ "   and e.QTD_ESTOQUE >0 "
			+ " inner join en_marca m on p.COD_MARCA = m.COD_MARCA  "
			+ " inner join en_entrada_estoque eee on e.COD_PRODUTO = eee.COD_PRODUTO  "
			+ "   and e.NRO_SEQUENCIAL = eee.NRO_SEQUENCIAL"
			+ "   AND P.IND_ATIVO = 'S') as x WHERE DSC_PRODUTO like '%"+termo+"%'");
		List<Object[]> lista = em.createNativeQuery(sb.toString()).getResultList();
		
		
		List<ProdutoAutoDto> listaRetorno = new ArrayList<ProdutoAutoDto>();
		for (Object[] item : lista) {
			ProdutoAutoDto dto = new ProdutoAutoDto();
			dto.setNroSequencial((Integer) item[0]);
			dto.setCodProduto((Integer) item[1]);
			dto.setDscProduto(item[2].toString());
			dto.setVlrVenda((Float) item[3]);
			dto.setQtdEstoque((int) Math.round((float) item[4]));
			listaRetorno.add(dto);
		}
		
		return listaRetorno;
	}

	public List<Produto> findByDscProduto(String dscProduto) {
		
		List<Produto> listarProdutos = produtoRepository.findBydscProduto(dscProduto);
		
		return listarProdutos;
	}

}
