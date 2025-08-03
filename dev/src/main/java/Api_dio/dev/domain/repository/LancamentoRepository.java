package Api_dio.dev.domain.repository;

import Api_dio.dev.domain.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
