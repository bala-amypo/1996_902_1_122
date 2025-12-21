@RestController
@RequestMapping("/api/discount-codes")
@Tag(name = "Discount Codes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    @PostMapping
    public DiscountCode create(@RequestBody DiscountCode code) {
        return service.createDiscountCode(code);
    }

    @PutMapping("/{id}")
    public DiscountCode update(@PathVariable Long id,
                               @RequestBody DiscountCode code) {
        return service.updateDiscountCode(id, code);
    }

    @GetMapping("/{id}")
    public DiscountCode getById(@PathVariable Long id) {
        return service.getDiscountCodeById(id);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<DiscountCode> getByInfluencer(@PathVariable Long influencerId) {
        return service.getCodesByInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<DiscountCode> getByCampaign(@PathVariable Long campaignId) {
        return service.getCodesByCampaign(campaignId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateCode(id);
    }
}
