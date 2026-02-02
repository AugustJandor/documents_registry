package documents.registry.controller;

import documents.registry.data.dto.ApprovalRequest;
import documents.registry.data.dto.ApprovalResponse;
import documents.registry.service.ApprovalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("approval")
public class ApprovalController {

    private final ApprovalService approvalService;

    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @PostMapping("/approve")
    public ResponseEntity<ApprovalResponse> approve(@RequestBody ApprovalRequest request){
        return new ResponseEntity<>(approvalService.approve(request), HttpStatus.CREATED);
    }


}
