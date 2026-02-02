package documents.registry.data.repository;

import documents.registry.data.entity.Approval;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApprovalRepository extends JpaRepository<Approval, UUID> {

}
