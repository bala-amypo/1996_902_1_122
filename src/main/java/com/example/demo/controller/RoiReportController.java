@RestController
@RequestMapping("/api/roi")
@Tag(name = "ROI Reports")
public class RoiReportController {

    private final RoiService service;

    public RoiReportController(RoiService service) {
        this.service = service;
    }

    @PostMapping("/generate/{codeId}")
    public RoiReport generate(@PathVariable Long codeId) {
        return service.generateRoiForCode(codeId);
    }

    @GetMapping("/{id}")
    public RoiReport getById(@PathVariable Long id) {
        return service.getReportById(id);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<RoiReport> getByInfluencer(@PathVariable Long influencerId) {
        return service.getReportsForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<RoiReport> getByCampaign(@PathVariable Long campaignId) {
        return service.getReportsForCampaign(campaignId);
    }
}
