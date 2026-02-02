package documents.registry.data.dto;

import documents.registry.data.ApprovalStatuses;

import java.util.UUID;

public record ApprovalResponse
        (UUID documentExternalId,
         ApprovalStatuses status) {

}
