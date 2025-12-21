@RestController
@RequestMapping("/api/sales")
@Tag(name = "Sales Transactions")
public class SaleTransactionController {

    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public SaleTransaction log(@RequestBody SaleTransaction transaction) {
        return service.logTransaction(transaction);
    }

    @GetMapping("/{id}")
    public SaleTransaction getById(@PathVariable Long id) {
        return service.getTransactionById(id);
    }

    @GetMapping("/code/{codeId}")
    public List<SaleTransaction> getByCode(@PathVariable Long codeId) {
        return service.getSalesForCode(codeId);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<SaleTransaction> getByInfluencer(@PathVariable Long influencerId) {
        return service.getSalesForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<SaleTransaction> getByCampaign(@PathVariable Long campaignId) {
        return service.getSalesForCampaign(campaignId);
    }
}
