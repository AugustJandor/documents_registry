package documents.registry.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "approvals", schema = "data")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Approval extends BaseEntity {

    @Column(name = "document_external_id", nullable = false, unique = true)
    private UUID documentExternalId;

    @Column(name = "commentary")
    private String commentary;

}
