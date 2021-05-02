package net.seifhadjhassen.project.repositories;

import net.seifhadjhassen.project.models.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TableRepository extends JpaRepository<TableEntity,Integer> {

    @Query(nativeQuery = true,value = "select desk.*,count(*) as nbcountt from desk inner join ticket on ticket.table_numero=desk.numero group by ticket.table_numero " +
            "HAVING nbcountt=" +
            "(SELECT max(t.nbcount) from " +
            "(SELECT ticket.*,count(*) as nbcount from ticket group by ticket.table_numero) as t)")
    List<TableEntity> plusReerver();
}
