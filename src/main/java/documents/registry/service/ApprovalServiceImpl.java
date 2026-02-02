package documents.registry.service;

import documents.registry.data.ApprovalStatuses;
import documents.registry.data.dto.ApprovalRequest;
import documents.registry.data.dto.ApprovalResponse;
import documents.registry.data.entity.Approval;
import documents.registry.data.repository.ApprovalRepository;
import documents.registry.mapper.ApprovalMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@Slf4j
public class ApprovalServiceImpl implements ApprovalService {

    private final ApprovalRepository approvalRepository;
    private final ApprovalMapper approvalMapper;
    private final TransactionTemplate transactionTemplate;

    public ApprovalServiceImpl(ApprovalRepository approvalRepository,
                               ApprovalMapper approvalMapper,
                               TransactionTemplate transactionTemplate) {
        this.approvalRepository = approvalRepository;
        this.approvalMapper = approvalMapper;
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public ApprovalResponse approve(ApprovalRequest request) {
        try {
            return transactionTemplate.execute(status -> {
                Approval approval = approvalMapper.requestToApproval(request);
                approvalRepository.save(approval);
                log.info("Document successfully approved " + request.documentExternalId());
                return new ApprovalResponse(request.documentExternalId(), ApprovalStatuses.APPROVED);
            });
        } catch (Exception e) {
            log.info("Approval rejected for Document " + request.documentExternalId(), e);
            return new ApprovalResponse(request.documentExternalId(), ApprovalStatuses.REJECTED);
        }


    }

}
