package documents.registry.service;

import documents.registry.data.dto.ApprovalRequest;
import documents.registry.data.dto.ApprovalResponse;

public interface ApprovalService {

    ApprovalResponse approve(ApprovalRequest request);

}
