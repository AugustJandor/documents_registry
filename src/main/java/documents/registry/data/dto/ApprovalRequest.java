package documents.registry.data.dto;

import java.util.UUID;

public record ApprovalRequest
        (UUID documentExternalId,
         String commentary) {
}
