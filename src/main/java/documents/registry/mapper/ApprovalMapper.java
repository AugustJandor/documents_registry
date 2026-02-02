package documents.registry.mapper;

import documents.registry.data.dto.ApprovalRequest;
import documents.registry.data.entity.Approval;
import org.springframework.stereotype.Component;

@Component
public class ApprovalMapper {

    public Approval requestToApproval(ApprovalRequest request){
        Approval approval = new Approval();
        approval.setDocumentExternalId(request.documentExternalId());
        approval.setCommentary(request.commentary());
        return approval;
    }



}
