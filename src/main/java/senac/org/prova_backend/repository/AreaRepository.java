package senac.org.prova_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import senac.org.prova_backend.domain.Area;
import senac.org.prova_backend.vo.AreaTotal;

/**
*
* @author Christian
*/

public interface AreaRepository extends JpaRepository<Area, Integer>{
	
	@Query("select new senac.org.prova_backend.vo.AreaTotal(a.nome, sum(p.orcamento), count(a.nome), avg(p.prazo)) "
			+ " from Projeto p "
			+ " inner join p.area a "
			+ " group by a.nome")
	List<AreaTotal> findAreaTotal();	
}
